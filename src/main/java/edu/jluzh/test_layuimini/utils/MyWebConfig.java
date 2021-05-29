package edu.jluzh.test_layuimini.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 18:54
 * @version:
 * @modified By:
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置浏览器能够访问本地路径的图片
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/image/");

    }
}
