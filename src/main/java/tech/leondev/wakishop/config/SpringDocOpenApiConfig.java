package tech.leondev.wakishop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("REST API - Wakishop")
                                .description("API para controle de prdutos e checkout")
                                .version("v1")
                                .contact(new Contact().name("Leo Nascimento").email("nascimentoleo899@gmail.com"))
                );
    }
}
