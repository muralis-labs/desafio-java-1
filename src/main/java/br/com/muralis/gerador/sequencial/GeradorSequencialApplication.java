package br.com.muralis.gerador.sequencial;

import br.com.muralis.gerador.sequencial.core.config.CoreConfig;
import br.com.muralis.gerador.sequencial.inbound.config.WebConfig;
import br.com.muralis.gerador.sequencial.outbound.config.OutboundConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeradorSequencialApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[] { CoreConfig.class, OutboundConfig.class, WebConfig.class }, args);
	}

}
