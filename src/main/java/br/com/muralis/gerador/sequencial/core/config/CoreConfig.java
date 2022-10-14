package br.com.muralis.gerador.sequencial.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.muralis.gerador.sequencial.core")
@EnableAutoConfiguration
public class CoreConfig {

}
