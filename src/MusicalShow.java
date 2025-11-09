public class MusicalShow extends Show {
    public MusicAuthor musicAuthor;
    public String librettoText;

    public MusicalShow(String title, int duration, String librettoText) {
       super(title, duration);

       this.librettoText = librettoText;
    }

    public void printLibrettoText() {
        System.out.println(this.librettoText);
    }

    public void setMusicAuthor(MusicAuthor musicAuthor) {
        this.musicAuthor = musicAuthor;
    }
}
