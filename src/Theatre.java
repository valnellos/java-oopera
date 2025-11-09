import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
    static Scanner scanner = new Scanner(System.in);

    // People
    static ArrayList<Actor> actorList = new ArrayList<>();
    static ArrayList<Director> directorList = new ArrayList<>();
    static ArrayList<Choreographer> choreographerList = new ArrayList<>();
    static ArrayList<MusicAuthor> musicAuthorList = new ArrayList<>();

    // Shows
    static Ballet ballet;
    static Show show;
    static Opera opera;

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
                    addMultipleDirectors();
                    break;
                case "3":
                    addNewMusicAuthor();
                    break;
                case "4":
                    addNewChoreographer();
                    break;
                case "5":
                    System.out.println("Выберите тип постановки: 1 - Баллет, 2 - Опера, 3 - Шоу");
                    int command2 = scanner.nextInt();
                    scanner.nextLine();
                    if (command2 == 1) {
                        addBallet();
                    } else if (command2 == 2) {
                        addOpera();
                    } else if (command2 == 3) {
                        addNormalShow();
                    } else {
                        System.out.println("Извините такой команды не существует");
                    }
                    break;
                case "6":
                    System.out.println("Выберите актера которого хотите добавить в спектакль");
                    addActorInShow();
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
                    switchActor();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Некорректная команда");
            }
        }
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
        System.out.println("9) Закончить работу программы");

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

    // FIXME: Добавить проверки на пустые и невалидные значения
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

    public static void addMultipleDirectors() {
        System.out.print("Сколько Режиссеров вы хотите добавить? ");
        int count = scanner.nextInt();
        Theatre.scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Режиссер №" + (i + 1));
            addNewDirector();
        }
    }

    // FIXME: Добавить проверки на пустые и невалидные значения
    public static void addNewDirector() {
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.println("Введите количество поставленных спектаклей");
        int numberOfShows = scanner.nextInt();

        directorList.add(new Director(name, surname, gender, numberOfShows));
    }

    // FIXME: Добавить проверки на пустые и невалидные значения
    public static void addNewMusicAuthor() {
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        musicAuthorList.add(new MusicAuthor(name, surname, gender));
    }

    // FIXME: Добавить проверки на пустые и невалидные значения
    public static void addNewChoreographer() {
        System.out.print("Введите Имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите Фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        choreographerList.add(new Choreographer(name, surname, gender));
    }

    /// +
    public static void addOpera() {
//        if (choreographerList.isEmpty()) {
//            System.out.println("Добавь хотя бы одного Choreographer");
//            return;
//        }
//
//        if (directorList.isEmpty()) {
//            System.out.println("Добавь хотя бы одного Director");
//            return;
//        }
//
//        if (musicAuthorList.isEmpty()) {
//            System.out.println("Добавь хотя бы одного MusicAuthor");
//            return;
//        }


        System.out.println("Введите название оперы: ");
        String title = scanner.nextLine();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();
        Theatre.scanner.nextLine();

        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.nextLine();

        System.out.println("Введите размер хора: ");
        int choirSize = scanner.nextInt();

        // FIXME: Вынести в функцию -- на подумать
        Choreographer choreographer = null; // Пустой Choreographer
        System.out.println("Выберите доступного хореографа: ");
        for (int i = 0; i < choreographerList.size(); i++) {
            System.out.println("Хореограф №" + (i + 1) + " " + choreographerList.get(i));
        }
        for (int i = 0; i < choreographerList.size(); i++) {
            int index = scanner.nextInt();
            index--;

            // Отрабатываем ошибку неверного ввода
            if (index < 0 || index >= choreographerList.size()) {
                System.out.println("Неверно выбран Choreographer");
                return;
            }

            // Записываем Choreographer в Оперу
            choreographer = choreographerList.get(index);
        }

        // FIXME: Вынести в функцию -- на подумать
        Director director = null; // Пустой Director
        System.out.println("Выберите доступного режиссёра: ");
        for (int i = 0; i < directorList.size(); i++) {
            System.out.println("Режиссёр №" + (i + 1) + " " + directorList.get(i));
        }
        for (int i = 0; i < directorList.size(); i++) {
            int index = scanner.nextInt();
            index--;

            if (index < 0 || index >= directorList.size()) {
                System.out.println("Неверно выбран Director");
                return;
            }

            director = directorList.get(index);
        }

        // FIXME: Вынести в функцию -- на подумать
        MusicAuthor musicAuthor = null; // Пустой MusicAuthor
        System.out.println("Выберите автора музыки: ");
        for (int i = 0; i < musicAuthorList.size(); i++) {
            System.out.println("Автор музыки №" + (i + 1) + " " + musicAuthorList.get(i));
        }
        for (int i = 0; i < musicAuthorList.size(); i++) {
            int index = scanner.nextInt();
            index--;

            if (index < 0 || index >= musicAuthorList.size()) {
                System.out.println("Неверно выбран MusicAuthor");
                return;
            }

            musicAuthor = musicAuthorList.get(index);
        }

        if (choreographer == null || director == null || musicAuthor == null) {
            return;
        }

        Theatre.opera = new Opera(title, duration, librettoText, choirSize, choreographer, director, musicAuthor);
    }

    public static void addNormalShow() {
        System.out.println("Введите название шоу: ");
        String title = scanner.nextLine();
        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();

        System.out.println("Выберите доступного режиссёра: ");
        for (int i = 0; i < directorList.size(); i++) {
            Director element = directorList.get(i);
            System.out.println("Режиссёр №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < directorList.size(); i++) {
            int index = scanner.nextInt();
            index--;
            if (index >= 0 && index < directorList.size()) {
                director = directorList.get(index);
            }

            showList.add(new Opera(title, duration, director));
        }
    }

    ///
    public static void addActorInShow() {
        for (int i = 0; i < actorList.size(); i++) {
            Actor element = actorList.get(i);
            System.out.println("Актер №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < actorList.size(); i++) {
            int index = scanner.nextInt();
            index--;

            if (index >= 0 && index < actorList.size()) {
                Actor actor = actorList.remove(index);
                System.out.println("В какой спектакль вы хотите добавить актера? 1 - Баллет, 2 - Опера, 3 - Шоу");

                int command = scanner.nextInt();
                if (command == 1) {
                    if (!balletList.contains(actor)) {
                        balletList.add(actor);
                    } else {
                        System.out.println("Актёр уже добавлен в балет.");
                    }
                } else if (command == 2) {
                    if (!operaList.contains(actor)) {
                        operaList.add(actor); // ERROR
                    } else {
                        System.out.println("Актёр уже добавлен в оперу.");
                    }
                } else if (command == 3) {
                    if (!showList.contains(actor)) {
                        showList.addFirst(actor);
                    } else {
                        System.out.println("Актёр уже добавлен в шоу.");
                    }
                }

            }
        }
    }

    public static void addBallet() {
        System.out.println("Введите название балета: ");
        String title = scanner.nextLine();
        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.nextLine();

        System.out.println("Выберите доступного хореографа: ");
        for (int i = 0; i < choreographerList.size(); i++) {
            System.out.println("Хореограф №" + (i + 1) + " " + choreographerList.get(i));
        }

        for (int i = 0; i < choreographerList.size(); i++) {
            int index = scanner.nextInt();
            index--;
            if (index >= 0 && index < choreographerList.size()) {
                choreographer = choreographerList.get(index);
            }
        }

        System.out.println("Выберите доступного режиссёра: ");
        for (int i = 0; i < directorList.size(); i++) {
            Director element = directorList.get(i);
            System.out.println("Режиссёр №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < directorList.size(); i++) {
            int index = scanner.nextInt();
            index--;
            if (index >= 0 && index < directorList.size()) {
                director = Theatre.directorList.get(index);
            }
        }

        System.out.println("Выберите автора музыки: ");
        for (int i = 0; i < musicAuthorList.size(); i++) {
            MusicAuthor element = musicAuthorList.get(i);
            System.out.println("Режиссёр №" + (i + 1) + " " + element);
        }

        for (int i = 0; i < musicAuthorList.size(); i++) {

            int index = scanner.nextInt();
            index--;
            if (index >= 0 && index < musicAuthorList.size()) {
                musicAuthor = musicAuthorList.get(index);
            }
        }

        balletList.add(new Ballet(title, duration, librettoText, choreographer, director, musicAuthor));
    }

    public static void switchActor() {
        System.out.println("Выберите в каком спектакле вы хотите сменить актера ?");
        System.out.println("1 - Опера, 2 - Балет, 3 - Шоу.");

        int command = scanner.nextInt();
        if (command == 1) {
            changeActorOpera();
        } else if (command == 2) {
            changeActorBallet();
        } else if (command == 3) {
            changeActorShow();
        }
    }

    // FIXME ДОДЕЛАТЬ
    public static void changeActorOpera() {
        // Актеры ОПЕРЫ
        System.out.println("Выберите актера оперы:");
        for (int i = 0; i < opera.listOfActors.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + opera.listOfActors.get(i));
        }
        // FIXME: Проверить что мы ввели правильного актера
        int currentActorIndex = scanner.nextInt() - 1;

        // Актеры ТЕАТРА
        System.out.println("Выберите актера театра (на которого вы хотите заменить):");
        for (int i = 0; i < actorList.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + actorList.get(i));
        }
        // FIXME: Проверить что мы ввели правильного актера
        int newActorIndex = scanner.nextInt() - 1;
    }

    public static void changeActorBallet() {
        for (int i = 0; i < balletList.size(); i++) {
            Object element = balletList.get(i);
            if (element instanceof Actor) {
                System.out.println("Актер №" + (i + 1) + " " + element);
            }
        }
        System.out.println("Выберите актера которого хотите заменить");
        int currentActorIndex = scanner.nextInt() - 1;

        System.out.println(actorList);

        System.out.println("Выберите актера на которого вы хотите заменить");
        int newActorIndex = scanner.nextInt() - 1;

        if (currentActorIndex >= 0 && currentActorIndex < balletList.size() &&
                newActorIndex >= 0 && newActorIndex < actorList.size()) {
            Actor currentActor = (Actor) balletList.get(currentActorIndex);
            Actor newActor = actorList.get(newActorIndex);
            if (balletList.contains(currentActor)) {
                balletList.set(currentActorIndex, newActor);
            }
        }
    }

    public static void changeActorShow() {
        for (int i = 0; i < showList.size(); i++) {
            Object element = showList.get(i);
            if (element instanceof Actor) {
                System.out.println("Актер №" + (i + 1) + " " + element);
            }
        }
        System.out.println("Выберите актера которого хотите заменить");
        int currentActorIndex = scanner.nextInt() - 1;

        System.out.println(actorList);

        System.out.println("Выберите актера на которого вы хотите заменить");
        int newActorIndex = scanner.nextInt() - 1;

        if (currentActorIndex >= 0 && currentActorIndex < showList.size() &&
                newActorIndex >= 0 && newActorIndex < actorList.size()) {
            Actor currentActor = (Actor) showList.get(currentActorIndex);
            Actor newActor = actorList.get(newActorIndex);
            if (showList.contains(currentActor)) {
                showList.set(currentActorIndex, newActor);
            }
        }
    }
}