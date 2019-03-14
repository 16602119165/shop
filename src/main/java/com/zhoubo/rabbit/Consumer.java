package com.zhoubo.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("consumer recive product message" + message);
		
	}

}
