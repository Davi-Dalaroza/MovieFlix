package br.com.movieflix.controller;

import br.com.movieflix.controller.request.CategoryRequest;
import br.com.movieflix.controller.response.CategoryResponse;
import br.com.movieflix.controller.response.MovieResponse;
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

@Tag(name = "Category", description = "Recurso responsavel pelo gerenciamento de categorias.")
public interface CategoryController {

    @Operation(summary = "salvar categoria", description = "Método responsavel por salvar novas categorias.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Buscar categoria", description = "Método responsavel por retornar todas as categorias cadastradas.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todas as categorias cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<CategoryResponse>> getAllCategories();

    @Operation(summary = "Buscar categoria por ID", description = "Método responsável por retornar a categoria cadastrada com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content())
    ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id);

    @Operation(summary = "Alterar categoria", description = "Método responsavel por alterar categoria com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrado.", content = @Content())
    ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,@Valid @RequestBody CategoryRequest categoryRequest);

    @Operation(summary = "Deleta categoria por ID", description = "Método responsável por deletar a categoria cadastrada com o ID informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria não encontrado.", content = @Content())
    ResponseEntity<Void> deleteCategory(@PathVariable Long id);
}
