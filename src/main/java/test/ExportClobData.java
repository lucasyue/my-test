package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportClobData {
    public static void main(String[] args) {
        //exportClobTemplate();
		exportUFLOData();
	}

	private static void exportUFLOData() {
		Connection con=DBUtil.getCon();
    	String codeFiled = "id_";
		String clobField = "blob_value_";
		String sql = "select " + codeFiled + ","+ clobField +" from uflo_blob where name_ is not null and process_id_ not in('223','158141','263141','20386')";
		try {
			getBlobData(con, sql, codeFiled, clobField, "uflo_blob");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseCon(con);
		}
	}
    
	public static void exportClobTemplate() {
		Connection con=DBUtil.getCon();
		try{
			String codeFiled = "code_";
			String clobField = "template_";
			String sql = "select " + codeFiled + ","+ clobField +" from oc_notice_template where code_ in('incomeDistributionSMS-PE','incomeDistributionSMS-RE','maturityDistributionSMS-RE','AdvDelayDueToDistributionSMS-RE')";//where code_='setUpNoticeFollUpToInitInvest-RE'";
			getClobData(con, sql, codeFiled, clobField, "noticeTemplate1");
			codeFiled = "id_";
			clobField = "template_";
			//sql = "select " + codeFiled + ","+ clobField +" from oc_email_template where category_id_='Notice'";//where code_='setUpNoticeFollUpToInitInvest-RE'";
			//getClobData(con, sql, codeFiled, clobField, "Email");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseCon(con);
		}
	}
	private static void getBlobData(Connection con, String sql, String codeFiled, String clobFiled, String type) throws SQLException {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		int count=0;
		while(rs.next()){
			String code=rs.getString(codeFiled);
			Blob blob=rs.getBlob(clobFiled);
			if(blob.length()>0){
				saveToFile(type, code, blob);
				count++;
			}
		}
		System.out.println("共导出"+type+"数据"+count+"条");
		rs.close();
		ps.close();
	}
	
	private static void getClobData(Connection con, String sql, String codeFiled, String clobFiled, String type) throws SQLException {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		int count=0;
		while(rs.next()){
			String code=rs.getString(codeFiled);
			Clob clob=rs.getClob(clobFiled);
			if(clob.length()>0){
				saveToFile(type, code, clob);
				count++;
			}
		}
		System.out.println("共导出"+type+"数据"+count+"条");
		rs.close();
		ps.close();
	}
	
	private static void saveToFile(String dir,String code, Blob blob) {
		File fd=new File("D:\\projects\\nuoya\\transferData\\"+dir);
		if(!fd.exists()){
			fd.mkdir();
		}
		File f=new File("D:\\projects\\nuoya\\transferData\\"+dir+"\\"+code+".html");
		FileOutputStream fos=null;
		try {
			f.createNewFile();
			fos=new FileOutputStream(f);
			InputStream is = blob.getBinaryStream();
			//long size=((BLOB)blob).getBufferSize();
			//OracleBlob oblob = (OracleBlob) blob;
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
			    fos.write(buffer, 0, len);
			}
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void saveToFile(String dir,String code, Clob clob) {
		File fdir=new File("D:\\projects\\nuoya\\transferData\\"+dir);
		if(!fdir.exists()){
			fdir.mkdir();
		}
		File f=new File("D:\\projects\\nuoya\\transferData\\"+dir+"\\"+code+".html");
		FileWriter fw=null;
		try {
			f.createNewFile();
			fw=new FileWriter(f);
			char chars[]=new char[(int)clob.length()];
			clob.getCharacterStream().read(chars);
			fw.write(chars);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
