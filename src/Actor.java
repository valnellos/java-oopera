
public class Actor extends Person {
    public int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);

        this.height = height;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                '}';
    }
}
