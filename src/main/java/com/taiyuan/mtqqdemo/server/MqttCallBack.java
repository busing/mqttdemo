/**   
 * @Title: MqttCallBack.java 
 * @Package com.junrui.dpc.mqtt 
 * @Description: TODO
 * @author YeJie   
 * @date 2015-4-28 下午4:03:47 
 * @version V1.0   
 */
package com.taiyuan.mtqqdemo.server;


import com.ibm.micro.client.mqttv3.MqttCallback;
import com.ibm.micro.client.mqttv3.MqttDeliveryToken;
import com.ibm.micro.client.mqttv3.MqttException;
import com.ibm.micro.client.mqttv3.MqttMessage;
import com.ibm.micro.client.mqttv3.MqttSecurityException;
import com.ibm.micro.client.mqttv3.MqttTopic;

/**
 * @Title: MqttCallBack.java
 * @Description: TODO
 */
public class MqttCallBack implements MqttCallback {
	
	public void connectionLost(Throwable arg0) {
		arg0.printStackTrace();
		try {
			MqttServer.getClient().connect();// 重新链接
		} catch (MqttSecurityException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public void deliveryComplete(MqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	public void messageArrived(MqttTopic arg0, MqttMessage arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
