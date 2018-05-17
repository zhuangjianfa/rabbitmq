package com.owner.rabbitmq.common;


/**
 * description:rabbit自带exchannel
 * Author	Date	Changes
 * zhuangjianfa  2018年3月12日 Created
 */
public interface DefaultExchannel {
    
    /**
     * description:默认direct名字
     * remark:
     */
    String AMQ_DIRECT = "amq.direct";
    
    /**
     * description:默认fanout名字
     * remark:
     */
    String AMQ_FANOUT ="amq.fanout";
    
    /**
     * description:默认topic名字
     * remark:
     */
    String AMQ_TOPIC ="amq.topic";
    
    /**
     * description:默认headers名字
     * remark:
     */
    String AMQ_HEADERS ="amq.headers";
    
}
