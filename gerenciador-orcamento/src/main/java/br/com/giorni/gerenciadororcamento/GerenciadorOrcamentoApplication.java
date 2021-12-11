package br.com.giorni.gerenciadororcamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableAutoConfiguration
@SpringBootApplication
public class GerenciadorOrcamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorOrcamentoApplication.class, args);
	}

}
