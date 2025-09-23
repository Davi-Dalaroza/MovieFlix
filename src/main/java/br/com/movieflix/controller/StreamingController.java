package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.StreamingReponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsavel pelo gerenciamento dos streamings.")
public interface StreamingController {

    @Operation(summary = "salvar streaming", description = "Método responsavel por salvar novos streamings.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "streaming salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<StreamingReponse> saveStreaming(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar streaming", description = "Método responsavel por retornar todos os streamings cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os streamings cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<StreamingReponse>> getAllStreamings();

    @Operation(summary = "Buscar streaming por ID", description = "Método responsável por retornar o streaming cadastrado com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<StreamingReponse> getStreamingById(@PathVariable Long id);

    @Operation(summary = "Alterar streaming", description = "Método responsavel por alterar streaming com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<StreamingReponse> updateStreaming(@PathVariable Long id,@Valid @RequestBody StreamingRequest streamingRequest);

    @Operation(summary = "Deleta streaming por ID", description = "Método responsável por deletar o streaming cadastrado com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<Void> deleteStreaming(@PathVariable Long id);
}
