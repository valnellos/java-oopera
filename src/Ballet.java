public class Ballet extends MusicalShow {
    public Choreographer choreographer;

    public Ballet(String title, int duration, String librettoText, Choreographer choreographer, Director director,
                  MusicAuthor musicAuthor) {
        super(title, duration, librettoText);

        this.choreographer = choreographer;
        this.director = director;
        this.musicAuthor = musicAuthor;
    }

    public Ballet() {

    }


    @Override
    public String toString() {
        return "Балет{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", musicAuthor =" + musicAuthor +
                ", choreographer=" + choreographer +
                '}';
    }

    public void addBallet() {
        System.out.println("Введите название балета: ");
        String title = Theatre.scanner.nextLine();
        System.out.println("Введите длительность: ");
        int duration = Theatre.scanner.nextInt();
        Theatre.scanner.nextLine();
        System.out.println("Введите текст либретто: ");
        String librettoText = Theatre.scanner.nextLine();
        System.out.println("Выберите доступного хореографа: ");
        for (int i = 0; i < Theatre.choreographerList.size(); i++) {
            Choreographer element = Theatre.choreographerList.get(i);
            System.out.println("Хореограф №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < Theatre.choreographerList.size(); i++) {

            int index = Theatre.scanner.nextInt();
            index--;
            if (index >= 0 && index < Theatre.choreographerList.size()) {


                choreographer = Theatre.choreographerList.get(index);

            }
        }
        System.out.println("Выберите доступного режиссёра: ");
        for (int i = 0; i < Theatre.directorList.size(); i++) {
            Director element = Theatre.directorList.get(i);
            System.out.println("Режиссёр №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < Theatre.directorList.size(); i++) {

            int index = Theatre.scanner.nextInt();
            index--;
            if (index >= 0 && index < Theatre.directorList.size()) {


                director = Theatre.directorList.get(index);

            }
        }
        System.out.println("Выберите автора музыки: ");
        for (int i = 0; i < Theatre.musicAuthorList.size(); i++) {
            MusicAuthor element = Theatre.musicAuthorList.get(i);
            System.out.println("Режиссёр №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < Theatre.musicAuthorList.size(); i++) {

            int index = Theatre.scanner.nextInt();
            index--;
            if (index >= 0 && index < Theatre.musicAuthorList.size()) {


                musicAuthor = Theatre.musicAuthorList.get(index);

            }
        }

        Theatre.balletList.add(new Ballet(title, duration, librettoText, choreographer, director, musicAuthor));
    }
}
