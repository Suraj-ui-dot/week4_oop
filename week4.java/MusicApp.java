class Songs {
    String title;
String artist;


public Songs(String title , String artist) {
    this.title = title;
    this .artist = artist;

}
public void play(){
    System.out.println("Title:"+title);
    System.out.println("Artist:+artist");

}
class RockSongs extends Songs {

    public RockSongs(String title , String artist){
        super(title , artist);
    }
    @Override
    public void play(){
        System.out.println("Title :"+ title);
        System.out.println("Arrtist:" + artist);
    }

        class PopSong extends Songs {
    public PopSong(String title, String artist) {
        super(title, artist);


        }

        @Override
        public void play() {
                    System.out.println("Title :"+ title);
        System.out.println("Arrtist:" + artist);

              
    }
    class JazzSong extends Songs {
        public JazzSong(String title, String artist) {
            super(title , artist);

        }
        @Override
        public void play() {
                    System.out.println("Title :"+ title);
        System.out.println("Arrtist:" + artist);

        }

    }

    }
    public class MusicApp {
 public static void main(String[] args) {
    Songs []  playlist= new Songs [3];

        playlist[0] = new Songs("Levitating", "Dua Lipa");
        playlist[1] = new Songs("Back in Black", "AC/DC");
        playlist[2] = new Songs("Take Five", "Dave Brubeck");
        
        for (Songs song : playlist) {
            song.play();
            System.out.println("songs");

    
         }
        }

    }
}
}



    



     
 
