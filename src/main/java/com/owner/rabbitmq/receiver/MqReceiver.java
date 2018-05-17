package com.owner.rabbitmq.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
 * description:接收消息
 * Author	Date	Changes
 * zhuangjianfa  2018年3月12日 Created
 */
public abstract class MqReceiver implements ChannelAwareMessageListener{

    /* (non-Javadoc)
     * @see org.springframework.amqp.rabbit.core.ChannelAwareMessageListener#onMessage(org.springframework.amqp.core.Message, com.rabbitmq.client.Channel)
     */
    public abstract void onMessage(Message message, Channel channel) throws Exception;
    
}
