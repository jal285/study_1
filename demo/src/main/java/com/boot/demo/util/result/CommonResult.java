package com.boot.demo.util.result;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author badpoone
 */
@Schema(description = "基础返回对象")
public class CommonResult<T> {

    /**
     *
     */
    @Schema(name = "是否操作成功", title = "是否操作成功",description = "是否操作成功")
    private boolean success;

    /**
     *错误码
     */
    @Schema(description = "错误码")
    private String code;

    /**
     * 错误信息
     */
    @Schema(description = "错误信息")
    private String message;

    /**
     * 数据体
     */
    @Schema(description = "数据体")
    private T dat;

    public CommonResult(){

    }

    public CommonResult(boolean success, String code, String message, T dat) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.dat = dat;
    }


    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(ResultInterface errorCode) {
        return new CommonResult<T>(false, errorCode.getCode(), errorCode.getMessage(), null);
    }

}
