package com.qf.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")   //允许被请求的资源
                .allowedOrigins("*")  //允许指定的源能访问
                .allowedOriginPatterns("*")    //允许的请求地址
                .allowedHeaders("*")  //允许的请求头
        //        .allowCredentials(true) //是否允许携带cookie;
                .allowedMethods("*"); //允许的请求方式
        //注意：当设置允许携带Cookie不允许将指定源设置为所有

    }
    //添加虚拟路径，相当于通过一个路径访问本地磁盘上的内容；
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:D:\\Grade3\\Myself\\java\\Springboot Project\\fmmall-shopping\\pictures\\images\\");
    }
    //拦截器配置











}
