import java.util.Scanner;

public class Actor extends Person {
    public int height;

    Scanner scanner = new Scanner(System.in);

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);

        this.height = height;
    }

    public Actor() {

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

    public void addMultipleActors() {
        System.out.print("Сколько актёров вы хотите добавить? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Актёр №" + (i + 1));
            addNewActor();
        }
    }

    public void addNewActor() {
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(Theatre.scanner.nextLine());
        System.out.print("Введите рост: ");
        int height = scanner.nextInt();

        Theatre.actorList.add(new Actor(name, surname, gender, height));
    }
}
