/**   
 * @Title: MqttConfig.java 
 * @Package com.junrui.dpc.mqtt 
 * @Description: MQTT相关的配置信息
 * @author YeJie   
 * @date 2015-4-28 下午4:30:13 
 * @version V1.0   
 */
package com.taiyuan.mtqqdemo.server;

/**
 * @Title: MqttConfig.java
 * @Description: MQTT相关的配置信息
 */
public interface MqttConfig
{
    
    String CLIENT_ID = "ser/asdf1234";      //服务端识别码，任意值
    
    //订阅主题
    String TOPIC_DOCTOR = "dpc/doctor/";    //医生端监听的主题，后拼接医生自己的ID
    
    String TOPIC_PATIENT = "dpc/patient/";  //患者端监听的主题，后拼接患者自己的ID
    
    //主题类型
    int TOPIC_TYPE_ASK_PAY = 0;             //当移动端收到的消息类型是0时，弹出请求付款窗口
    
    int TOPIC_TYPE_MESSAGE = 1;             //当移动端收到的消息类型是1时，直接将信息展示
    
    int TOPIC_TYPE_CLOSE_INQUIRY = 2;       //当移动端收到的消息类型是2时，关闭问询
    
    int TOPIC_TYPE_PAY_SUCCESS = 3;                //医生端收到的患者支付成功弹窗。
    
    int TOPIC_TYPE_INVITE_EXPERT = 4;                //患者端收到邀请专家类型，调用获取问询详情接口和确认支付接口。
    
    int TOPIC_TYPE_ECG_SERVICE = 5;             //当移动端收到的消息类型是5时，收到ECG报告
    
//    String TOPIC_ASK_PAY = "dpc/doctor/askpay/";    //患者端监听的请求支付主题
    
//    String TOPIC_DOCTOR_TALK = "dpc/doctor/talk/";  //患者端监听的会话主题
//    
//    String TOPIC_PATIENT_TALK = "dpc/patient/talk/";//医生端监听的会话主题
//    
//    String TOPIC_DOCTOR_PAY = "dpc/doctor/pay/";
//    
//    String TOPIC_PATIENT_PAY = "dpc/patient/pay/";
    
    //医生发起收费时，向消息表中保存的消息
    String CONTENT_ASK_PAY = "您发起了收费请求(?0元/次)";

    //医生发起收费时，向消息表中为患者保存的消息
    String CONTENT_TO_PAY = "向您发起了收费请求(?0元/次)。在您完成支付后，他将继续为您提供诊疗服务。";
    
    String CONTENT_CONSULTATION_PAY = "邀请专家?1向您提供会诊服务(?0元/次)。在您完成支付后，他们将为您提供会诊服务。";
    
    String CONTENT_END_INQUIRY = "已结束了本次问询。";
    
    String CONTENT_INQUIRY_TALK = "您有一条新消息";
    
    String CONTENT_INVITE_EXPERT="邀请您参加本次会诊。";
    
    String CONTENT_PAY_SUCCESS_TO_DOCTOR = "接受了您发起的收费诊疗服务请求。";
    
    String CONTENT_PAY_SUCCESS_TO_PATIENT = "您接受了?0发起的收费诊疗服务请求。";
}
