package br.com.giorni.gerenciadororcamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories("br.com.giorni.gerenciadororcamento.repository")
@SpringBootApplication
public class GerenciadorOrcamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorOrcamentoApplication.class, args);
	}

}
