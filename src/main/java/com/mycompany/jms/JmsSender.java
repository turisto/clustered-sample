package com.mycompany.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class JmsSender {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/queue/Queue")
	private javax.jms.Queue queue;

	public void send() {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage();

			for (int i = 0; i < 4; i++) {
				message.setText("This is message " + (i + 1) + " from producer");
				System.out.println("Sending message: " + message.getText());
				producer.send(message);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
