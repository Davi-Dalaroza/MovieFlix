package br.com.movieflix.response;

import br.com.movieflix.entity.Streaming;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingReponse> streamings) {
}
