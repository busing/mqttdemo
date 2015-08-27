package com.taiyuan.mtqqdemo.server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: MqttDispatcher.java
 * @Package com.junrui.dpc.mqtt
 * @Description: a MQTT message dispatcher controls which publisher to work
 * @author Yan
 * @date 2015-5-4
 * @version V1.0
 */
public class MqttDispatcher {
	private static List<MqttMessagePublisher> publishers = new ArrayList<MqttMessagePublisher>();

	public static void initMqtt() throws Exception {
		MqttServer.init();
		MqttDispatcher.generatePublishers(1);
		MqttDispatcher.activePublishers();
	}

	public static void stopMqtt() {
		MqttDispatcher.inActivePublishers();
		MqttServer.close();
	}
	
	public static void beginPublish(MqttMessageObject message){
		publishers.get(0).publish(message);
	}

	private static void generatePublishers(int size) {
		for (int i = 0; i < size; i++) {
			publishers.add(new MqttMessagePublisher());
		}
	}

	private static void activePublishers() {
		int num = 0;
		for (MqttMessagePublisher publisher : MqttDispatcher.publishers) {
			publisher.start();
			Thread thread = new Thread(publisher, "MQTT_Thread_" + num);
			thread.setDaemon(true);
			thread.start();
			num++;
		}
	}

	private static void inActivePublishers() {
		for (MqttMessagePublisher publisher : MqttDispatcher.publishers) {
			publisher.stop();
		}
	}

}
