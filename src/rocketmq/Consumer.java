/**
 * @ProjectName MyJavaTest
 * @FileName Consumer.java
 * @PackageName:rocketmq
 * @author YoungerKu
 * @date 2018年4月8日上午9:57:02
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */
package rocketmq;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 此处添加类Consumer的描述信息
 *
 * @author YoungerKu
 * @date 2018年4月8日 上午9:57:02
 * @since 1.0.0
 */
public class Consumer {

	public static void main(String[] args) throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rmq-group");
		consumer.setNamesrvAddr("192.168.26.120:9876");
		consumer.setInstanceName("consumer");
		consumer.subscribe("TopicA-test", "TagA");
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(
					List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				for (MessageExt msg : msgs) {
					System.out.println(new String(msg.getTopic()));
					System.out.println(new String(msg.getTags()));
					System.out.println("=== " + new String(msg.getBody()));
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
		System.out.println("Consumer Started.");
	}

}
