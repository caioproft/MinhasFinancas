package com.invillia.minhasFinancas.repository;

import com.invillia.minhasFinancas.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
