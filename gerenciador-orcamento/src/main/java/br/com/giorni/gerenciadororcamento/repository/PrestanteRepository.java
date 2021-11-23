package br.com.giorni.gerenciadororcamento.repository;

import br.com.giorni.gerenciadororcamento.model.Prestante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestanteRepository extends JpaRepository<Prestante, Long> {
}
