package test.ssh;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.jcraft.jsch.ChannelSftp;

import test.AESHelper;

public class SFTPUploader {

    public SFTPChannel getSFTPChannel() {
        return new SFTPChannel();
    }
    /**
     * @param args
     * @throws Exception
     */
    String localBaseDir = "D:\\projects\\nuoya\\升级代码\\auto-upload";
    String remoteBaseDir1 = "/usr/local/tomcat-7.0.39/webapps/oc/WEB-INF/classes"; // 目标文件名
    String remoteBaseDir = remoteBaseDir1 + "/com/gopher/oc"; // 目标文件名
    int count = 0;
    int errorCount = 0;
    public static void main(String[] args) throws Exception {
        SFTPUploader deployer = new SFTPUploader();
        Map<String, String> sftpDetails = new HashMap<String, String>();
        String pwd1 = "CBFCFE0B5DAFA30C731A961520190C15";
        String pwd2 = AESHelper.decryptStr(pwd1, "123");
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "10.21.200.139");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "gyc7480");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, pwd2);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");
        SFTPChannel channel = deployer.getSFTPChannel();
        ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
        /**
         * 代码段1
        OutputStream out = chSftp.put(dst, ChannelSftp.OVERWRITE); // 使用OVERWRITE模式
        byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
        int read;
        if (out != null) {
            System.out.println("Start to read input stream");
            InputStream is = new FileInputStream(src);
            do {
                read = is.read(buff, 0, buff.length);
                if (read > 0) {
                    out.write(buff, 0, read);
                }
                out.flush();
            } while (read >= 0);
            System.out.println("input stream read done.");
        }
        **/
        File localBaseDirFile = new File(deployer.localBaseDir);
        Map<String, String> upFiles = new HashMap<String, String>();
        deployer.getDstPaths(localBaseDirFile, upFiles);
        System.out.println("待上传" + upFiles.size() + "个文件");
        for(Entry<String, String> upFile : upFiles.entrySet()){
        	System.out.println("transfer "+upFile);
        	try {
				chSftp.put(upFile.getKey(), upFile.getValue(), ChannelSftp.OVERWRITE); // 代码段2
				deployer.count++;
			} catch (Exception e) {
				deployer.errorCount++;
	        	System.out.println("transfer error " + upFile);
				e.printStackTrace();
			}
        }
        System.out.println("成功上传" + deployer.count + "个文件");
        System.out.println("上传失败" + deployer.errorCount + "个文件");
        // chSftp.put(new FileInputStream(src), dst, ChannelSftp.OVERWRITE); // 代码段3
        chSftp.quit();
        channel.closeChannel();
    }
    private void getDstPaths(File localBaseDirFile, Map<String, String>dstPaths){
    	File[] upFiles = localBaseDirFile.listFiles();
        for(File upFile : upFiles){
            if(upFile.isDirectory()){
            	getDstPaths(upFile, dstPaths);
            }else{
            	if("Global.model.xml".equals(upFile.getName())){
            		 String dstPath = remoteBaseDir1 + upFile.getAbsolutePath().replace(localBaseDir, "").replaceAll("\\\\", "/");
         	         dstPaths.put(upFile.getAbsolutePath(), dstPath);
            	} else {
           	        String dstPath = remoteBaseDir + upFile.getAbsolutePath().replace(localBaseDir, "").replaceAll("\\\\", "/");
        	        dstPaths.put(upFile.getAbsolutePath(), dstPath);
            	}
            }
        }
    }
}