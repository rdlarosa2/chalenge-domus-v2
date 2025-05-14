package domus.challenge.controllers;

import domus.challenge.dto.DirectorsList;
import domus.challenge.dto.UserErrorResponse;
import domus.challenge.exceptions.ValidateThresholdException;
import domus.challenge.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@Tag(name="API Movie Director")
public class DirectorRestController {

    private final  DirectorService directorService;

    @Autowired
    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Operation(
            summary = "Get directors of movies with more than N (threshold) movies",
            description = "Get directors of movies with more than N (threshold) movies",
            tags = {"API Movie Director"}
    )
    @GetMapping("/directors?threshold={threshold}")
    public DirectorsList findByNumberOfMovies(@PathVariable(name="threshold") String threshold) {
        int  numThreshold = 0;

        if (!validateThreshold(threshold)) {
            throw new ValidateThresholdException("The threshold must be a non negative integer");
        }

        numThreshold = Integer.parseInt(threshold);

        return directorService.findByNumberOfMovies(numThreshold);
    }

    private boolean validateThreshold(String str) {
        String regularExp = "^-?(0|[1-9]\\d*)$" ;

        Pattern p = Pattern.compile(regularExp);
        Matcher m = p.matcher(str);
        boolean unifica = m.matches();
        return unifica;
    }


    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(ValidateThresholdException exc) {
        UserErrorResponse error = new UserErrorResponse(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


}
