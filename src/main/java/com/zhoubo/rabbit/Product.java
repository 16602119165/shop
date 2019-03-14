package com.zhoubo.rabbit;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.basic.Result;
@Service
public class Product {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String name, Object object){
		amqpTemplate.convertAndSend(name,object);
		System.out.println("消息放入队列成功");
		
	}

}
