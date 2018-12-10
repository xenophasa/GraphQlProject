package Application;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Mutation implements GraphQLRootResolver {

    private final SongRepository songRepository;

    public Mutation(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song createSong(String title, String artist){
        Song newSong = new Song(title,artist);
        songRepository.saveSong(newSong);
        return newSong;
    }
}
