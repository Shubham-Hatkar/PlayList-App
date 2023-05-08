import java.util.ArrayList;
import java.util.List;

public class Album
{
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // find song
    boolean findSong(String title)
    {
        for(Song song : songs)
        {
            if((song.getTitle()).equals(title)) return true;
        }
        return false;
    }

    // add song to album
    String addSongToAlbum(String title, double duration)
    {
        if(findSong(title) == false)
        {
            Song s = new Song(title, duration);
            songs.add(s);
            return "song added to the album";
        }
        else return "song already exist.";
    }

    String addSongToPlaylistFromAlbum(String title, List<Song> playlist)
    {
        if(findSong(title) == true)
        {
            for(Song song : this.songs)
            {
                if(song.getTitle().equals(title))
                {
                    playlist.add(song);
                    return  song + " song added to your playlist";
                }
            }
        }
        return "song not present in album";
    }

    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist)
    {
        int index = trackNo;
        if(index >= 0 && index < this.songs.size())
        {
            playlist.add(this.songs.get(index));
            return "song is added to your playlist";
        }

        return "Invalid position of song";
    }

}
