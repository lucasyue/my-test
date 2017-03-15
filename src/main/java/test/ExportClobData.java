package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportClobData {
    public static void main(String[] args) {
    	getData();
	}
	public static void getData() {
		Connection con=DBUtil.getCon();
		try{
			String sql="select code_,template_ from oc_notice_template";//where code_='setUpNoticeFollUpToInitInvest-RE'";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
				String code=rs.getString("code_");
				Clob clob=rs.getClob("template_");
				if(clob.length()>0){
					saveToFile("noticeTemplate",code,clob);
					count++;
				}
			}
			System.out.println("共导出公告模板数据"+count+"条");
			count=0;
			String sql2="select id_,template_ from oc_email_template where category_id_='Notice'";
			ps=con.prepareStatement(sql2);
			rs=ps.executeQuery();
			while(rs.next()){
				String code=rs.getString("id_");
				Clob clob=rs.getClob("template_");
				if(clob.length()>0){
					saveToFile("noticeEmailTemplate",code,clob);
					count++;
				}
			}
			System.out.println("共导出公告Email模板数据"+count+"条");
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseCon(con);
		}
	}
	private static void saveToFile(String dir,String code, Clob clob) {
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
