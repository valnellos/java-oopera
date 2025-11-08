import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
    static Scanner scanner = new Scanner(System.in);
    static MusicAuthor musicAuthor = new MusicAuthor();
    static Director director = new Director();
    static Choreographer choreographer = new Choreographer();
    static Ballet ballet = new Ballet();
    static Opera opera = new Opera();
    static Show show = new Show();

    // People
    static ArrayList<Actor> actorList = new ArrayList<>();
    static ArrayList<Director> directorList = new ArrayList<>();
    static ArrayList<Choreographer> choreographerList = new ArrayList<>();
    static ArrayList<MusicAuthor> musicAuthorList = new ArrayList<>();

    // Shows
    static ArrayList<Object> balletList = new ArrayList<>();
    static ArrayList<Object> showList = new ArrayList<>();
    static ArrayList<Object> operaList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Поехали!");

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addMultipleActors();
                    System.out.println("Актер успешно добавлен");
                    break;
                case "2":
                    director.addMultipleDirectors();
                    break;
                case "3":
                    musicAuthor.addNewMusicAuthor();
                    break;
                case "4":
                    choreographer.addNewChoreograpger();
                    break;
                case "5":
                    System.out.println("Выберите тип постановки: 1 - Баллет, 2 - Опера, 3 - Шоу");
                    int command2 = scanner.nextInt();
                    scanner.nextLine();
                    if (command2 == 1) {
                        ballet.addBallet();
                    } else if (command2 == 2) {
                        opera.addOpera();
                    } else if (command2 == 3) {
                        show.addNormalShow();
                    } else {
                        System.out.println("Извините такой команды не существует");
                    }
                    break;
                case "6":
                    System.out.println("Выберите актера которого хотите добавить в спектакль");
                    show.addActorInShow();
                    break;
                case "7":
                    System.out.println("Для какого спектакля вы хотите вывести труппу? (1 - Опера,2 - Балет,3 - Шоу");
                    int command1 = scanner.nextInt();
                    if (command1 == 1) {
                        System.out.println(operaList);
                    } else if (command1 == 2) {
                        System.out.println(balletList);
                    } else if (command1 == 3) {
                        System.out.println(showList);
                    } else {
                        System.out.println("Извините такой команды не существует");
                    }
                    break;
                case "8":
                    printActorList();
                    break;
                default:
                    System.out.println("Некорректная команда");

            }
        }


        // Peoples
       /* actorList.add(new Actor("Alexey", "Ho", Gender.MALE, 180));
        actorList.add(new Actor("Egot", "Oil", Gender.MALE, 175));
        actorList.add(new Actor("Jan", "Yasd", Gender.FEMALE, 150));

        directorList.add(new Director("Igor", "Zal", Gender.MALE, 180));
        directorList.add(new Director("Elena", "Pol", Gender.FEMALE, 150));

        choreographerList.add(new Choreographer("Elena", "Pol", Gender.FEMALE));

        musicAuthorList.add(new MusicAuthor("Elena", "Pol", Gender.FEMALE));

        // Shows
        ballet = new Ballet("Ballet 1", 100, "Text text text text.", choreographerList.getFirst());
        ballet.setDirector(directorList.getLast());
        ballet.setMusicAuthor(musicAuthorList.getFirst());

        ballet.addActor(actorList.get(1));
        ballet.printActorList(); // ballet вывести актеров
        ballet.printLibrettoText();

        System.out.println();
        System.out.println();
        System.out.println();

        music = new MusicalShow("MusicalShow 1", 200, "Text text text 1231313 text.");
        music.setDirector(directorList.getFirst());

        music.addActor(actorList.get(0));
        music.addActor(actorList.get(1));
        music.addActor(actorList.get(2));
        music.printActorList(); // music вывести актеров

        System.out.println();
        System.out.println();
        System.out.println();


        opera = new Opera("Opera 1", 110, "Text 123213213 text text text.",10);
        opera.setDirector(directorList.getLast());
        opera.setMusicAuthor(musicAuthorList.getFirst());

        opera.addActor(actorList.get(2));
        opera.addActor(actorList.get(0));
        opera.printActorList(); // opera вывести актеров
        opera.printLibrettoText();

        System.out.println();
        System.out.println();
        System.out.println();



        System.out.println("Пробуем менять Актера у Opera 1");
        opera.changeActor(actorList.get(1), 0);
        opera.printActorList();
        System.out.println();
        System.out.println();
        System.out.println();



        System.out.println("Пробуем поменять на несуществующего актера под номером 15");
        opera.changeActor(actorList.get(1), 15);
        opera.printActorList();
        System.out.println();
        System.out.println();
        System.out.println();
    }*/


    }

    public static void printMenu() {
        System.out.println("Выберите нужную команду: ");
        System.out.println("1) Добавить актера.");
        System.out.println("2) Добавить режиссёра.");
        System.out.println("3) Добавить автора музыки.");
        System.out.println("4) Добавить хореографа.");
        System.out.println("5) Создать спектакль.");
        System.out.println("6) Добавить актера в спектакль.");
        System.out.println("7) Вывести список труппы для каждого спектакля.");
        System.out.println("8) Заменить актера в спектакле.");

    }

    public static void printActorList() {
        actorList.forEach(actor -> {
            System.out.println(actor.toString());
        });
    }

    public static void addMultipleActors() {
        System.out.print("Сколько актёров вы хотите добавить? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Актёр №" + (i + 1));
            addNewActor();
        }
    }

    public static void addNewActor() {
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(Theatre.scanner.nextLine());
        System.out.print("Введите рост: ");
        int height = scanner.nextInt();

        actorList.add(new Actor(name, surname, gender, height));
    }
}