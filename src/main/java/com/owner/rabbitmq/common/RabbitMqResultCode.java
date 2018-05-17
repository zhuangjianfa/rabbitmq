package com.owner.rabbitmq.common;


/**
 * 
 * description:rabbitmq异常消息枚举类
 * Author	Date	Changes
 * zhuangjianfa  2018年3月13日 Created
 */
public enum RabbitMqResultCode {
    
    /**
     * 参数{}为必填
     */
    PARAMETER_REQUIRED(10003, "parameter %s is required."),
    
    SERVICE_EXCEPTION(10001,"rabbitmq servcie exception."),
    
    HTTP_EXCEPTION(10002,"%s");
    /**
     * 异常编码
     */
    private Integer code;
    
    private String message;

    
    /**
     * Returns this code object.
     * @return this code
     */
    public Integer getCode() {
        return code;
    }


    
    /**
     * Returns this message object.
     * @return this message
     */
    public String getMessage() {
        return message;
    }



    /**
     * Class constructors.
     * @param code
     * @param message
     */
    private RabbitMqResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    
    public String getMessage(final Object... args) {
        return String.format(this.message, args);
    }
    
}
