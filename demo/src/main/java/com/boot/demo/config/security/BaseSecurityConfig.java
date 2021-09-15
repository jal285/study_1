package com.boot.demo.config.security;

import com.boot.demo.config.security.handler.ServerAuthenticationEntryPoint;
import com.boot.demo.config.security.manage.AuthenticationManager;
import com.boot.demo.config.security.manage.SecurityContexRepository;
import com.boot.demo.util.UrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Set;

/**
 * @author badpoone
 * 这里使用webflux作为权限配置中心. webflux和 webmvc只能存在一个 依赖重复导入会造成bean重复注入
 */
@Configuration
public class BaseSecurityConfig {

    @Autowired
    private UrlProperties urlProperties;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityContexRepository securityContexRepository;
    @Autowired
    private ServerAuthenticationEntryPoint serverAuthenticationEntryPoint;


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        Set<String> whiteList = urlProperties.getWhiteList();
        String []strings = whiteList.toArray(new String[0]);
        //设置登陆页面
        http.formLogin().disable()
                .httpBasic().disable()
                .authenticationManager(authenticationManager)
                .exceptionHandling()
                //基于http的接口鉴权失败
                .authenticationEntryPoint(serverAuthenticationEntryPoint)
    ;
                //不需要授权
              //.pathMatchers(strings).permitAll()
                //option 请求默认放行
               // .pathMatchers(HttpMethod.OPTIONS).permitAll()
                //其它请求,均需要授权
        //关闭Csrf 保护

        //授权设置
         http.authorizeExchange()
                 //添加admin鉴权
             //    .pathMatchers("admin/**").hasRole("admin")

                 .pathMatchers("user").hasRole("user")
                 //不需要鉴权的链接
                 .pathMatchers(strings).permitAll()
                 .pathMatchers(HttpMethod.OPTIONS).permitAll()
                 .anyExchange().authenticated()
                 .and()
                 .httpBasic()
         ;

         //控制界面权限



//        // session 存储设置
//     //   http.securityContextRepository(securityContexRepository);
        return http.csrf().disable().build();
    }
}
