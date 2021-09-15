package com.boot.demo.config.Filter;

import com.boot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.MatcherSecurityWebFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

import javax.annotation.Resource;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author badpoone
 */
//@Configuration
//@EnableWebFluxSecurity
public class WebFluxConfig {
    //implements WebMvcConfigurer
    //regiter 成功后转到login

    @Resource
    private User user ;

    /**
     * @param user 登陆用户信息
     */
    public WebFluxConfig(User user) {
        this.user = user;
    }

//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    @Bean
//    public SecurityWebFilterChain apiHttpSecurity(ServerHttpSecurity http) {
//        http
//                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/**"))
//                .authorizeExchange((exchanges) -> exchanges
//                        .anyExchange().authenticated()
//                )
//        ;
//        return http.build();
//    }
//
//
//    @Bean
//    SecurityWebFilterChain webHttpSecurity(ServerHttpSecurity http) {
//        http
//                .authorizeExchange((exchanges) -> exchanges
//                        .anyExchange().authenticated()
//
//                )
//                .httpBasic(withDefaults());
//        return http.build();
//    }





}
