package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingReponse(@Schema(type = "long", description = "ID do streaming.")
                               Long id,
                               @Schema(type = "string", description = "Nome do streaming.")
                               String name) {
}
