package com.example.listener.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 代码注册过滤器，可以指定执行顺序
 * 这样进行注册就不必在单独的过滤器类上加@WebFilter注解了，是一样的效果
 */
@Configuration
public class FilterRegistration {
    /**
     * 注册第一个过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter());
        //过滤器名称
        registration.setName("customFilter");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(10);
        return registration;
    }
    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }

    /**
     * 注册第二个过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter2());
        //过滤器名称
        registration.setName("customFilter2");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(20);
        return registration;
    }
    @Bean
    public Filter customFilter2() {
        return new CustomFilter2();
    }
}