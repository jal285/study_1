package com.boot.demo.util.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author badpoone
 * @date 2021/6/19  17:16
 */
@Component
public class NetWorkUtils {

    private static final Logger logger = LoggerFactory.getLogger(NetWorkUtils.class);

    /**
     *获取本机 eth0 网卡IP
     * @return
     */
    public static String getLocalInterAddress() {
        Enumeration<NetworkInterface> allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
                while (addressEnumeration.hasMoreElements()){
                    ip=addressEnumeration.nextElement();
                    if("eth0".equals(networkInterface.getName())){
                        if(ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            logger.error("获取网络地址失败",e);
        }
        return  "unKown";
    }
}
