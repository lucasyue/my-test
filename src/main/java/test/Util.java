package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util{
	public String formatDate(Date date,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}