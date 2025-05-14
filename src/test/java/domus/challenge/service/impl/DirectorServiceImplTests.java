package domus.challenge.service.impl;

import domus.challenge.dto.DirectorsList;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DirectorServiceImplTests {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    private DirectorServiceImpl directorService;

    String response =
            "{"
                    + "   \"page\":1,"
                    + "   \"per_page\":10,"
                    + "   \"total\":3,"
                    + "   \"total_pages\":1,"
                    + "   \"data\":["
                    + "      {"
                    + "         \"Title\":\"American Sniper\","
                    + "         \"Year\":\"2014\","
                    + "          \"Rated\":\"R\","
                    + "          \"Released\":\"16 Jan 2015\","
                    + "          \"Runtime\":\"133 min\","
                    + "          \"Genre\":\"Action, Biography, Drama\","
                    + "          \"Director\":\"Clint Eastwood\","
                    + "          \"Writer\":\"Jason Hall, Chris Kyle, Scott McEwen\","
                    + "          \"Actors\":\"Bradley Cooper, Sienna Miller, Kyle Gallner\" "
                    + "       },"
                    + "       {"
                    + "          \"Title\":\"Julieta\","
                    + "          \"Year\":\"2016\","
                    + "          \"Rated\":\"R\","
                    + "          \"Released\":\"21 Dec 2016\","
                    + "          \"Runtime\":\"99 min\","
                    + "          \"Genre\":\"Drama, Mystery, Romance\","
                    + "          \"Director\":\"Pedro Almodóvar\","
                    + "          \"Writer\":\"Pedro Almodóvar, Alice Munro\","
                    + "          \"Actors\":\"Emma Suárez, Adriana Ugarte, Daniel Grao\" "
                    + "       },"
                    + "       {"
                    + "          \"Title\":\"I'm So Excited!\", "
                    + "          \"Year\":\"2013\", "
                    + "          \"Rated\":\"R\", "
                    + "          \"Released\":\"08 Mar 2013\", "
                    + "          \"Runtime\":\"90 min\", "
                    + "          \"Genre\":\"Comedy, Musical\", "
                    + "          \"Director\":\"Pedro Almodóvar\", "
                    + "          \"Writer\":\"Pedro Almodóvar\", "
                    + "          \"Actors\":\"Javier Cámara, Pepa Charro, Cecilia Roth\" "
                    + "       }"
                    + "    ]"
                    + " }" ;


    @Test
    public void findByNumberOfMovies_thresholdEqualsThree() {
        ResponseEntity<String> response = new ResponseEntity<>( this.response, null, 200); ;

        //when( restTemplate.getForEntity( any() ,Mockito.any(Class.class) ) ).thenReturn(response);

        DirectorsList directorsList = directorService.findByNumberOfMovies(3);

        assert (directorsList.getDirectors().size() == 4);
    }

    @Test
    public void findByNumberOfMovies_thresholdEqualsNegativeNumber() {
        ResponseEntity<String> response = new ResponseEntity<>( this.response, null, 200); ;

        //when( restTemplate.getForEntity( any() ,Mockito.any(Class.class) ) ).thenReturn(response);

        DirectorsList directorsList = directorService.findByNumberOfMovies(-1);

        assert (directorsList.getDirectors().size() == 0);
    }

}
