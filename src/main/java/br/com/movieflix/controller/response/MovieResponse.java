package br.com.movieflix.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "long", description = "ID do filme.")
                            Long id,
                            @Schema(type = "string", description = "Nome do filme.")
                            @NotEmpty(message = "Nome do filme é obrigatorio.")
                            String title,
                            @Schema(type = "string", description = "Descrição do filme.")
                            String description,
                            @Schema(type = "date", description = "Data de lançamento do filme.")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,
                            @Schema(type = "double", description = "Nota de avaliação do filme.")
                            double rating,
                            @Schema(type = "array", description = "Lista de ID's das categoria do filme.")
                            List<CategoryResponse> categories,
                            @Schema(type = "array", description = "Lista de ID's dos streamings do filme.")
                            List<StreamingReponse> streamings) {
}
