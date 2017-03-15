package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		Date rDate=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		label:
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					break label;
				}
				System.out.println("j"+j);
			}
			System.out.println(i);
		}
		
		//String username=null;
		String username="chenyijing";
		//String username="admin";
		//String username="12345678901234567890";
		//String username="";
		try {
			//username=NedmDbstrService.aesEncrypt("admin");
			//String rs = NedmDbstrService.aesDecrypt(username);
			//System.out.println("u "+username+","+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
