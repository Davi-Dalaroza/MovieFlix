package br.com.movieflix.controller.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@Schema(type = "string", description = "Nome do streaming.")
                               @NotEmpty(message = "Nome da stream é obrigatorio.")
                               String name){
}
