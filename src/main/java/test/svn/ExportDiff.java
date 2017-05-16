package test.svn;  
  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.HashSet;  
import java.util.Iterator;  
  
import org.tmatesoft.svn.core.SVNDepth;  
import org.tmatesoft.svn.core.SVNException;  
import org.tmatesoft.svn.core.SVNURL;  
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;  
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;  
import org.tmatesoft.svn.core.wc.ISVNDiffStatusHandler;  
import org.tmatesoft.svn.core.wc.SVNDiffClient;  
import org.tmatesoft.svn.core.wc.SVNDiffStatus;  
import org.tmatesoft.svn.core.wc.SVNInfo;  
import org.tmatesoft.svn.core.wc.SVNRevision;  
import org.tmatesoft.svn.core.wc.SVNStatusType;  
import org.tmatesoft.svn.core.wc.SVNUpdateClient;  
import org.tmatesoft.svn.core.wc.SVNWCClient;  
import org.tmatesoft.svn.core.wc.SVNWCUtil;  
  
public class ExportDiff {
  
    //URL  
    public SVNURL URL = null;  
    public String branchURL = null;  
    public String userName = null;  
    public String passWord = null;  
    public String exportPath = null;  
    public SVNRevision startingRevision;  
    public SVNRevision endingRevision;  
    private ISVNAuthenticationManager authManager;  
    public SVNDiffClient diffClient;  
    public static HashSet<SVNDiffStatus> changes =  new HashSet<SVNDiffStatus>();  
      
    //这是用例记录每次导出 后的svn版本， 下次导出 会以这个为起点  
    private String versionFile = "revision.txt";  
      
    public void execute(){  
          
        System.out.println("SVN地址: " + branchURL);  
          
        initSVN();  
      
    }  
  
    public void setExportPath(String exportPath){  
        this.exportPath = exportPath;  
    }  
      
    public void setBranchURL(String branchURL){  
        this.branchURL = branchURL;  
    }  
      
    public void setUsername(String userName){  
        this.userName = userName;  
    }  
      
    public void setPassWord(String passWord){  
        this.passWord = passWord;  
    }  
      
    public void initSVN(){  
          
        DAVRepositoryFactory.setup();  
        try {  
            URL = SVNURL.parseURIEncoded(branchURL);  
        } catch (SVNException e) {  
            e.printStackTrace();  
        }  
        this.startingRevision = getCurrentRevision();  
        this.endingRevision = getLastRevision();  
        this.authManager = SVNWCUtil.createDefaultAuthenticationManager(this.userName, this.passWord);  
        System.out.println("当前SVN版本号: " + startingRevision);  
        System.out.println("最新SVN版本号: " + endingRevision);  
        try {  
            start();  
        } catch (SVNException e) {  
            e.printStackTrace();  
        }  
  
    }  
      
    public void start() throws SVNException{  
        ImplISVNDiffStatusHandler handler = new ImplISVNDiffStatusHandler();  
        diffClient = new SVNDiffClient(authManager, null);  
  
        diffClient.doDiffStatus(this.URL, this.startingRevision,this.URL, this.endingRevision,  SVNDepth.INFINITY, false, handler);  
  
        SVNUpdateClient updateClient = new SVNUpdateClient(authManager, SVNWCUtil.createDefaultOptions(true));  
  
          
        Iterator<SVNDiffStatus> it = changes.iterator();  
        while(it.hasNext()){  
            SVNDiffStatus change = it.next();  
            System.out.println(exportPath+ change.getPath());  
            File destination = new File( exportPath + change.getPath());  
            updateClient.doExport(change.getURL(), destination, this.endingRevision, this.endingRevision, null, true,SVNDepth.INFINITY);  
        }  
          
        setFileText(versionFile, endingRevision.toString());  
          
    }  
      
    /** 
     * 获取最新版本号 
     * @return SVNRevision 
     */  
    private SVNRevision getLastRevision(){  
        SVNWCClient wcClient = new SVNWCClient(authManager,null);  
        SVNInfo info = null;  
        try {  
            info = wcClient.doInfo(URL, SVNRevision.HEAD, SVNRevision.HEAD);  
        } catch (SVNException e) {  
            e.printStackTrace();  
        }  
        return info.getCommittedRevision();  
    }  
      
    private SVNRevision getCurrentRevision(){  
        String revision = null;  
  
        try {  
            revision = getFileText(versionFile);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
        return SVNRevision.create(Long.parseLong(revision));  
          
    }  
  
    /** 
     * 对于文件内容 
     *  
     * @param 文件路径 
     * @return 文件内容 
     * @throws IOException 
     */  
    private String getFileText(String path) throws IOException {  
  
        File file = new File(path);  
  
        if (!file.exists() || file.isDirectory())  
        {  
            file.createNewFile();  
            setFileText(path,"0");  
        }  
          
        FileInputStream fis = new FileInputStream(file);  
        byte[] buf = new byte[1024];  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        int len;  
        while ((len = fis.read(buf)) != -1) {  
            baos.write(buf, 0, len);  
        }  
        // System.out.println(baos.toString());  
        fis.close();  
        return baos.toString();  
    }  
      
    /** 
     * 写入文件内容 
     * @param path 文件路径 
     * @param text 内容 
     */  
    private void setFileText(String path, String text){  
        FileOutputStream out = null;  
        try {  
            out = new FileOutputStream(new File(path));  
            out.write(text.getBytes());  
            out.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }     
    }  
  
}  
  
class ImplISVNDiffStatusHandler implements ISVNDiffStatusHandler {  
  
    public void handleDiffStatus(SVNDiffStatus status) throws SVNException {  
        if (status.getModificationType() == SVNStatusType.STATUS_ADDED || status.getModificationType() == SVNStatusType.STATUS_MODIFIED){  
            ExportDiff.changes.add(status);  
        }  
  
    }  
  
}  