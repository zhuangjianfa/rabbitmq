package com.owner.rabbitmq.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.owner.rabbitmq.common.DefaultExchannel;
import com.owner.rabbitmq.enums.ExchangeTypeEnum;

/**
 * description:消息构建器
 * Author	Date	Changes
 * zhuangjianfa  2018年3月13日 Created
 */
public class MessageBuilder {
    
    @NotEmpty(message="{rabbitTemplate can't be null}")
    private RabbitTemplate rabbitTemplate;
    
    /**
     * routingKey,当类型为direct与topic时为必填
     */
    private String routingKey;
    
    @NotEmpty(message="{message can't be null}")
    private Object message;
    
    /**
     * 默认值为direct
     */
    private ExchangeTypeEnum exchangeType = ExchangeTypeEnum.DIRECT;

    /**
     * description:消息ID
     * remark:
     */
    private String mid;
    
    
    /**
     * Returns this mid object.
     * @return this mid
     */
    public String getMid() {
        return mid;
    }


    
    /**
     * Sets this mid.
     * @param mid this mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
    }


    /**
     * Returns this rabbitTemplate object.
     * @return this rabbitTemplate
     */
    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    
    /**
     * Sets this rabbitTemplate.
     * @param rabbitTemplate this rabbitTemplate to set
     */
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    
    /**
     * Returns this routingKey object.
     * @return this routingKey
     */
    public String getRoutingKey() {
        return routingKey;
    }

    
    /**
     * Sets this routingKey.
     * @param routingKey this routingKey to set
     */
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    
    /**
     * Returns this message object.
     * @return this message
     */
    public Object getMessage() {
        return message;
    }

    
    /**
     * Sets this message.
     * @param message this message to set
     */
    public void setMessage(Object message) {
        this.message = message;
    }

    
    /**
     * Returns this exchangeType object.
     * @return this exchangeType
     */
    public ExchangeTypeEnum getExchangeType() {
        return exchangeType;
    }

    
    /**
     * Sets this exchangeType.
     * @param exchangeType this exchangeType to set
     */
    public void setExchangeType(ExchangeTypeEnum exchangeType) {
        this.exchangeType = exchangeType;
    }

    /**
     * Class constructors.
     * @param connectionFactory
     * @param rabbitTemplate
     * @param routingKey
     * @param message
     * @param exchangeType
     */
    public MessageBuilder(RabbitTemplate rabbitTemplate, String routingKey,
                          Object message, ExchangeTypeEnum exchangeType){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.routingKey = routingKey;
        this.message = message;
        this.exchangeType = exchangeType;
    }

    
    /**
     * Class constructors.
     * @param rabbitTemplate 不同环境rabbitmq
     * @param routingKey 路由KEY
     * @param message 消息
     * @param mid 消息ID
     */
    public MessageBuilder(RabbitTemplate rabbitTemplate, String routingKey, Object message, String mid){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.routingKey = routingKey;
        this.message = message;
        this.mid = mid;
    }



    /**
     * Class constructors.
     * @param rabbitTemplate
     * @param routingKey
     * @param message
     * @param exchangeType
     * @param mid
     */
    public MessageBuilder(RabbitTemplate rabbitTemplate, String routingKey, Object message,
                          ExchangeTypeEnum exchangeType, String mid){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.routingKey = routingKey;
        this.message = message;
        this.exchangeType = exchangeType;
        this.mid = mid;
    }



    public void sendDirect(){
        this.rabbitTemplate.convertAndSend(DefaultExchannel.AMQ_DIRECT, routingKey , message);
    }
    
    public void sendTopic(){
        this.rabbitTemplate.convertAndSend(DefaultExchannel.AMQ_TOPIC, routingKey , message);
    }
    
    public void sendFanout(){
        this.rabbitTemplate.convertAndSend(DefaultExchannel.AMQ_FANOUT, "" , message);
    }
    
}
