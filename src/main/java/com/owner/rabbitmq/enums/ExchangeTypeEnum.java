package com.owner.rabbitmq.enums;

import org.springframework.amqp.core.ExchangeTypes;

import com.owner.rabbitmq.common.DefaultExchannel;

/**
 * description:rabbit exchange类型
 * Author	Date	Changes
 * zhuangjianfa  2018年3月12日 Created
 */
public enum ExchangeTypeEnum {
    
    DIRECT(ExchangeTypes.DIRECT,DefaultExchannel.AMQ_DIRECT),

    TOPIC(ExchangeTypes.TOPIC,DefaultExchannel.AMQ_TOPIC),

    FANOUT(ExchangeTypes.FANOUT,DefaultExchannel.AMQ_FANOUT),

    HEADERS(ExchangeTypes.HEADERS,DefaultExchannel.AMQ_HEADERS),

    CUSTOMIZE("","");
    
    private String exchangeType;

    private String exchannelName;
    

    /**
     * Class constructors.
     * @param exchangeType
     * @param exchannelName
     */
    private ExchangeTypeEnum(String exchangeType, String exchannelName){
        this.exchangeType = exchangeType;
        this.exchannelName = exchannelName;
    }


    
    /**
     * Returns this exchangeType object.
     * @return this exchangeType
     */
    public String getExchangeType() {
        return exchangeType;
    }


    /**
     * Returns this exchannelName object.
     * @return this exchannelName
     */
    public String getExchannelName() {
        return exchannelName;
    }
    
}
