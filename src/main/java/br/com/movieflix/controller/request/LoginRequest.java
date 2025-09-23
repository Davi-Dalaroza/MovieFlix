package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@Schema(type = "string", description = "Email do usuario.")
                           @NotEmpty(message = "Email é obrigatorio.")
                           String email,
                           @Schema(type = "string", description = "Senha do usuario.")
                           @NotEmpty(message = "Senha é obrigatorio.")
                           String password) {

}
