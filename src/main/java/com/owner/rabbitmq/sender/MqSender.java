package com.owner.rabbitmq.sender;


import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

import com.owner.common.exception.ParamsValidateException;
import com.owner.rabbitmq.common.RabbitMqResultCode;
import com.owner.rabbitmq.enums.ExchangeTypeEnum;
import com.owner.rabbitmq.model.MessageBuilder;

/**
 * description:消息发送,所有消息
 * Author	Date	Changes
 * zhuangjianfa  2018年3月12日 Created
 */
public abstract class MqSender implements RabbitTemplate.ConfirmCallback{
    
    public void send(MessageBuilder builder){
        //如果不是fanout,headers类型，则rountingKey为必填
        if((!builder.getExchangeType().getExchangeType().equalsIgnoreCase(ExchangeTypeEnum.FANOUT.getExchangeType())
                && !builder.getExchangeType().getExchangeType().equalsIgnoreCase(ExchangeTypeEnum.HEADERS.getExchangeType()))
                && (null==builder.getRoutingKey() || "".equals(builder.getRoutingKey().trim()))){
            throw new ParamsValidateException(RabbitMqResultCode.PARAMETER_REQUIRED.getCode(),
                String.format(RabbitMqResultCode.PARAMETER_REQUIRED.getMessage(),"routingKey"));
        }
        CorrelationData correlationData = new CorrelationData();
        //消息id,唯一标识
        String mid =  (null==builder.getMid() ? UUID.randomUUID().toString() : builder.getMid());
        correlationData.setId(mid);
        RabbitTemplate rabbitTemplate = builder.getRabbitTemplate();
        rabbitTemplate.convertAndSend(builder.getExchangeType().getExchannelName(), builder.getRoutingKey(), builder.getMessage(), correlationData);
    }
    /* (non-Javadoc)
     * @see org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback#confirm(org.springframework.amqp.rabbit.support.CorrelationData, boolean, java.lang.String)
     */
    public abstract void confirm(CorrelationData correlationData, boolean ack, String cause);
    
}
