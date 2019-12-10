package com.invillia.minhasFinancas.service;

import com.invillia.minhasFinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autentica (String email, String senha);

    Usuario criarUsuario (Usuario usuario);

    void validarEmail (String email);
}
