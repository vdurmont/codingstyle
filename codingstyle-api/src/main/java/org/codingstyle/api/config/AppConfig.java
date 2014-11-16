package org.codingstyle.api.config;

import org.apache.log4j.Logger;
import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration
@EnableAspectJAutoProxy
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = {"org.codingstyle.api.service", "org.codingstyle.api.service"})
public class AppConfig {
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);

    @PostConstruct
    public void init() {
        DateTimeZone.setDefault(DateTimeZone.UTC);
        LOGGER.info("App initialized.");
    }
}
