package com.config;

import com.ykh.config.PersistenceContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@Import({PersistenceContext.class})
@ComponentScan("com.ykh")
@EnableTransactionManagement 
public class TestConfig {

}
