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
    }

    public void printActorList() {
        for (int i = 0; i < this.listOfActors.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + this.listOfActors.get(i));
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

    public void changeActor(Actor oldActor, Actor newActor) {
        // Сопоставляем oldActor и newActor, и если их можно заменить -- проходим дальше
        if (!(Objects.equals(oldActor.name, newActor.name) && Objects.equals(oldActor.surname, newActor.surname) && oldActor.gender == newActor.gender)) {

            // Ищем индекс oldActor для того, чтобы заменить в this.listOfActors.set
            for (int indexOldActor = 0; indexOldActor < this.listOfActors.size(); indexOldActor++) {
                Actor actorInShow = this.listOfActors.get(indexOldActor);
                if (Objects.equals(actorInShow.name, oldActor.name) && Objects.equals(actorInShow.surname, oldActor.surname) && actorInShow.gender == oldActor.gender) {
                    this.listOfActors.set(indexOldActor, newActor);
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Шоу{" +
                "Название='" + title + '\'' +
                ", Длительность=" + duration +
                ", Режиссёр=" + director +
                ", Актёры=" + listOfActors +
                '}';
    }
}