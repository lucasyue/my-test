package test.svn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNDiffStatusHandler;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNDiffClient;
import org.tmatesoft.svn.core.wc.SVNDiffStatus;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNStatusType;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNUtil {

	public static void main(String[] args) {
		String svnRoot="svn://10.21.200.52/歌斐运营控制系统_PA71/Source/trunk/oc";
		String username="yueyanjie";
		String password="noah.11183";
		SVNClientManager svnClient = authSvn(svnRoot, username, password);
//		String wcPath = "D:/projects/nuoya/oc";
//		File wcFile = new File(wcPath);
//		String outlog = "D:/outlog.txt";
//		File outlogFile = new File(outlog);
//		FileOutputStream out = null;
//		Collection<String> changeLists = new HashSet<String>();
		Collection<String> conflictedLists = new HashSet<String>();
			SVNDiffClient diffClient=svnClient.getDiffClient();
			ISVNDiffStatusHandler myHandler=new ISVNDiffStatusHandler() {
				@Override
				public void handleDiffStatus(SVNDiffStatus diffStatus) throws SVNException {
					SVNStatusType modType=diffStatus.getModificationType();
					if(SVNStatusType.CONFLICTED.equals(modType)){
						conflictedLists.add(diffStatus.getPath());
				        System.out.println(diffStatus.getPath());
					}
				}
			};
			File ff=new File(svnRoot);
			try {
				SVNURL url=SVNURL.fromFile(ff);
				diffClient.doDiffStatus(url, SVNRevision.HEAD, url, SVNRevision.PREVIOUS, SVNDepth.INFINITY, true, myHandler);
			} catch (SVNException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//try {
//			svnChClient.doGetChangeLists(wcFile, changeLists, SVNDepth.INFINITY, handler);
//		} catch (SVNException e) {
//			e.printStackTrace();
//		}
//		System.out.println(StringUtils.join(changeLists,","));
//		SVNDiffClient diffClient=svnClient.getDiffClient();
//		String dir="D:/projects/nuoya/oc_dev2.0_latest/";
//		String dirLog="D:/projects/nuoya/oc_dev2.0_latest/out.log";
//		File dirFile=new File(dir);
//		File[] path1 = dirFile.listFiles();
//		SVNRevision path2 = SVNRevision.HEAD;
//		OutputStream result = null;
//		Collection<String> changeLists = new HashSet<String>();
//		SVNDepth depth = null;
//		try {
//			File log=new File(dirLog);
//			log.createNewFile();
//			result = new FileOutputStream(log);
//			diffClient.doDiff(path1, SVNRevision.HEAD, path2, SVNRevision.WORKING, depth, false, result, changeLists);
//		} catch (SVNException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally{
//			if(result!=null){
//				try {
//					result.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
    private static void svn(){}
	private static void doDiff(SVNClientManager svnClient,OutputStream outStream) {
		String wcPath = "D:/projects/nuoya/oc";
		File wcFile = new File(wcPath);
//		//String outlog = "D:/outlog.txt"; 
//		File outlogFile = new File(outlog);
//		FileOutputStream out = null;
		Collection<String> changeLists = new HashSet<String>();
		try {
//			outlogFile.createNewFile();
//			out=new FileOutputStream(outlogFile);
			SVNDiffClient diffClient=svnClient.getDiffClient();
			diffClient.doDiff(wcFile, SVNRevision.WORKING, SVNRevision.WORKING, SVNRevision.HEAD, SVNDepth.INFINITY, false, outStream, changeLists); 
	        System.out.println(changeLists);
		} catch (SVNException e) {
			e.printStackTrace();
		} finally{
			try {
				if(outStream!=null)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void checkOut(String svnRoot, SVNClientManager svnClient) {
		SVNUpdateClient updateClient=svnClient.getUpdateClient();
		String wcPath="D:/testsvn";
		File wcFile =new File(wcPath);
		SVNURL url;
		try {
			url = SVNURL.parseURIEncoded(svnRoot);
			updateClient.doCheckout(url, wcFile, SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY,false);
		} catch (SVNException e1) {
			e1.printStackTrace();
		}
	}
	
	private static Logger logger = LoggerFactory.getLogger(SVNUtil.class);

	/**
	 * 通过不同的协议初始化版本库
	 */
	public static void setupLibrary() {
		DAVRepositoryFactory.setup();
		SVNRepositoryFactoryImpl.setup();
		FSRepositoryFactory.setup();
	}
	
	/**
	 * 验证登录svn
	 */
	public static SVNClientManager authSvn(String svnRoot, String username, String password) {
		// 初始化版本库
		setupLibrary();

		// 创建库连接
		SVNRepository repository = null;
		try {
			repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svnRoot));
		} catch (SVNException e) {
			logger.error(e.getMessage());
			return null;
		}

		// 身份验证
		ISVNAuthenticationManager authManager = SVNWCUtil
				.createDefaultAuthenticationManager(username, password.toCharArray());
		// 创建身份验证管理器
		repository.setAuthenticationManager(authManager);

		DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);
		SVNClientManager clientManager = SVNClientManager.newInstance(options, authManager);
		return clientManager;
	}
}