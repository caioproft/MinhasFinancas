package com.invillia.minhasFinancas.service;


import com.invillia.minhasFinancas.exception.RegraNegocioException;
import com.invillia.minhasFinancas.model.entity.Usuario;
import com.invillia.minhasFinancas.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveValidarEmail() {
            //cenário
            repository.deleteAll();

            //ação
            service.validarEmail("usuario@email.com");
    }


    @Test
    public void deveLançarErroAoValidarEmailQuandoExisteEmailCadastrado() {
        Assertions.assertThrows(RegraNegocioException.class, () -> {
            // cenário
            Usuario usuario = Usuario.builder().nome("Usuário").email("usuario@email.com").build();
            repository.save(usuario);

            // ação
            service.validarEmail("usuario@email.com");
        });
    }


}
