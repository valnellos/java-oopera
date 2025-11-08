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
        if (listOfActors.isEmpty() || position > listOfActors.size() - 1 || position < 0) {
            System.out.println("Error!");
            return;
        }

        this.listOfActors.set(position, actor);
    }
}