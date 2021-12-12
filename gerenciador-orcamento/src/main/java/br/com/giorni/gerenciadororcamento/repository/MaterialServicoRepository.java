package br.com.giorni.gerenciadororcamento.repository;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialServicoRepository extends JpaRepository<MaterialServico,Long> {
}
