package com.invillia.minhasFinancas.service;


import com.invillia.minhasFinancas.exception.RegraNegocioException;
import com.invillia.minhasFinancas.model.entity.Usuario;
import com.invillia.minhasFinancas.repository.UsuarioRepository;
import com.invillia.minhasFinancas.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    UsuarioService service;

    @MockBean
    UsuarioRepository repository;

    @BeforeEach // Cria m mock a partir de um bean gerenciado
    public void setUp() {
        service = new UsuarioServiceImpl(repository);
    }

    @Test
    public void deveValidarEmail() {
        //cenário
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
        //ação
        service.validarEmail("usuario@email.com");
    }


    @Test
    public void deveLançarErroAoValidarEmailQuandoExisteEmailCadastrado() {
        Assertions.assertThrows(RegraNegocioException.class, () -> {
            // cenário
            Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

            // ação
            service.validarEmail("usuario@email.com");
        });
    }


}
