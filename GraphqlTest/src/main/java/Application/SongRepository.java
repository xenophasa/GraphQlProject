package Application;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class SongRepository {

    private final MongoCollection<Document> songs;

    SongRepository(MongoCollection<Document> songs) {
        this.songs = songs;
    }

    public Song findById(String id) {
        Document doc = songs.find(eq("_id", new ObjectId(id))).first();
        return song(doc);
    }

    public List<Song> getAllSongs() {
        List<Song> allLinks = new ArrayList<>();
        for (Document doc : songs.find()) {
            allLinks.add(song(doc));
        }
        return allLinks;
    }

    public void saveSong(Song song) {
        Document doc = new Document();
        doc.append("title", song.getTitle());
        doc.append("artist", song.getArtist());
        songs.insertOne(doc);
    }

    private Song song(Document doc) {
        return new Song(
                doc.get("_id").toString(),
                doc.getString("title"),
                doc.getString("artist"));
    }
}
