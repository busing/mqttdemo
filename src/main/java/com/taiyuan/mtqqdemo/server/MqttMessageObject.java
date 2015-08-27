package com.taiyuan.mtqqdemo.server;

import java.io.Serializable;

/**
 * @Title: MqttMessageObject.java
 * @Package com.junrui.dpc.mqtt
 * @Description: an object that used for MQTT transform
 * @author Yan
 * @date 2015-5-4
 * @version V1.0
 */
public class MqttMessageObject implements Serializable {

	private static final long serialVersionUID = 1L;

	//发送主题
	private String topic;
	//发送类型
	private int qos;
	// 发送人姓名
	private String senderUserName;
	// 发送人ID
	private Integer senderId;
	// 手机titleBar要显示的内容
	private String messageContent;
	// 消息类型
	private int topicType;
	// 消息的实际内容
	private Object keyWord;
	// 消息创建时间
	private long createTime;
	
    public MqttMessageObject(String topic) {
        this.topic = topic;
        this.qos = 2;
    }
    
    public MqttMessageObject(String topic, int qos) {
        this.topic = topic;
        this.qos = qos;
    }
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getQos() {
		return qos;
	}
	public void setQos(int qos) {
		this.qos = qos;
	}
	public String getSenderUserName() {
		return senderUserName;
	}
	public void setSenderUserName(String senderUserName) {
		this.senderUserName = senderUserName;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * @see com.junrui.dpc.mqtt.MqttConfig.java TOPIC_TYPE_ASK_PAY
	 * @see com.junrui.dpc.mqtt.MqttConfig.java TOPIC_TYPE_MESSAGE
	 * @return
	 */
	public int getTopicType() {
		return topicType;
	}
	public void setTopicType(int messageType) {
		this.topicType = messageType;
	}
	public Object getKeyWord() {
		return keyWord;
	}
	/**
	 * @param keyWord 消息的实际内容
	 */
	public void setKeyWord(Object keyWord) {
		this.keyWord = keyWord;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "{\"topic\":\"" + topic + "\", \"qos\":" + qos + ", \"senderUserName\":\"" + senderUserName
            + "\", \"senderId\":" + senderId + ", \"messageContent\":\"" + messageContent
            + "\", \"messageType\":" + topicType + ", \"keyWord\":\"" + keyWord + "\", \"createTime\":\""
            + createTime + "\"}";
    }

}
