package com.ufuk.stereotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.ufuk")// if remove basePackages annotation it will check just the  config package and fail
@Configuration
public class PcConfig {
}
