package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> newMovieList = movieLists.stream().flatMap(p -> p.getVideos().stream())
                .map(p -> ImmutableMap.of("id", p.getId(), "title", p.getTitle(), "time", new Date(), "url",p.getBoxarts().stream().reduce((a,b)-> {
                    if(a.getHeight()*a.getHeight() < b.getWidth()*b.getWidth()){
                        return a;
                    }
                    return b;
                }).map(l -> l.getUrl()))).collect(Collectors.toList());

        return newMovieList;
    }
}
