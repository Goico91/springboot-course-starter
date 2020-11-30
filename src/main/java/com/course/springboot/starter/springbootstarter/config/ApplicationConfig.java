package com.course.springboot.starter.springbootstarter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class ApplicationConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    @Value("${spring.locale.default}")
    private String locale;

    @Value("${spring.messages.basename}")
    private String basename;

    /**
     * Message Resource declaration.
     *
     * @return MessageRessource
     */
    @Bean
    public MessageSource messageSource() {
        LOG.info("Set Locale to: " + locale);
        Locale.setDefault(new Locale(locale));

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename(basename);
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    /**
     * Define LocaleResolver
     *
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale(locale));
        return slr;
    }
}
