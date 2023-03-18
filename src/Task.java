import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// основной класс - задача

public class Task implements Comparable<Task> {
    private String subject;
    private String author;
    private final String addTime;
    private final String addDate;
    private int priority;

    private String endOfTask;
    private final int id;
    private static int count;

    static {
        count = 0;
    }

// конструктор задач

    public Task(String subject, String author, int priority, String endOfTask) {
        this.subject = subject;
        this.author = author;
        this.addTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        this.addDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy"));
        this.priority = priority;
        this.endOfTask = endOfTask;
        this.id = ++count;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getAddDate() {
        return addDate;
    }

    public String getEndOfTask() {
        return endOfTask;
    }

    public int getId() {
        return id;
    }

    public String getPriority() { //возвращает приоритет в зависимости от номера
        return switch (priority) {
            case 1 -> "Низкий";
            case 2 -> "Средний";
            case 3 -> "Высокий";
            default -> "Не установлен";
        };
    }

    public int getPriorCode() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    public void setEndOfTask(String endOfTask) {
        this.endOfTask = endOfTask;
    }

    @Override
    public String toString() {
        return "№(ID) " + getId() +
                "  Тема: " + getSubject() +
                ", Автор: " + getAuthor() +
                ", Время создания: " + addTime +
                ", Дата создания: " + addDate +
                ", Дата завершения (deadline): " + endOfTask +
                ", Приоритет: " + getPriority();
    }

    @Override
    public int compareTo(Task o) {
        int compareId
                = o.getId();
        return this.id - compareId;
    }
}