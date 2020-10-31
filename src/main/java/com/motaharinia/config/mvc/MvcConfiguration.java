package com.motaharinia.config.mvc;

import com.motaharinia.msutility.json.CustomObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.List;
import java.util.Locale;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-07 <br>
 * Time: 11:28:11 <br>
 * Description: کلاس تنظیمات وب و عمومی
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    /**
     * تنظیمات چندزبانی سامانه
     * @return خروجی: منبع ترجمه برای چندزبانی با تنظیمات سفارشی شده
     */
    @Bean(name = "messageSource")
    public MessageSource configureMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(new String[]{"classpath:lang/module/common/etcitem/etcItem",});
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * تنظیمات جکسون برای سریالایز و دیسریالایز سامانه
     * @param converters مبدل کاستوم مپر جکسون با تنظیمات سفارشی شده
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        CustomObjectMapper customObjectMapper = new CustomObjectMapper(configureMessageSource());
        mappingJackson2HttpMessageConverter.setObjectMapper(customObjectMapper);
        converters.add(mappingJackson2HttpMessageConverter);
    }

    /**
     * تنظیم لوکیل پیش فرض سامانه
     * @return خروجی: ریزالور لوکال با لوکیل پیش فرض فارسی که بعد از اجرای نرم افزار به صورت پیش فرض روی فارسی تنظیم هست
     */
    @Bean
    @DependsOn("messageSource")
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("fa", "IR"));
        return localeResolver;
    }
}
