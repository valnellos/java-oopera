import java.util.ArrayList;
import java.util.Objects;

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

    public void printActorList() {
        for (Actor actor : this.listOfActors) {
            System.out.println(actor.toString());
        }
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public boolean addActor(Actor newActor) {
        boolean isExistActorInShow = false;

        for (Actor actorInShow : this.listOfActors) {
            if (Objects.equals(actorInShow.name, newActor.name) && Objects.equals(actorInShow.surname, newActor.surname) && actorInShow.gender == newActor.gender) {
                isExistActorInShow = true;
                break;
            }
        }

        if (isExistActorInShow) {
            return false;
        }

        this.listOfActors.add(newActor);

        return true;
    }

    public void changeActor(Actor actor, int position) {
        if (listOfActors.isEmpty() || position > listOfActors.size() - 1 || position < 0) {
            System.out.println("Error!");
            System.out.println("Список актеров в Шоу пуст!");
            System.out.println("Переданная позиция больше чем актеров в шоу!");
            System.out.println("Переданная позиция не может быть 0!");
            return;
        }

        this.listOfActors.set(position, actor);
    }
}