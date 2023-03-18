import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// модуль добавления задачи в список
public class Add {
    private final Scanner scanner;

    public Add(Scanner scanner) {
        this.scanner = scanner;
    }

    public Task makeNewTask() {
        System.out.println("Добавляем новую задачу в <TaskManager>.");
        System.out.println("Введите тему задачи:");
        String subj = scanner.nextLine();
        System.out.println("Введите дату завершения задачи, в формате (дд.мм.гггг):");
        String endOfTask = scanner.nextLine();
        System.out.println("Введите автора задачи:");
        String author = scanner.nextLine();
        System.out.println("Установите приоритет: 1 - низкий, 2 - средний, 3 - высокий:");
        String prior = scanner.nextLine();
        int priority = 0;
        if (prior.equals("1") | prior.equals("2") | prior.equals("3")) {
            priority = Integer.parseInt(prior);
        } else {
            System.out.println("Ошибка ввода, приоритет не установлен, повторите ввод.\n");
        }
        System.out.println("Новая задача добавлена в список.\n");
        return new Task(subj, author, priority, endOfTask);
    }
}