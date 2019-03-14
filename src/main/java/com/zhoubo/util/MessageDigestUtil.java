package com.zhoubo.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.MessageDigest;


/*
 * 消息摘要核心类：MessageDigest
 * 注意①：不论原文长度多少，加密后的密文都是字节
 * ②：原始密码长度为16字节
 */
public class MessageDigestUtil {
	
	public static void main(String[] args) {
		String input = "hello MessageDigest MD5 and SHA-1";//原文
//		String str = md5(input);
//		System.out.println(str);
//		String str1 = md5File("F:/JavaIoTest/Test1.txt");
//		System.out.println(str1);
		String str2 = sha1(input);
		System.out.println(str2);
		
	}

	/*
	 * @param string input 原文
	 * 注意：该方法中已经调用tohex方法将字节数组转成16进制的字符串
	 * 引用场景：密码登录，不可逆数据
	 */
	public static String md5(String input) {
		try {
			//创建消息摘要对象
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md5 = messageDigest.digest(input.getBytes());
			StringBuilder sb = toHex(md5);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 转成16进制
	 * @param byte[] input 
	 * 
	 */
	public static StringBuilder toHex(byte[] input) {
		try {
			//返回值不是16进制，需要进行转化
			StringBuilder stringBuilder = new StringBuilder();
			for(byte b : input){
				int value = b & 0xff;//转成16进制
				String hexString = Integer.toHexString(value);
				//当16进制字符串长度不是两位数，前面补0
				if(hexString.length() == 1){
					stringBuilder.append("0");
				}
				stringBuilder.append(hexString);
			}
			return stringBuilder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 读取文件MD5摘要
	 * @param filePath
	 * @return string
	 * 应用场景：文件唯一性，病毒判断
	 */
	public static String md5File(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			byte[] buff = new byte[1024];//缓冲区
			int len = 0;
			ByteArrayOutputStream baso = new ByteArrayOutputStream();
			while((len = fis.read(buff)) != -1){
				baso.write(buff, 0, len);
			}
			//创建消息摘要对象
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md5 = messageDigest.digest(baso.toByteArray());
			StringBuilder sb = toHex(md5);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 消息摘要sha1算法
	 * 最后的结果最好都转成16进制
	 * 原始密文长度是20字节，转成16进制之后是40字节
	 */
	public static String sha1(String input) {
		try {
			//创建消息摘要对象
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] md5 = messageDigest.digest(input.getBytes());
			StringBuilder sb = toHex(md5);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 消息摘要SHA-256 
	 * 原始密文长度32字节，加密后64字节
	 */
	public static String sha256(String input) {
		try {
			//创建消息摘要对象
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] md5 = messageDigest.digest(input.getBytes());
			StringBuilder sb = toHex(md5);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
