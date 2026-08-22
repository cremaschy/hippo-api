package com.backend.hippo_api.business.converter;

import com.backend.hippo_api.business.dtos.in.UsuarioCadastroDTORequest;
import com.backend.hippo_api.business.dtos.out.UsuarioCadastroDTOResponse;
import com.backend.hippo_api.infrastructure.entity.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
    // Converter de UsuarioDTO para Usuario - Cadastro
    public Usuario converterParaUsuario(UsuarioCadastroDTORequest usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .build();
    }

    // Converter de Usuario para UsuarioDTO - Cadastro
    public UsuarioCadastroDTOResponse converterParaUsuarioDTO(Usuario usuario) {
        return UsuarioCadastroDTOResponse.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .dataCadastro(usuario.getDataCadastro())
                .build();
    }
}
