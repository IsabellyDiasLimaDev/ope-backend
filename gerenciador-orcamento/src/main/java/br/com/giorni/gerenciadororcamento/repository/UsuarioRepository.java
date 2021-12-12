package br.com.giorni.gerenciadororcamento.repository;

import br.com.giorni.gerenciadororcamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
