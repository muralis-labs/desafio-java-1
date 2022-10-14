package br.com.muralis.gerador.sequencial.inbound.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "br.com.muralis.gerador.sequencial.inbound")
@OpenAPIDefinition(info = @Info(title = "Gerador de sequenciais", description = "Gerador simples de sequenciais."))
@EnableWebMvc
public class WebConfig {

}
