package com.zhoubo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date date,String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String stringDate = simpleDateFormat.format(date);
		return stringDate;
	}

	public static Date stringToDate(String stringDate,String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		Date date=null;
		try{
		date=simpleDateFormat.parse(stringDate);
		}catch(ParseException e){
		e.printStackTrace();
		}
	return date;
	}

	/*
	*将sql中的timestamp转为string
	**/
	public static String timestampToString(Timestamp timestamp,String dateFormat){
		if(timestamp==null||dateFormat==null){
		return"参数校验失败";
		}else{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

		String dateString = simpleDateFormat.format(timestamp);
		return dateString;
		}
		
	}

	/*
	*String转TimeStamp必须要先转为date，再用date.getTime方法转为timestamp
	*dateFormat是要转的日期格式
	**/
	public static Timestamp stringToTimestamp(String stringDate,String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		Date date =null;
		try{
		date = simpleDateFormat.parse(stringDate);
		}catch(ParseException e){
		e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
		}
		/*
		*将Timestamp转为date
		*二者是父与子的关系，可以直接转。
		**/
		public static Date timeToDate(Timestamp timestamp,String dateFormat){
		return timestamp;
	}

	/*
	*Date转Timestamp
	**/


	public static Timestamp dateToTimestamp(Date date,String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String stringDate=simpleDateFormat.format(date);
		Date date1=null;
		try{
		date1=simpleDateFormat.parse(stringDate);
		}catch(ParseException e){
		e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(date1.getTime());
		return timestamp;
		}
}
