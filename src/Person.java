public abstract class Person {
    public String name;
    public String surname;
    public Gender gender;

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
}
