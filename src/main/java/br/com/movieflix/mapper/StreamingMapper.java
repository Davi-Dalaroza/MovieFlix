package br.com.movieflix.mapper;

import br.com.movieflix.entity.Streaming;
import br.com.movieflix.request.StreamingRequest;
import br.com.movieflix.response.StreamingReponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();

    }

    public static StreamingReponse toStreamingResponse(Streaming streaming){
        return StreamingReponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
