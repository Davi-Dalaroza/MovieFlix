package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record UserRequest(@Schema(type = "string", description = "Nome do usuario.")
                          @NotEmpty(message = "Nome é obrigatorio.")
                          String name,
                          @Schema(type = "string", description = "Senha do usuario.")
                          @NotEmpty(message = "Senha é obrigatorio.")
                          String password,
                          @Schema(type = "string", description = "Email do usuario.")
                          @NotEmpty(message = "Email é obrigatorio.")
                          String email) {
}
