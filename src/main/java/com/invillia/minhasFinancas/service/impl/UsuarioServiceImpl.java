package com.invillia.minhasFinancas.service.impl;

import com.invillia.minhasFinancas.exception.ErroAutenticacao;
import com.invillia.minhasFinancas.exception.RegraNegocioException;
import com.invillia.minhasFinancas.model.entity.Usuario;
import com.invillia.minhasFinancas.repository.UsuarioRepository;
import com.invillia.minhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autentica(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);

        if(!usuario.isPresent()){
            throw new ErroAutenticacao("Usuário não encontrado. Confira o e-mail digitado ou cadastre-se!");
        }
        if(usuario.get().getSenha().equals(senha)){
            throw new ErroAutenticacao("Senha inválida.");
        }
        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario criarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail");
        }
    }
}
