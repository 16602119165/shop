package com.zhoubo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhoubo.dao.ShopAdminMapper;
import com.zhoubo.pojo.ShopAdmin;

@Service("ls")
public class LoginServiceImp implements LoginService {

	/*@Autowired
	JedisPool jedisPool;*/
	
	@Autowired
	ShopAdminMapper sam;
	
	/*@Override
	public String creatToken() {
		String tokenUuid = UUID.randomUUID().toString().replace("-", "");
		String string = tokenUuid+"name";
		String md5 = MessageDigestUtil.md5(string);
		Jedis jedis = jedisPool.getResource();
		
		return md5;
	}*/


	@Override
	public ShopAdmin selectByName(String name, String pass) {
		ShopAdmin sa= sam.selectByNameAndPass(name, pass);
		if(null == sa){
			return null;
		}
		return sa;
	}



	
	
	

}
