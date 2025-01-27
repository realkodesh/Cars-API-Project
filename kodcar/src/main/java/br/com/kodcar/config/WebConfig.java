package br.com.kodcar.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.kodcar.serialization.YamlJackson2HttpMesageConverter;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	

	   @Override
		public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		
			converters.add(new YamlJackson2HttpMesageConverter());
		}


	@Override
		public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	   
		// Via HEADER PARAM. http://localhost:8080/product/v1
		 
		 configurer.favorParameter(false) //Aceita parametros
		 .ignoreAcceptHeader(false) //Ignora parametros no HEADER
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("json", MediaType.APPLICATION_JSON)
		 .mediaType("xml", MediaType.APPLICATION_XML)
		 .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML); 
		 
		
}
	
}
