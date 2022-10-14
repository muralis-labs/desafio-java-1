package br.com.muralis.gerador.sequencial.outbound.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.muralis.gerador.sequencial.outbound.mockgenerator" })
public class MockGeneratorConfig {

}
