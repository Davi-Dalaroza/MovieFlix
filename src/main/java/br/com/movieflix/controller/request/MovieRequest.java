package br.com.movieflix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "string", description = "Nome do filme.")
                           @NotEmpty(message = "Título do filme é obrigatorio.")
                           String title,
                           @Schema(type = "string", description = "Descrição do filme.")
                           String description,
                           @Schema(type = "date", description = "Data de lançamento do filme. Ex: 'DD/MM/YYYY'")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Nota de avaliação do filme. Ex: 6.5")
                           double rating,
                           @Schema(type = "array", description = "Lista de ID's das categoria do filme.")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de ID's dos streamings do filme.")
                           List<Long> streamings
) {
}
