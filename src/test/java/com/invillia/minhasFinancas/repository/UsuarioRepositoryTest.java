package com.invillia.minhasFinancas.repository;

import com.invillia.minhasFinancas.model.entity.Usuario;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")//Annotation para especificar que os teste tem ser feitos com as propriedades do perfil de teste!
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;


    @Test
    public void verificaEmailExistente(){
        // cenário
        Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
        repository.save(usuario);


        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        // verificação
        Assertions.assertThat(resultado).isTrue();
    }

    @Test
    public void retornaFalsoQuandoNaoHaEmailCadastrado() {
        // cenario
        repository.deleteAll(); // garante que a base esteja limpa

        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        // verificação

        Assertions.assertThat(resultado).isFalse();
    }
}
