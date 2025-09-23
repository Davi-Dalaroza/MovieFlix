package br.com.movieflix.controller;

import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Login", description = "Recurso responsavel pelo gerenciamento dos Logins.")
public interface AuthController {

    @Operation(summary = "salvar usuario", description = "Método responsavel por salvar novos usuarios.")
    @ApiResponse(responseCode = "201", description = "Usuario salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<UserResponse> register(@RequestBody UserRequest userResquest);

    @Operation(summary = "Login usuario", description = "Método responsável por autenticar usuario informado.")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuario com senha ou email invalido.", content = @Content())
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest);
}
