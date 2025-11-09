import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

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

        actorList.add(new Actor("Актер 0", "фам 0", Gender.MALE, 180));
        actorList.add(new Actor("Актер 1", "фам 11", Gender.FEMALE, 150));
        actorList.add(new Actor("Актер 2", "фам 012", Gender.MALE, 180));
        actorList.add(new Actor("Актер 3", "фам 1 3", Gender.FEMALE, 150));
        actorList.add(new Actor("Актер 5", "фам 1123213", Gender.FEMALE, 150));

        directorList.add(new Director("Director 0", "фам 0", Gender.MALE, 15));
        directorList.add(new Director("Director 1", "фам 13", Gender.FEMALE, 15));

        choreographerList.add(new Choreographer("Director 1", "фам 13", Gender.FEMALE));
        choreographerList.add(new Choreographer("Director 1", "фам 13", Gender.FEMALE));

        musicAuthorList.add(new MusicAuthor("Director 1", "фам 13", Gender.FEMALE));

        ballet = new Ballet(
                "Ballet",
                160,
                "librettoText librettoText librettoText librettoText",
                choreographerList.getFirst(),
                directorList.getFirst(),
                musicAuthorList.getFirst()
        );

        show = new Show(
                "Show",
                160
        );
        show.setDirector(directorList.getLast());

        opera = new Opera(
                "Opera",
                160,
                "librettoText librettoText librettoText librettoText",
                123213,
                choreographerList.getFirst(),
                directorList.getFirst(),
                musicAuthorList.getFirst()
        );

        while (true) {
            printMenu();

            switch (scanner.next()) {
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
                    switch (scanner.next()) {
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
                    switch (scanner.next()) {
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

        for (int i = 0; i < count; i++) {
            System.out.println("Актёр №" + (i + 1));
            addNewActor();
        }
    }
    
    public static void addNewActor() {
        System.out.print("Введите Имя: ");
        String name = scanner.next();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.next();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.next());

        System.out.print("Введите рост: ");
        int height = scanner.nextInt();

        actorList.add(new Actor(name, surname, gender, height));
    }

    public static void addMultipleDirectors() {
        System.out.print("Сколько Режиссеров вы хотите добавить?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Режиссер №" + (i + 1));
            addNewDirector();
        }
    }
    
    public static void addNewDirector() {
        System.out.print("Введите Имя: ");
        String name = scanner.next();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.next();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.next());

        System.out.println("Введите количество поставленных спектаклей");
        int numberOfShows = scanner.nextInt();

        directorList.add(new Director(name, surname, gender, numberOfShows));
    }
    
    public static void addNewMusicAuthor() {
        System.out.print("Введите Имя: ");
        String name = scanner.next();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.next();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.next());

        musicAuthorList.add(new MusicAuthor(name, surname, gender));
    }
    
    public static void addNewChoreographer() {
        System.out.print("Введите Имя: ");
        String name = scanner.next();

        System.out.print("Введите Фамилию: ");
        String surname = scanner.next();

        System.out.print("Введите пол (MALE, FEMALE): ");
        Gender gender = Gender.valueOf(scanner.next());

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
        if (choreographerList.isEmpty()) {
            System.out.println("Добавь хотя бы одного Choreographer");
            return;
        }

        if (directorList.isEmpty()) {
            System.out.println("Добавь хотя бы одного Director");
            return;
        }

        if (musicAuthorList.isEmpty()) {
            System.out.println("Добавь хотя бы одного MusicAuthor");
            return;
        }


        System.out.println("Введите название оперы: ");
        String title = scanner.next();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();

        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.next();

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
        if (directorList.isEmpty()) {
            System.out.println("Добавь хотя бы одного Director");
            return;
        }

        System.out.println("Введите название шоу: ");
        String title = scanner.next();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();

        Director director = addDirectorInShow();

        if (director == null) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        show = new Show(title, duration);
        show.setDirector(director);
    }

    public static void addActorInShow() {
        System.out.println("Актеры Театра:");
        System.out.println();
        for (int y = 0; y < actorList.size(); y++) {
            System.out.println("Актер №" + (y + 1) + " " + actorList.get(y));
        }
        System.out.println();

        int index = scanner.nextInt();
        index--;

        if (index < 0 || index >= actorList.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }

        Actor actor = actorList.get(index);

        System.out.println("В какой спектакль вы хотите добавить актера? 1 - Балет, 2 - Опера, 3 - Шоу");
        System.out.println();

        switch (scanner.next()) {
            case "1":
                System.out.println();

                if (ballet.addActor(actor)) {
                    System.out.println("Актёр успешно добавлен в Балет.");
                } else {
                    System.out.println("Актёр уже добавлен в балет.");
                }

                break;
            case "2":
                System.out.println();

                if (opera.addActor(actor)) {
                    System.out.println("Актёр успешно добавлен в Опера.");
                } else {
                    System.out.println("Актёр уже добавлен в Опера.");
                }

                break;
            case "3":
                System.out.println();

                if (show.addActor(actor)) {
                    System.out.println("Актёр успешно добавлен в шоу.");
                } else {
                    System.out.println("Актёр уже добавлен в балет.");
                }
                break;
        }

        System.out.println();
        System.out.println();
    }

    public static void addBallet() {
        if (choreographerList.isEmpty()) {
            System.out.println("Добавь хотя бы одного Choreographer");
            return;
        }

        if (directorList.isEmpty()) {
            System.out.println("Добавь хотя бы одного Director");
            return;
        }

        if (musicAuthorList.isEmpty()) {
            System.out.println("Добавь хотя бы одного MusicAuthor");
            return;
        }

        System.out.println("Введите название балета: ");
        String title = scanner.next();

        System.out.println("Введите длительность: ");
        int duration = scanner.nextInt();

        System.out.println("Введите текст либретто: ");
        String librettoText = scanner.next();

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

        switch (scanner.next()) {
            case "1":
                System.out.println("Выберите из какого спектакля вы хотите взять актера?");
                System.out.println("1 - Балет, 2 - Шоу.");
                switch (scanner.next()) {
                    case "1":
                        switchActorOperaToActorBallet();
                        break;
                    case "2":
                        switchActorOperaToActorShow();
                        break;
                }
                break;
            case "2":
                System.out.println("Выберите в каком спектакле вы хотите сменить актера?");
                System.out.println("1 - Опера, 2 - Шоу.");
                switch (scanner.next()) {
                    case "1":
                        switchActorBalletToActorOpera();
                        break;
                    case "2":
                        switchActorBalletToActorShow();
                        break;
                }
                break;
            case "3":
                System.out.println("Выберите в каком спектакле вы хотите сменить актера?");
                System.out.println("1 - Опера, 2 - Балет.");
                switch (scanner.next()) {
                    case "1":
                        switchActorShowToActorOpera();
                        break;
                    case "2":
                        switchActorShowToActorBallet();
                        break;
                }
                break;
        }
    }

    public static void switchActorOperaToActorBallet() {
        // Актеры ОПЕРЫ
        System.out.println("Выберите актера ОПЕРЫ:");
        opera.printActorList();

        int operaActorIndex = scanner.nextInt() - 1;
        if (operaActorIndex < 0 || operaActorIndex >= opera.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor operaActor = opera.listOfActors.get(operaActorIndex);

        // Актеры Балета
        System.out.println("Выберите актера Балета:");
        ballet.printActorList();

        int balletActorIndex = scanner.nextInt() - 1;
        if (balletActorIndex < 0 || balletActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor balletActor = ballet.listOfActors.get(balletActorIndex);


        System.out.println("Процесс замены актеров..:");
        System.out.println();

        System.out.println("БЫЛО:");
        System.out.println("Список Актеров ОПЕРЫ:");
        opera.printActorList();

        System.out.println("Список Актеров Балета:");
        ballet.printActorList();

        opera.changeActor(operaActor, balletActor);
        ballet.changeActor(balletActor, operaActor);

        System.out.println("СТАЛО:");
        System.out.println("Список Актеров ОПЕРЫ:");
        opera.printActorList();

        System.out.println("Список Актеров Балета:");
        ballet.printActorList();

        System.out.println();
        System.out.println("Смена произошла успешно!");
    }

    public static void switchActorOperaToActorShow() {
        // Актеры ОПЕРЫ
        System.out.println("Выберите актера ОПЕРЫ:");
        opera.printActorList();

        int operaActorIndex = scanner.nextInt() - 1;
        if (operaActorIndex < 0 || operaActorIndex >= opera.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor operaActor = opera.listOfActors.get(operaActorIndex);

        // Актеры Шоу
        System.out.println("Выберите актера Шоу:");
        show.printActorList();

        int showActorIndex = scanner.nextInt() - 1;
        if (showActorIndex < 0 || showActorIndex >= show.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor showActor = show.listOfActors.get(showActorIndex);

        System.out.println("Процесс замены актеров..:");
        System.out.println("БЫЛО:");
        opera.printActorList();
        show.printActorList();

        opera.changeActor(operaActor, showActor);
        show.changeActor(showActor, operaActor);

        System.out.println("СТАЛО:");
        opera.printActorList();
        show.printActorList();
        System.out.println("Смена произошла успешно!");
    }

    public static void switchActorBalletToActorOpera() {
        // Актеры Балета
        System.out.println("Выберите актера Балета:");
        ballet.printActorList();

        int balletActorIndex = scanner.nextInt() - 1;
        if (balletActorIndex < 0 || balletActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor balletActor = ballet.listOfActors.get(balletActorIndex);

        // Актеры ОПЕРЫ
        System.out.println("Выберите актера ОПЕРЫ:");
        opera.printActorList();

        int operaActorIndex = scanner.nextInt() - 1;
        if (operaActorIndex < 0 || operaActorIndex >= opera.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor operaActor = opera.listOfActors.get(operaActorIndex);

        System.out.println("Процесс замены актеров..:");
        System.out.println("БЫЛО:");
        ballet.printActorList();
        opera.printActorList();

        ballet.changeActor(balletActor, operaActor);
        opera.changeActor(operaActor, balletActor);

        System.out.println("СТАЛО:");
        ballet.printActorList();
        opera.printActorList();
        System.out.println("Смена произошла успешно!");
    }

    public static void switchActorBalletToActorShow() {
        // Актеры Балета
        System.out.println("Выберите актера Балета:");
        ballet.printActorList();

        int balletActorIndex = scanner.nextInt() - 1;
        if (balletActorIndex < 0 || balletActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor balletActor = ballet.listOfActors.get(balletActorIndex);

        // Актеры Шоу
        System.out.println("Выберите актера Шоу:");
        show.printActorList();

        int showActorIndex = scanner.nextInt() - 1;
        if (showActorIndex < 0 || showActorIndex >= show.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor showActor = show.listOfActors.get(showActorIndex);

        System.out.println("Процесс замены актеров..:");
        System.out.println("БЫЛО:");
        ballet.printActorList();
        show.printActorList();

        ballet.changeActor(balletActor, showActor);
        show.changeActor(showActor, balletActor);

        System.out.println("СТАЛО:");
        ballet.printActorList();
        show.printActorList();
        System.out.println("Смена произошла успешно!");
    }

    public static void switchActorShowToActorOpera() {
        // Актеры Шоу
        System.out.println("Выберите актера Шоу:");
        show.printActorList();

        int showActorIndex = scanner.nextInt() - 1;
        if (showActorIndex < 0 || showActorIndex >= show.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor showActor = show.listOfActors.get(showActorIndex);

        // Актеры ОПЕРЫ
        System.out.println("Выберите актера ОПЕРЫ:");
        opera.printActorList();

        int operaActorIndex = scanner.nextInt() - 1;
        if (operaActorIndex < 0 || operaActorIndex >= opera.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor operaActor = opera.listOfActors.get(operaActorIndex);

        System.out.println("Процесс замены актеров..:");
        System.out.println("БЫЛО:");
        show.printActorList();
        opera.printActorList();

        show.changeActor(showActor, operaActor);
        opera.changeActor(operaActor, showActor);

        System.out.println("СТАЛО:");
        show.printActorList();
        opera.printActorList();
        System.out.println("Смена произошла успешно!");
    }

    public static void switchActorShowToActorBallet() {
        // Актеры Шоу
        System.out.println("Выберите актера Шоу:");
        show.printActorList();

        int showActorIndex = scanner.nextInt() - 1;
        if (showActorIndex < 0 || showActorIndex >= show.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor showActor = show.listOfActors.get(showActorIndex);

        // Актеры Балета
        System.out.println("Выберите актера Балета:");
        ballet.printActorList();

        int balletActorIndex = scanner.nextInt() - 1;
        if (balletActorIndex < 0 || balletActorIndex >= ballet.listOfActors.size()) {
            System.out.println("Вы ввели неправильный индекс актера!");
            return;
        }
        Actor balletActor = ballet.listOfActors.get(balletActorIndex);

        System.out.println("Процесс замены актеров..:");
        System.out.println("БЫЛО:");
        show.printActorList();
        ballet.printActorList();

        show.changeActor(showActor, balletActor);
        ballet.changeActor(balletActor, showActor);

        System.out.println("СТАЛО:");
        show.printActorList();
        ballet.printActorList();
        System.out.println("Смена произошла успешно!");
    }
}
