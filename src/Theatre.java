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

            switch (scanner.nextLine()) {
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
                    System.out.println("Выберите тип постановки: 1 - Балет, 2 - Опера, 3 - Шоу");
                    switch (scanner.nextLine()) {
                        case "1":
                            addBallet();
                            break;
                        case "2":
                            addOpera();
                            break;
                        case "3":
                            addNormalShow();
                            break;
                        default:
                            System.out.println("Извините такой команды не существует");
                    }

                    break;
                case "6":
                    System.out.println("Выберите актера которого хотите добавить в спектакль");
                    addActorInShow();

                    break;
                case "7":
                    System.out.println("Для какого спектакля вы хотите вывести труппу? (1 - Опера,2 - Балет,3 - Шоу");
                    switch (scanner.nextLine()) {
                        case "1":
                            System.out.println(opera);
                            break;
                        case "2":
                            System.out.println(ballet);
                            break;
                        case "3":
                            System.out.println(show);
                            break;
                        default:
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

    public static Choreographer addChoreographerInShow() {
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
                return null;
            }

            // Записываем Choreographer в Оперу
            choreographer = choreographerList.get(index);
        }

        return choreographer;
    }

    public static Director addDirectorInShow() {
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
                return null;
            }

            director = directorList.get(index);
        }

        return director;
    }

    public static MusicAuthor addMusicAuthorInShow() {
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
                return null;
            }

            musicAuthor = musicAuthorList.get(index);
        }

        return musicAuthor;
    }

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
        scanner.nextLine();

        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.nextLine();

        System.out.println("Введите размер хора: ");
        int choirSize = scanner.nextInt();

        Choreographer choreographer = addChoreographerInShow();
        Director director = addDirectorInShow();
        MusicAuthor musicAuthor = addMusicAuthorInShow();

        if (choreographer == null || director == null || musicAuthor == null) {
            return;
        }

        opera = new Opera(title, duration, librettoText, choirSize, choreographer, director, musicAuthor);
    }

    public static void addNormalShow() {
        System.out.println("Введите название шоу: ");
        String title = scanner.nextLine();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();

        Director director = addDirectorInShow();

        if (director == null) {
            return;
        }

        show = new Show(title, duration);
        show.setDirector(director);
    }

    public static void addActorInShow() {
        System.out.println("Актера Театра:");
        for (int i = 0; i < actorList.size(); i++) {
            System.out.println("Актер №" + (i + 1) + " " + actorList.get(i));
        }

        for (int i = 0; i < actorList.size(); i++) {
            int index = scanner.nextInt();
            index--;

            if (index < 0 || index >= actorList.size()) {
                return;
            }

            Actor actor = actorList.get(index);

            System.out.println("В какой спектакль вы хотите добавить актера? 1 - Балет, 2 - Опера, 3 - Шоу");
            switch (scanner.nextLine()) {
                case "1":
                    if (ballet.addActor(actor)) {
                        System.out.println("Актёр уже добавлен в балет.");
                    }

                    break;
                case "2":
                    if (opera.addActor(actor)) {
                        System.out.println("Актёр уже добавлен в оперу.");
                    }

                    break;
                case "3":
                    if (show.addActor(actor)) {
                        System.out.println("Актёр уже добавлен в шоу.");
                    }
                    break;
            }
        }
    }

    public static void addBallet() {
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

        System.out.println("Введите название балета: ");
        String title = scanner.nextLine();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.nextLine();

        Choreographer choreographer = addChoreographerInShow();
        Director director = addDirectorInShow();
        MusicAuthor musicAuthor = addMusicAuthorInShow();

        if (choreographer == null || director == null || musicAuthor == null) {
            return;
        }

        ballet = new Ballet(title, duration, librettoText, choreographer, director, musicAuthor);
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

    public static void changeActorOpera() {
        // Актеры ТЕАТРА
        System.out.println("Выберите актера театра (на которого вы хотите заменить):");
        for (int i = 0; i < actorList.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + actorList.get(i));
        }
        int newActorIndex = scanner.nextInt() - 1;
        if (newActorIndex < 0 || newActorIndex >= actorList.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        // Актеры ОПЕРЫ
        System.out.println("Выберите актера оперы (которого вы хотите заменить):");
        for (int i = 0; i < opera.listOfActors.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + opera.listOfActors.get(i));
        }
        int currentActorIndex = scanner.nextInt() - 1;
        if (currentActorIndex < 0 || currentActorIndex >= opera.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        if (newActorIndex >= opera.listOfActors.size()) {
            System.out.println("Индекса " + newActorIndex + " нет в Опере");
            System.out.println("В Опере есть только эти актеры:");
            for (int i = 0; i < opera.listOfActors.size(); i++) {
                System.out.println("Актера №" + (i + 1) + " " + opera.listOfActors.get(i));
            }

            return;
        }

        opera.changeActor(actorList.get(newActorIndex), currentActorIndex);
    }

    public static void changeActorBallet() {
        // Актеры ТЕАТРА
        System.out.println("Выберите актера театра (на которого вы хотите заменить):");
        for (int i = 0; i < actorList.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + actorList.get(i));
        }
        int newActorIndex = scanner.nextInt() - 1;
        if (newActorIndex < 0 || newActorIndex >= actorList.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        // Актеры балета
        System.out.println("Выберите актера балета (которого вы хотите заменить):");
        for (int i = 0; i < ballet.listOfActors.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + ballet.listOfActors.get(i));
        }
        int currentActorIndex = scanner.nextInt() - 1;
        if (currentActorIndex < 0 || currentActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        if (newActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Индекса " + newActorIndex + " нет в Балете");
            System.out.println("В Балете есть только эти актеры:");
            for (int i = 0; i < ballet.listOfActors.size(); i++) {
                System.out.println("Актера №" + (i + 1) + " " + ballet.listOfActors.get(i));
            }

            return;
        }

        ballet.changeActor(actorList.get(newActorIndex), currentActorIndex);
    }

    public static void changeActorShow() {
        // Актеры ТЕАТРА
        System.out.println("Выберите актера театра (на которого вы хотите заменить):");
        for (int i = 0; i < actorList.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + actorList.get(i));
        }
        int newActorIndex = scanner.nextInt() - 1;
        if (newActorIndex < 0 || newActorIndex >= actorList.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        // Актеры ШОУ
        System.out.println("Выберите актера Шоу (которого вы хотите заменить):");
        for (int i = 0; i < show.listOfActors.size(); i++) {
            System.out.println("Актера №" + (i + 1) + " " + show.listOfActors.get(i));
        }
        int currentActorIndex = scanner.nextInt() - 1;
        if (currentActorIndex < 0 || currentActorIndex >= show.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        if (newActorIndex >= show.listOfActors.size()) {
            System.out.println("Индекса " + newActorIndex + " нет в Шоу");
            System.out.println("В Шоу есть только эти актеры:");
            for (int i = 0; i < show.listOfActors.size(); i++) {
                System.out.println("Актера №" + (i + 1) + " " + show.listOfActors.get(i));
            }

            return;
        }

        show.changeActor(actorList.get(newActorIndex), currentActorIndex);
    }
}
