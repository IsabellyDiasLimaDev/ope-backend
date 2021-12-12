package br.com.giorni.gerenciadororcamento.repository;

import br.com.giorni.gerenciadororcamento.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
