package com.invillia.minhasFinancas.service.impl;

import com.invillia.minhasFinancas.exception.RegraNegocioException;
import com.invillia.minhasFinancas.model.entity.Usuario;
import com.invillia.minhasFinancas.repository.UsuarioRepository;
import com.invillia.minhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autentica(String email, String senha) {
        return null;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail");
        }
    }
}
