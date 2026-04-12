package com.sip.ams.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API SIP AMS")
                        .version("1.0")
                        .description("Documentation de l'API SIP AMS")
                        .contact(new Contact()
                                .name("SIP Team")
                                .email("contact@sip.com"))
                        .license(new License()
                                .name("Licence SIP")
                                .url("https://sip.com")));
    }
}