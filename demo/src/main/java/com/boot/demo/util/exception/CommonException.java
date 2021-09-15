package com.boot.demo.util.exception;

import com.boot.demo.util.result.ResultInterface;

/**
 * @author badpoone
 * @date 2021/6/15  23:19
 */
public class CommonException extends RuntimeException{
    private ResultInterface resultInterface;
    /**
     *往异常的那个message中添加的描述信息
     */
    private String desc;
    public ResultInterface getResultInterface() {
        return resultInterface;
    }

    public String getDesc() {
        return desc;
    }

    public CommonException(ResultInterface exceptionInterface){

        super(exceptionInterface.getMessage());
        this.resultInterface=exceptionInterface;
    }
    public CommonException(ResultInterface exceptionInterface,String desc){

        super(exceptionInterface.getMessage());
        this.resultInterface=exceptionInterface;
        this.desc = desc;
    }
    public CommonException(String code,String message){

        resultInterface = new ResultInterface(){

            /**
             * 返回的状态码
             *
             * @return
             */
            @Override
            public String getCode() {
                return code;
            }

            /**
             * 返回的信息
             *
             * @return
             */
            @Override
            public String getMessage() {
                return message;
            }
        };
    }


}
