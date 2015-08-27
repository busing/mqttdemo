package com.taiyuan.mtqqdemo.server;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * @Title: MqttMessagePublisher.java
 * @Package com.junrui.dpc.mqtt
 * @Description: a MQTT message publisher
 * @author Yan
 * @date 2015-5-4
 * @version V1.0
 */
public class MqttMessagePublisher implements Runnable {

	private boolean running = false;

	private LinkedBlockingQueue<MqttMessageObject> messages = new LinkedBlockingQueue<MqttMessageObject>();

	public void run() {
		while(running){
    		try {
    			MqttMessageObject message = this.messages.poll(100,TimeUnit.MILLISECONDS);
    			if(message != null)
    				MqttServer.push(message.getTopic(), message, message.getQos());
            }
            catch (Exception e) {
	            e.printStackTrace();
            }
    	}
	}
	
	public void start(){
		this.running = true;
	}
	
	public void stop(){
		this.running = false;
	}

	public void publish(MqttMessageObject message){
		try {
	        this.messages.put(message);
        }
        catch (InterruptedException e) {
	        e.printStackTrace();
        }
	}
}
