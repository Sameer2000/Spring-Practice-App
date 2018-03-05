package com.app.src.configs;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class AppConfig extends WebMvcConfigurationSupport
{

   @Override
   protected void configureMessageConverters( List< HttpMessageConverter< ? > > converters )
   {
      converters.add( jsonConverter() );
      addDefaultHttpMessageConverters( converters );
   }

   @Bean
   public MappingJackson2HttpMessageConverter jsonConverter()
   {
      return new MappingJackson2HttpMessageConverter();
   }

}
