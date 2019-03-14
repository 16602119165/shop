package com.zhoubo.util;
import java.security.Key;
import org.apache.commons.codec.binary.Base64;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*
 * 对称加密：DES加密解密
 * 注意：①秘钥必须是8个字节；②加密后的密文长度是8字节的整数倍；
 * ③加密后字符长度发生改变，通常会乱码，一般使用Base64转换
 * ④：加密时使用了base64解密传入的值应该使用base64转化后的字节数组。
 * ⑤：加密模式中：先用算法生成秘钥工厂对象；再用秘钥值生成秘钥规则对象key；再作为参数传入init方法；再dofinal方法中传入原文
 * 生成最终的秘钥值加原文的密文。
 * ⑥：解密模式中：传入加密后的密文，先用算法生成秘钥工厂对象；再用秘钥值生成秘钥规则对象key；再作为参数传入init方法；再dofinal方法中传入原文
 * 生成最终解密的原文
 * ⑦：AES或者DES都不能少的几个属性：算法，秘钥，原文
 */
public class DESUtil {
	//默认使用"DES/ECB/PKCS5pPading"该模式
	//private static final String tran = "DES/ECB/PKCS5pPading";//算法//工作模式/填充模式
	//private static final String tran = "DES/C/PKCS5pPading" NoPadding如果使用不填充模式，要求原文必须是8的整数倍
	private static final String ALGORITHM = "DES";//算法
	

	public static void main(String[] args) {
		//原文：需要加密的数据
		String input = "HelloWorld";
		//秘钥：就是密码
		String password = "12345678"; //DES秘钥必须8个字节
		//加密算法思路：通过查看API文档封装自己的加密算法
		
		//加密算法核心类：Cipher
		
		String encrypt = encrypt(input, password);//加密之后返回的字节数组的密文，由秘钥及原文组成
		System.out.println("DES加密："+encrypt);
		
		String decrypt = decrypt(encrypt, password);
		System.out.println("DES解密："+decrypt);		
	}
	
	/*
	 * DES加密
	 * @param String ALGORITHM 算法
	 * @param String input
	 * @param String password
	 * 返回值应该是进行base64编码的一个字符串
	 */
	public static String encrypt(String input, String password) {
		try {
		//加密算法三部曲
		//1.创建Cipher对象
		
			Cipher cipher = Cipher.getInstance(ALGORITHM );
			//秘钥工厂根据算法生成秘钥对象
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
			KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
			Key key = skf.generateSecret(keySpec);//秘钥对象
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
	 * DES解密：
	 * @param String ALGORITHM 算法
	 * @param byte[] input 密文
	 * @param string password 秘钥值
	 * 返回值是byte数组通过new string就可以转化成string 字符串了
	 * 注意：加密时使用了base64解密传入的值应该使用base64转化后的字节数组。
	 */
	
	public static String decrypt(String input, String password) {
		try {
		//解密算法三部曲
		//1.创建Cipher对象
		
			Cipher cipher = Cipher.getInstance(ALGORITHM );
			//秘钥工厂根据算法生成秘钥对象
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
			KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
			Key key = skf.generateSecret(keySpec);//秘钥对象
			//2.初始化模式：加密/解密
			/*在使用CBC模式时，在加密以及解密时都应该添加IvParameterSpec
			 * IvParameterSpec iv = new IvParameterSpec("12345678".getBytes()); 字节必须是8位
			 * cipher.init(Cipher.ENCRYPT_MODE, key,iv);
			 */
			cipher.init(Cipher.DECRYPT_MODE, key);
			//3.加密?解密
			byte[] decryptBytes = cipher.doFinal(Base64.decodeBase64(input.getBytes()));
			//System.out.println("DES减密=" + new String(encryptBytes));
			return new String(decryptBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
