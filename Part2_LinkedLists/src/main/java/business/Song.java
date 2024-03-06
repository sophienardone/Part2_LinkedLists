package business;

/**
 *
 * @author michelle
 */
public class Song {

    private  String artist;
    private  String title;


    public Song(){
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }


    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public  String getArtist() {
        return artist;
    }
    public  String getTitle() {
        return title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Song song = (Song) obj;
        if (artist != null ? !artist.equals(song.artist) : song.artist != null) return false;
        return title != null ? title.equals(song.title) : song.title == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
    
}
