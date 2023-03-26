import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static int nextId = 1;
    private int id;
    private LocalDateTime addedDateTime;
    private LocalDateTime deadlineDateTime;
    private Priority priority;
    private String authorName;
    private String description;

    public Task(LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        this.id = nextId++;
        this.addedDateTime = addedDateTime;
        this.deadlineDateTime = deadlineDateTime;
        this.priority = priority;
        this.authorName = authorName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getAddedDateTime() {
        return addedDateTime;
    }

    public LocalDateTime getDeadlineDateTime() {
        return deadlineDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDeadlineDateTime(LocalDateTime deadlineDateTime) {
        this.deadlineDateTime = deadlineDateTime;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nЗадача:" +
                "\nid = " + id +
                "\nдата и время добавления = " + addedDateTime.format(DATE_TIME_FORMATTER) +
                "\nдедлайн = " + deadlineDateTime.format(DATE_TIME_FORMATTER) +
                "\nприоритет = " + priority +
                "\nимя автора = " + authorName +
                "\nописание = " + description;
    }
}
