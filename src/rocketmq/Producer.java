/**
 * @ProjectName MyJavaTest
 * @FileName Producer.java
 * @PackageName:rocketmq
 * @author YoungerKu
 * @date 2018年4月8日上午9:55:37
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */
package rocketmq;

import java.util.Date;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 此处添加类Producer的描述信息
 *
 * @author YoungerKu
 * @date 2018年4月8日 上午9:55:37
 * @since 1.0.0
 */
public class Producer {

	public static void main(String[] args) throws MQClientException {
		DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
		producer.setNamesrvAddr("192.168.26.120:9876");
		producer.setInstanceName("producer");
		producer.start();
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(5000); //每5秒发送一次MQ
				Message msg = new Message("TopicA-test",// topic
						"TagA",// tag
						(new Date() + " Hello RocketMQ ,QuickStart" + i).getBytes()// body
						);
				SendResult sendResult = producer.send(msg);
				System.out.println("sendResult:"+sendResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		producer.shutdown();
	}

}
