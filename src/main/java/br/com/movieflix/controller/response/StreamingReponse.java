package br.com.movieflix.controller.response;

import lombok.Builder;

@Builder
public record StreamingReponse(Long id, String name) {
}
