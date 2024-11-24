package br.com.api.zoo.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String nome,@NotBlank String email,@NotBlank String cpf,@NotBlank String senha,@NotBlank String data) {



}
