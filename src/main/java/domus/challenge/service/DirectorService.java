package domus.challenge.service;

import domus.challenge.dto.DirectorsList;
import org.springframework.web.bind.annotation.PathVariable;

public interface DirectorService {

    DirectorsList findByNumberOfMovies(@PathVariable(name="threshold") int threshold);
}
