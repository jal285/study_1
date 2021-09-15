package com.boot.demo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author badpoone
 */
@Configuration
@ConfigurationProperties(prefix = "url")
public class UrlProperties {

    /**
     * 鉴权白名单
     */
    private Set<String> whiteList = new HashSet<>();

    public Set<String> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(Set<String> whiteList) {
        this.whiteList = whiteList;
    }

}
