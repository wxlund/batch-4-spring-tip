package com.example.config;

/**
 * Created by wlund on 3/9/17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PropertyConfig {

    @Value("${locators:localhost:10334}")
    public String locators;


}