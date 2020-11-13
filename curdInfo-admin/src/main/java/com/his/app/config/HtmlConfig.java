package com.his.app.config;


import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

//@Controller
//public class HtmlConfig implements ErrorPageRegistrar {
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//        ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/his/index.html");
//        registry.addErrorPages(error401Page);
//    }
//
//}

