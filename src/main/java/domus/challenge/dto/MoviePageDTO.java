package domus.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviePageDTO {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<MovieDTO> data;

}
