
public class Director extends Person {
    public int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);

        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return "Режиссер{" +
                "Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Пол='" + gender + '\'' +
                ", Количество поставленных спектаклей='" + numberOfShows + '\'' +
                '}';
    }
}