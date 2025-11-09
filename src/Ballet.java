public class Ballet extends MusicalShow {
    public Choreographer choreographer;

    public Ballet(String title, int duration, String librettoText, Choreographer choreographer, Director director,
                  MusicAuthor musicAuthor) {
        super(title, duration, librettoText);

        this.choreographer = choreographer;

        this.setDirector(director);
        this.setMusicAuthor(musicAuthor);
    }


    @Override
    public String toString() {
        return "Балет{" +
                "Название='" + title + '\'' +
                ", Длительность=" + duration +
                ", Режиссер=" + director +
                ", Автор музыки=" + musicAuthor +
                ", Хореограф=" + choreographer +
                ", Актеры=" + listOfActors +
                '}';
    }
}
