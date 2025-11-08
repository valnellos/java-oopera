import java.util.Scanner;

public class MusicAuthor extends Person {
    public MusicAuthor(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }


    public MusicAuthor() {
        super();
    }

    @Override
    public String toString() {
        return "MusicAuthor{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void addNewMusicAuthor() {

        System.out.print("Введите Имя: ");
        String name = Theatre.scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = Theatre.scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(Theatre.scanner.nextLine());


        Theatre.musicAuthorList.add( new MusicAuthor(name, surname, gender));
    }
}
