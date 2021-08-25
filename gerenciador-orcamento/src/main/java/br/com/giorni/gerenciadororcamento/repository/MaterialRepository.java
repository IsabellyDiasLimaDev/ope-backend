package br.com.giorni.gerenciadororcamento.repository;

import br.com.giorni.gerenciadororcamento.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
