package com.backend.hippo_api.business;

import com.backend.hippo_api.infrastructure.entity.Usuario;
import com.backend.hippo_api.infrastructure.exceptions.ConflictException;
import com.backend.hippo_api.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario cadastrarUsuario(Usuario usuario) {
        try {
            emailExiste(usuario.getEmail());

            usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
            usuario.setDataCadastro(LocalDateTime.now());

            return usuarioRepository.save(usuario);
        }
        catch (ConflictException e) {
            throw new ConflictException("Erro: Email " + usuario.getEmail() + " já existe!", e.getCause());
        }
    }

    private void emailExiste(String email) {
        try {
            boolean emailExiste = verificarSeEmailExiste(email);

            if (emailExiste) {
                throw new ConflictException("Erro: Email " + email + " já existe!");
            }
        }
        catch (ConflictException e) {
            throw new ConflictException("Erro: Email " + email + " já existe!", e.getCause());
        }
    }

    private boolean verificarSeEmailExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
