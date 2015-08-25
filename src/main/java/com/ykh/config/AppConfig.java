package com.ykh.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ant_shake_tree on 15/7/19.
 */
@Configuration
@ComponentScan(basePackages = { "com.ykh" })
//        , excludeFilters = {
//        @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
//        @ComponentScan.Filter(value = EnableWebMvc.class, type = FilterType.ANNOTATION) })

@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
@Import({PersistenceContext.class})
@EnableSpringDataWebSupport
public class  AppConfig {
        @Bean public CacheManager cacheManager()
        {
                return new ConcurrentMapCacheManager();
        }
}
