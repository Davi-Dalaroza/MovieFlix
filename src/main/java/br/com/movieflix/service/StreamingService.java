package br.com.movieflix.service;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }

    public Streaming savaStreaming(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> findById(Long id){
        return streamingRepository.findById(id);
    }

    public void deleteStreamingByID(Long id){
        streamingRepository.deleteById(id);
    }

    public Optional<Streaming> updateStreaming(Long id, Streaming updateStreaming){
        Optional<Streaming> optionalStreaming = streamingRepository.findById(id);

        if(optionalStreaming.isPresent()){
            Streaming streaming = optionalStreaming.get();
            streaming.setName(updateStreaming.getName());

            streamingRepository.save(streaming);
            return Optional.of(streaming);
        }
        return Optional.empty();
    }
}
