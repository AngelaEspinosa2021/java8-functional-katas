package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<String> url = movies.stream().flatMap(x -> x.getBoxarts().stream()).reduce((a, b)->{
            if(a.getHeight()*a.getHeight() > b.getWidth()*b.getWidth()){
                return a;
            }
            return b;
        }).map(x -> x.getUrl());

        return url.get();
    }
}
