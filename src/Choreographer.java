public class Choreographer extends Person {
    public Choreographer(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    public Choreographer() {

    }

    @Override
    public String toString() {
        return "Choreographer{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void addNewChoreograpger() {
        System.out.print("Введите Имя: ");
        String name = Theatre.scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = Theatre.scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(Theatre.scanner.nextLine());


        Theatre.choreographerList.add(new Choreographer(name, surname, gender));
    }
}
