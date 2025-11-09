public class Opera extends MusicalShow {
    public Choreographer choreographer;
    public int choirSize;

    public Opera(String title, int duration, String librettoText, int choirSize, Choreographer choreographer,
                 Director director, MusicAuthor musicAuthor) {
        super(title, duration, librettoText);

        this.choirSize = choirSize;
        this.choreographer = choreographer;

        this.setMusicAuthor(musicAuthor);
        this.setDirector(director);
    }

    @Override
    public String toString() {
        return "Opera{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", choreographer=" + choreographer +
                ", musicAuthor =" + musicAuthor +
                ", choirSize=" + choirSize +
                '}';
    }
}

