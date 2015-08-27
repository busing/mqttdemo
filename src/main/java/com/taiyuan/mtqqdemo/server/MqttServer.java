/**   
 * @Title: MqttServer.java 
 * @Package com.junrui.dpc.mqtt 
 * @Description: MQTT服务器端
 * @author YeJie   
 * @date 2015-4-28 下午3:12:05 
 * @version V1.0   
 */
package com.taiyuan.mtqqdemo.server;


import com.ibm.micro.client.mqttv3.MqttClient;
import com.ibm.micro.client.mqttv3.MqttDeliveryToken;
import com.ibm.micro.client.mqttv3.MqttException;
import com.ibm.micro.client.mqttv3.MqttSecurityException;
import com.ibm.micro.client.mqttv3.MqttTopic;
import com.ibm.micro.client.mqttv3.internal.MemoryPersistence;

/**
 * @Title: MqttServer.java
 * @Description: MQTT服务器端
 */
public class MqttServer
{
    private static MqttClient mqttClient = null;
    
    private static String hostName = "121.40.55.170";
    
    private static String port = "1883";
    
    private static String clientId = MqttConfig.CLIENT_ID;
    
    /**
     * 初始化MQTT服务器(本机)
     * 
     * @param host
     * @param topic
     * @throws Exception
     */
    public static void init()
        throws Exception
    {
        try
        {
            if (mqttClient == null)
            {
                StringBuilder sb = new StringBuilder("tcp://");
                sb.append(hostName).append(":").append(port);
                
                mqttClient = new MqttClient(sb.toString(), clientId, new MemoryPersistence());
            }
            mqttClient.setCallback(new MqttCallBack());
        }
        catch (MqttException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 初始化MQTT服务器
     * 
     * @param host
     * @param topic
     * @throws Exception
     */
    @Deprecated
    public static void init(String hostIP)
        throws Exception
    {
        try
        {
            if (mqttClient == null)
            {
                StringBuilder sb = new StringBuilder("tcp://");
                sb.append(hostIP).append(":").append(port);
                
                mqttClient = new MqttClient(sb.toString(), MqttConfig.CLIENT_ID, new MemoryPersistence());
            }
            mqttClient.setCallback(new MqttCallBack());
        }
        catch (MqttException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 向客户端推送消息
     * 
     * @param message
     *            推送的消息
     * @throws Exception
     */
    public static void push(String topic, MqttMessageObject message, int qos)
        throws Exception
    {
        if (!mqttClient.isConnected())
        {
            mqttClient.connect();
        }
        if (mqttClient.isConnected())
        {
            MqttTopic mTopic = mqttClient.getTopic(topic);
            try
            {
//                MqttDeliveryToken token = mTopic.publish(message.toString().getBytes(DPCConfig.ENCODING), qos, true);
                //MQTT不保存已收到消息，解决每次登陆都能收到推送的问题
                MqttDeliveryToken token = mTopic.publish(message.toString().getBytes("UTF-8"), qos, false);
                while (!token.isComplete())
                {
                    token.waitForCompletion(1000);
                }
            }
            catch (MqttSecurityException e)
            {
                e.printStackTrace();
            }
            catch (MqttException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static MqttClient getClient()
    {
        return MqttServer.mqttClient;
    }
    
    public static void close()
    {
        try
        {
            MqttServer.mqttClient.disconnect(0);
        }
        catch (MqttException e)
        {
            e.printStackTrace();
            mqttClient = null;
        }
    }

	public static String getHostName() {
		return hostName;
	}

	public static void setHostName(String hostName) {
		MqttServer.hostName = hostName;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		MqttServer.port = port;
	}

	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		MqttServer.clientId = clientId;
	}
	
	public static void main(String[] args) {
		try {
			MqttServer.init();
			MqttMessageObject message=new MqttMessageObject(MqttConfig.TOPIC_DOCTOR, 1);
			message.setSenderId(123);
			message.setMessageContent("你好你好");
			message.setSenderUserName("邰元1111");
			
			MqttServer.push(MqttConfig.TOPIC_DOCTOR, message, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
