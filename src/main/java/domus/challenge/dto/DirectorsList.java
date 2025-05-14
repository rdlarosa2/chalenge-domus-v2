package domus.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DirectorsList {
   private List<String> directors;

   public DirectorsList() {
       directors = new ArrayList<String>();
   }

   public void addDirector(String director) {
       this.directors.add(director);
   }

}
