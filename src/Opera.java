public class Opera extends MusicalShow {
    public Choreographer choreographer;
    public int choirSize;

    public Opera(String title, int duration, Director director) {
    }

    public Opera() {

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

    public Opera(String title, int duration, String librettoText, int choirSize, Choreographer choreographer,
                 Director director, MusicAuthor musicAuthor) {
        super(title, duration, librettoText);

        this.choirSize = choirSize;
        this.choreographer = choreographer;
        this.director = director;

    }

    public void addOpera() {
        System.out.println("Введите название оперы: ");
        String title = Theatre.scanner.nextLine();
        System.out.println("Введите длительность: ");
        int duration = Theatre.scanner.nextInt();
        Theatre.scanner.nextLine();
        System.out.println("Введите текст либретто: ");
        String librettoText = Theatre.scanner.nextLine();
        System.out.println("Введите размер хора: ");
        int choirSize = Theatre.scanner.nextInt();
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
            System.out.println("Автор музыки №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < Theatre.musicAuthorList.size(); i++) {

            int index = Theatre.scanner.nextInt();
            index--;
            if (index >= 0 && index < Theatre.musicAuthorList.size()) {


                musicAuthor = Theatre.musicAuthorList.get(index);

            }
        }

        Theatre.operaList.add(new Opera(title, duration, librettoText, choirSize, choreographer, director, musicAuthor));
    }
}

