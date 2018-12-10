package Application;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final SongRepository songRepository;

    public Query(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public List<Song> allSongs(){
        return songRepository.getAllSongs();
    }
}
