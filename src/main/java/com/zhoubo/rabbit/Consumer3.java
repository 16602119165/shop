package com.zhoubo.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer3 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("consumer3 recive product message " + message);
		
	}
	
	
	

}
