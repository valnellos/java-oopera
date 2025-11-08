import java.util.ArrayList;

public class Show {
    public String title;
    public int duration;
    public Director director;
    ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration) {
        this.title = title;
        this.duration = duration;

        System.out.println();
        System.out.println();
        System.out.println(this.title);
        System.out.println();
        System.out.println();
    }

    public Show() {

    }

    public void printActorList() {
        this.listOfActors.forEach(actor -> {
            System.out.println(actor.toString());
        });
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addActor(Actor actor) {
        this.listOfActors.add(actor);
    }

    public void changeActor(Actor actor, int position) {
        if (this.listOfActors.isEmpty() || position > this.listOfActors.size() - 1 || position < 0) {
            System.out.println("Error!");
            return;
        }

        this.listOfActors.set(position, actor);
    }

    public void addActorInShow() {
        for (int i = 0; i < Theatre.actorList.size(); i++) {
            Actor element = Theatre.actorList.get(i);
            System.out.println("Актер №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < Theatre.actorList.size(); i++) {

            int index = Theatre.scanner.nextInt();
            index--;
            if (index >= 0 && index < Theatre.actorList.size()) {


                Actor actor = Theatre.actorList.remove(index);
                System.out.println("В какой спектакль вы хотите добавить актера? 1 - Баллет, 2 - Опера, 3 - Шоу");
                int command = Theatre.scanner.nextInt();
                if (command == 1) {
                    if (!Theatre.balletList.contains(actor)) {
                        Theatre.balletList.add(actor);
                    } else {
                        System.out.println("Актёр уже добавлен в балет.");
                    }
                } else if (command == 2) {
                    if (!Theatre.operaList.contains(actor)) {
                        Theatre.operaList.add(actor);
                    } else {
                        System.out.println("Актёр уже добавлен в оперу.");
                    }
                } else if (command == 3) {
                    if (!Theatre.showList.contains(actor)) {
                        Theatre.showList.addFirst(actor);
                    } else {
                        System.out.println("Актёр уже добавлен в шоу.");
                    }
                }

            }


        }

    }

    public void addNormalShow() {
        System.out.println("Введите название шоу: ");
        String title = Theatre.scanner.nextLine();
        System.out.println("Введите длительность: ");
        int duration = Theatre.scanner.nextInt();
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

            Theatre.showList.add(new Opera(title, duration, director));
        }
    }
}