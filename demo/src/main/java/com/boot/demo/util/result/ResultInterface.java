package com.boot.demo.util.result;

/**
 * @author badpoone
 * @date 2021/6/15  21:44
 */
public interface ResultInterface {

    /**
     * 返回的状态码
     * @return
     */
    String getCode();

    /**
     * 返回的信息
     * @return
     */
    String getMessage();

}
