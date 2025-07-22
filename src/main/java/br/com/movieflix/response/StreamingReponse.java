package br.com.movieflix.response;

import lombok.Builder;

@Builder
public record StreamingReponse(Long id, String name) {
}
