package domus.challenge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domus.challenge.dto.DirectorsList;
import domus.challenge.dto.MoviePageDTO;
import domus.challenge.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.TreeMap;

@Service
public class DirectorServiceImpl implements DirectorService {

    // private RestTemplate restTemplate = null ;

    private final WebClient client;

    public DirectorServiceImpl() {
        client = WebClient.create("https://challenge.iugolabs.com");
    }

    @Override
    public DirectorsList findByNumberOfMovies(int threshold) {
        Integer numPage = 1;
        int totalPages = 0;
        String partialUrl ;

        DirectorsList directorsList = new DirectorsList();

        if  (threshold < 0) {
            return directorsList;
        }

        Map<String,Integer> numMoviesDirector = new TreeMap<String,Integer>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null ;
        do {
            partialUrl = "/api/movies/search?page=" + numPage;

            Mono<String> employeeMono = client.get()
                    .uri( partialUrl )
                    .retrieve()
                    .bodyToMono(String.class);

            String body = employeeMono.block();
            // response = restTemplate.getForEntity("https://challenge.iugolabs.com/api/movies/search?page=" + numPage , String.class);

            // String body = response.getBody();

            totalPages = procesarBody(body, numMoviesDirector);

            numPage++ ;

        } while (numPage <= totalPages);

            numMoviesDirector.forEach( (k,v)-> {
            if (v > threshold) {
                directorsList.addDirector(k);
            }
        } );

        return directorsList;
    }

    private int procesarBody(String body, Map<String,Integer> numMoviesActor) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        int page = 0 ;
        int perPage = 0 ;
        int total = 0 ;
        int total_pages = 0 ;
        try {
            root = mapper.readTree(body);
            page = root.get("page").asInt();
            perPage = root.get("per_page").asInt() ;
            total = root.get("total").asInt() ;
            total_pages = root.get("total_pages").asInt() ;

            JsonNode arrayData = root.get("data");

            if (arrayData.isArray() ) {
                for (final JsonNode objNode : arrayData) {
                    String director = objNode.get("Director").asText();

                    if (numMoviesActor.containsKey(director)) {
                        numMoviesActor.put(director, numMoviesActor.get(director) + 1);
                    } else {
                        numMoviesActor.put(director, 1);
                    }
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return total_pages;
    }

}
