
public class Director extends Person {
    public int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);

        this.numberOfShows = numberOfShows;
    }

    public Director() {

    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", numberOfShows='" + numberOfShows + '\'' +
                '}';
    }


    public void addMultipleDirectors() {
        System.out.print("Сколько Режиссеров вы хотите добавить? ");
        int count = Theatre.scanner.nextInt();
        Theatre.scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Режиссер №" + (i + 1));
            addNewDirector();
        }
    }

    public void addNewDirector() {

        System.out.print("Введите Имя: ");
        String name = Theatre.scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = Theatre.scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(Theatre.scanner.nextLine());
        System.out.println("Введите количество поставленных спектаклей");
        int numberOfShows = Theatre.scanner.nextInt();


        Theatre.directorList.add(new Director(name, surname, gender , numberOfShows));
    }
}