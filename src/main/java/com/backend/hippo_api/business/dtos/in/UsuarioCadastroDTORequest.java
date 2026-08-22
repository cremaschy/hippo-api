package com.backend.hippo_api.business.dtos.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCadastroDTORequest {
    private String nome;
    private String email;
    private String senha;
}
