package com.invillia.minhasFinancas.service.impl;

import com.invillia.minhasFinancas.model.entity.Usuario;
import com.invillia.minhasFinancas.repository.UsuarioRepository;
import com.invillia.minhasFinancas.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

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

    }
}
