package com.invillia.minhasFinancas.repository;

import com.invillia.minhasFinancas.model.entity.Usuario;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest // Cria uma instancia do banco de dados na memória e deleta ao fim dos testes
@ActiveProfiles("test")//Annotation para especificar que os teste tem ser feitos com as propriedades do perfil de teste!
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    TestEntityManager entityManager; // Para não utilizar a classe repository usa-se essa classe apenas para teste


    @Test
    public void verificaEmailExistente(){
        // cenário
        Usuario usuario = criarUsuario();
        repository.save(usuario);

        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        // verificação
        Assertions.assertThat(resultado).isTrue();
    }

    @Test
    public void retornaFalsoQuandoNaoHaEmailCadastrado() {
        // cenario

        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        // verificação

        Assertions.assertThat(resultado).isFalse();
    }

    @Test
    public void devePersistirUmUsuarioNaBaseDeDados() {
        //cenario
        Usuario usuario = criarUsuario();

        //ação
        Usuario usuarioSalvo = repository.save(usuario);

        //resultado
        Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
    }

    @Test
    public void deveBuscarUmUsuarioPorEmail(){
        //cenário
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        //ação
        Optional<Usuario> resultado = repository.findByEmail("usuario@email.com");

        //resultado

        Assertions.assertThat(resultado.isPresent()).isTrue();
    }

    @Test
    public void deveRetornarVazioAoBuscarUmUsuarioPorEmailQuandoNaoExistirNaBase(){
        //ação
        Optional<Usuario> resultado = repository.findByEmail("usuario@email.com");

        //resultado

        Assertions.assertThat(resultado.isPresent()).isFalse();
    }


    public static Usuario criarUsuario(){
        return Usuario
                .builder()
                .nome("Usuario")
                .email("usuario@email.com")
                .senha("senha")
                .build();
    }
}
