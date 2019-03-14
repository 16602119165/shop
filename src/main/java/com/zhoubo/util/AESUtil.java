package com.zhoubo.util;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
/*
 * 对称加密：AES加密解密
 * 注意：①秘钥必须是16个字节；②加密后的密文长度是16字节的整数倍；
 * ③加密后字符长度发生改变，通常会乱码，一般使用Base64转换
 * ④：加密时使用了base64解密传入的值应该使用base64转化后的字节数组。
 * ⑤：加密模式中：先用秘钥值，算法生成秘钥规则类对象也就是key；再作为参数传入init方法；再dofinal方法中传入原文
 * 生成最终的秘钥值加原文的密文。
 * ⑥：解密模式中：传入加密后的密文，算法生成秘钥规则类对象也就是key；再作为参数传入init方法；再dofinal方法中传入原文
 * 生成最终的原文
 * ⑦：AES或者DES都不能少的几个属性：算法，秘钥，原文
 */
public class AESUtil {
	//默认使用"DES/ECB/PKCS5pPading"该模式
		//private static final String tran = "DES/ECB/PKCS5pPading";//算法//工作模式/填充模式
		//private static final String tran = "DES/C/PKCS5pPading" NoPadding如果使用不填充模式，要求原文必须是8的整数倍
	private static final String ALGORITHM = "AES";//算法
	public static void main(String[] args) {
		String input = "Hello AES";
		String password = "1234567812345678";
		String encrypt = encrypt(input, password);
		System.out.println("AES加密Base64解码密文：" + encrypt);
		String decrypt = decrypt(encrypt, password);
		System.out.println("AES解密Base64解码原文：" + decrypt);
		
	}
	
	/*
	 * AES加密
	 * @param String ALGORITHM 算法
 	 * @param String input 原文
	 * @param String password 秘钥
	 * 返回值应该是进行base64编码的一个字符串
	 * AES依赖于秘钥规则类secretKeySpec类
	 */
	public static String encrypt(String input, String password) {
		try {
		//加密算法三部曲
		//1.创建Cipher对象
		
			Cipher cipher = Cipher.getInstance(ALGORITHM );
			//对于秘钥工厂secretKeyFactory是没有AES这个参数的
			//AES依赖于秘钥规则类
			SecretKeySpec key = new SecretKeySpec(password.getBytes(), ALGORITHM);
			
			//Key key 该类实现了秘钥规则类secretKeySpec
			//2.初始化模式：加密/解密
			/*在使用CBC模式时，在加密以及解密时都应该添加IvParameterSpec
			 * IvParameterSpec iv = new IvParameterSpec("12345678".getBytes()); 字节必须是8位
			 * cipher.init(Cipher.ENCRYPT_MODE, key,iv);
			 */
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//3.加密?解密
			byte[] encryptBytes = cipher.doFinal(input.getBytes());
			//System.out.println("DES加密=" + new String(encryptBytes));
			return Base64.encodeBase64String(encryptBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * AES解密：
	 * @param String ALGORITHM 算法
	 * @param string input 密文
	 * @param string password 秘钥
	 * 返回值是byte数组通过new string就可以转化成string 字符串了
	 * 注意：加密时使用了base64解密传入的值应该使用base64转化后的字节数组。
	 */
	
	public static String decrypt(String input, String password) {
		try {
		//解密算法三部曲
		//1.创建Cipher对象
			Cipher cipher = Cipher.getInstance(ALGORITHM );
			//AES依赖于秘钥规则类SecrKeySpec
			SecretKeySpec key = new SecretKeySpec(password.getBytes(), ALGORITHM);
			//2.初始化模式：加密/解密
			/*在使用CBC模式时，在加密以及解密时都应该添加IvParameterSpec
			 * IvParameterSpec iv = new IvParameterSpec("12345678".getBytes()); 字节必须是8位
			 * cipher.init(Cipher.ENCRYPT_MODE, key,iv);
			 */
			cipher.init(Cipher.DECRYPT_MODE, key);
			//3.加密?解密
			byte[] decryptBytes = cipher.doFinal(Base64.decodeBase64(input.getBytes()));
			//System.out.println("AES减密=" + new String(encryptBytes));
			return new String(decryptBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
