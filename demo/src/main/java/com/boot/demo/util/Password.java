package com.boot.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author badpoone
 */
@Slf4j
public class Password {

//    Logger log = LoggerFactory.getLogger(Password.class);


    /**
     *
     * @return 随机盐
     */
    public   String getsalt(){
        Random random = new Random();
        random.setSeed(1);
        char [] saltChars=("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "1234567890!@#$%^&*()_+").toCharArray();
        StringBuffer buffer = new StringBuffer();
        buffer.append(saltChars[random.nextInt(saltChars.length)]);
        buffer.append(saltChars[random.nextInt(saltChars.length)]);
        buffer.append(saltChars[random.nextInt(saltChars.length)]);
        buffer.append(saltChars[random.nextInt(saltChars.length)]);
        //生成四位随机盐
        return buffer.toString();
    }

    /**
     *
     * @param str password+salt 拼接
     * @return 加密字符串
     */
    public  String toMD5(String str){
        log.debug("md5待加密字符串: \n "+str);
        String md5 = "";
        try {
            md5= DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("md5 加密结果: \n"+md5);
        return md5;
    }

}
