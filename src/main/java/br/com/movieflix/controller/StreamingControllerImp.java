package br.com.movieflix.controller;

import br.com.movieflix.entity.Streaming;
import br.com.movieflix.mapper.StreamingMapper;
import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.StreamingReponse;
import br.com.movieflix.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingControllerImp implements StreamingController {

    private final StreamingService streamingService;

    @PostMapping
    public ResponseEntity<StreamingReponse> saveStreaming(@Valid @RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savaedStreaming = streamingService.savaStreaming(newStreaming);
        StreamingReponse streamingReponse = StreamingMapper.toStreamingResponse(savaedStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingReponse);
    }

    @GetMapping()
    public ResponseEntity<List<StreamingReponse>> getAllStreamings() {
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingReponse> listResponse = streamings.stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();
        return ResponseEntity.ok(listResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingReponse> getStreamingById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<StreamingReponse> updateStreaming(@PathVariable Long id,@Valid @RequestBody StreamingRequest streamingRequest) {
        return streamingService.updateStreaming(id, StreamingMapper.toStreaming(streamingRequest))
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        Optional<Streaming> streamingDelete = streamingService.findById(id);
        if (streamingDelete.isPresent()) {
            streamingService.deleteStreamingByID(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
