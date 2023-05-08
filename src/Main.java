import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        GUI gui = new GUI();
        
        Album album1 = new Album("Udd gaye", "Ritviz");
        album1.addSongToAlbum("Barish", 5.50);
        album1.addSongToAlbum("Nana karte pyaar", 6.30);
        album1.addSongToAlbum("Dil diya hai jaan bhi denge", 2.20);

        Album album2 = new Album("Moosa", "Sidhu Moosewala");
        album2.addSongToAlbum("Chandra", 3.10);
        album2.addSongToAlbum("Ved tuze", 3.40);
        album2.addSongToAlbum("Sukh kalale", 1.00);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("Sukh kalale", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum("Barish", myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Ved tuze", myPlaylist));

        play(myPlaylist);
    }


    public static void play(List<Song> myPlaylist)
    {
        //ListIterator<datatype> = obj on which you want to iterate.listIterator();
        ListIterator<Song> itr = myPlaylist.listIterator();

        if(myPlaylist.size() == 0)
        {
            System.out.println("playlist is empty.");
            return;
        }

        System.out.println("Currently Playing : ");
        System.out.println(itr.next());
        boolean isNext = true;

        Scanner sc = new Scanner(System.in);
        printMenus();
        while(true)
        {
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1 : // play next song
                    if(myPlaylist.size() == 0)
                    {
                        System.out.println("Playlist is empty.");
                        break;
                    }
                    if(!isNext)
                    {
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext())
                    {
                        isNext = true;
                        System.out.println("Now Playing : " + itr.next());
                    }
                    else System.out.println("You have reached end of the list");
                    break;
                case 2: // play previous song
                    if(myPlaylist.size() == 0)
                    {
                        System.out.println("Playlist is empty.");
                        break;
                    }
                    if(isNext)
                    {
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious())
                    {
                        isNext = false;
                        System.out.println("Now Playing : " + itr.previous());
                    }
                    else System.out.println("You are at first song of playlist");
                    break;
                case 3 : // play current song
                    if(myPlaylist.size() == 0)
                    {
                        System.out.println("Playlist is empty.");
                        break;
                    }
                    if(isNext)
                    {
                        System.out.println(itr.previous());
                        itr.next();
                    }
                    else
                    {
                        System.out.println(itr.next());
                        itr.previous();
                    }
                    break;
                case 4: // delete the current song
                    if(myPlaylist.size() == 0)
                    {
                        System.out.println("Playlist is empty.");
                        break;
                    }
                    if(isNext)
                    {
                        itr.remove();
                    }
                    else
                    {
                        itr.remove();
                    }
                    System.out.println("Song deleted from playlist.");
                    break;
                case 5 : // print all songs
                    if(myPlaylist.size() == 0)
                    {
                        System.out.println("Playlist is empty.");
                        break;
                    }
                    printAllSongs(myPlaylist);
                    break;
                case 6: // print all menus
                    printMenus();
                    break;
                case 7 : // exit
                    return;
            }
        }
    }
    public static void printMenus()
    {
        System.out.println("1.Play next song");
        System.out.println("2.Play previous song");
        System.out.println("3.Play current song again");
        System.out.println("4.Delete current song");
        System.out.println("5.Show all songs");
        System.out.println("6.Show menu again");
        System.out.println("7.Exit");
    }

    public static void printAllSongs(List<Song> playList)
    {
        for(Song song : playList)
        {
            System.out.println(song);
        }
        return;
    }

}