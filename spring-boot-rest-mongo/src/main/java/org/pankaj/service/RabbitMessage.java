package org.pankaj.service;
/*package hello.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMessage {

	private static final String QUEUE1 = "Queue1";

	public static void connectionRabbitQueue() {
		ConnectionFactory factory= new ConnectionFactory();
		factory.setHost("localhost");
		
		try {
			Connection newConnection = factory.newConnection();
			Channel channel = newConnection.createChannel();
			channel.queueDeclare(QUEUE1,false,false,false,null);
			String message = "My first message";
			channel.basicPublish("", QUEUE1, null, message.getBytes());
			System.out.println(" Message Sent: "+message);
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
*/