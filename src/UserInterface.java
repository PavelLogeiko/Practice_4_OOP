import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final Menu menu;
    private final Planner planner;
    private final Add add;
    protected static String csvPath = "/Users/logeyko/IdeaProjects/Practice_4_OOP/src/Planner.csv";

// путь где расположены файлы, в которые выполняется запись /Users/logeyko/IdeaProjects/Practice_4_OOP/src

    public UserInterface(Scanner scanner, Menu menu, Planner planner, Add add) {
        this.scanner = scanner;
        this.menu = menu;
        this.planner = planner;
        this.add = add;
    }

    public void start() {

        while (true) {
            switch (menu.selectFunction()) {
                case "1": // показать все задачи
                    System.out.println("\nСписок всех задач:");
                    planner.sort();
                    planner.showAll();
                    System.out.println("");
                    break;
                case "2": // найти задачу по теме
                    System.out.print("Введите тему задачи: ");
                    System.out.println(planner.getBySub(scanner.nextLine()));
                    System.out.println("");
                    break;
                case "3": // найти задачу по ключевому слову (например по автору)
                    System.out.print("\nВведите ключевое слово для поиска в задаче (например, имя автора): ");
                    planner.totalSearch(scanner.nextLine());
                    System.out.println("");
                    break;
                case "4": // отсортировать задачи по приоритету
                    System.out.println("\nОтсортированный список задач по приоритетам, от высокого к низкому:");
                    planner.sortByPrior();
                    planner.showAll();
                    System.out.println("");
                    break;
                case "5": // выполнить запись задач в файл
                    saveFile();
                    break;
                case "6": // добавить новую задачу в список
                    planner.add(add.makeNewTask());
                    break;
                case "7": // изменить существующую задачу
                    System.out.println("Введите номер (ID) задачи, которую необходимо изменить: ");
                    changeTask(planner.getById(scanner.nextInt()));

                case "0": // выход
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
            }
        }
    }

    public void saveFile() {
        PlannerIterator plannerIterator = new PlannerIterator(planner);
        while (true) {
            switch (menu.selectSaveType()) {
                case "1" -> // запись задач в файл формата CSV
                {
                    while (plannerIterator.hasNext()) {
                        SaveModel<Task> saved = new SaveModel<>(plannerIterator.next());
                        saved.setFormat(new CsvWriter());
                        saved.setPath(csvPath);
                        saved.save();
                    }
                    System.out.println("\nЗадачи сохранены в файл формата <CSV>.\n");
                }

                case "2" -> //меню
                        start();
                case "0" -> // выход
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }

    public void changeTask(Task changing) {
        while (true) {
            switch (menu.selectTaskMeth()) {
                case "1" -> { // изменяем тему
                    System.out.println("Введите новую тему: ");
                    changing.setSubject(scanner.nextLine());
                }
                case "2" -> { // изменяем автора
                    System.out.print("Введите нового автора (Имя): ");
                    changing.setAuthor(scanner.nextLine());
                }
                case "3" -> { // изменяем приоритет
                    System.out.print("Введите новый приоритет: 1 - низкий, 2 - средний, 3 - высокий: ");
                    changing.setPriority(scanner.nextInt());
                }
                case "4" -> { //дата завершения (deadline)
                    System.out.print("Введите новый срок завершения (deadline), в формате дд.мм.гггг: ");
                    changing.setEndOfTask(scanner.nextLine());
                }
                case "5" -> // возврат в основное меню
                        start();
                case "0" -> // выход (завершение программы)
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }
}
