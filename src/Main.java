import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static CalendarService calendar = new CalendarService();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();

                System.out.print("Выберите пункт меню: ");

                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            getTacksForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название задачи: ");
        String title = scanner.next();
        System.out.print("Введите описание задачи: ");
        String discription = scanner.next();
        boolean isWork;
        System.out.println("Это рабочая задача?");

        switch (scanner.nextLine()) {

            case "1":
            case "да":
            case "д":
            case "y":
            case "yes":
            case "Y":
            case "YES":

                isWork = true;
                break;
            default:
                isWork = false;
        }

        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи  ");
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;

            } catch (DateTimeParseException e) {
                System.out.println("Wrong");
            }
        }
        Task task;
        System.out.println("Повторяемость задания:");
        System.out.println("\t  0 – не повторяется");
        System.out.println("\t  1 – ежедневно");
        System.out.println("\t  2 – еженедельно");
        System.out.println("\t  3 – ежемесячно");
        System.out.println("\t  4 – ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, discription, date, isWork);
                break;
            case "2":
                task = new WeeklyTask(title, discription, date, isWork);
                break;
            case "3":
                task = new MonthlyTask(title, discription, date, isWork);
                break;
            case "4":
                task = new YearlyTask(title, discription, date, isWork);
                break;
            default:
                task = new OneTimeTask(title, discription, date, isWork);
        }
        if (calendar.addTask(task)) {
            System.out.println("Задача успешно добавлена!");

        }
        throw new RuntimeException("Произошла непредвиденная ошибка. Программа завершается.");
    }

    public static void getTacksForDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите дату");
        LocalDate date = null;
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
                shouldEnterAgain = false;

            } catch (DateTimeParseException e) {
                System.out.println("Wrong");
            }
        }
        System.out.println(calendar.getTaskDay(date));
    }

    private static void removeTask(Scanner id) {
        id.nextLine();
        System.out.println("Введите ID для удаления");
        removeTask(id);
    }

    private static void printMenu() {
        System.out.println(

                " 1. Добавить задачу \n" +
                        " 2. Удалить задачу \n" +
                        " 3. Получить задачу на указанный день\n" +
                        " 0. Выход"
        );
    }
}