package com.zoo.first_spring_app;

import com.zoo.first_spring_app.domain.Usuario;
import com.zoo.first_spring_app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<com.zoo.first_spring_app.domain.Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<com.zoo.first_spring_app.domain.Usuario> buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
