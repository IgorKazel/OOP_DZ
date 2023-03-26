import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private TaskStorage taskStorage;
    private TasksExporter tasksExporter;
    private TasksImporter tasksImporter;

    public TaskManager(TaskStorage taskStorage, TasksExporter tasksExporter, TasksImporter tasksImporter) {
        this.taskStorage = taskStorage;
        this.tasksExporter = tasksExporter;
        this.tasksImporter = tasksImporter;
    }

    public void addTask(LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        Task task = new Task(addedDateTime, deadlineDateTime, priority, authorName, description);
        taskStorage.add(task);
    }

    public void removeTask(int id) {
        taskStorage.removeById(id);
    }

    public Task getTaskById(int id) {
        return taskStorage.getById(id);
    }

    public List<Task> getAllTasks() {
        return taskStorage.getAll();
    }

    public void exportTasks(String filePath) {
        List<Task> tasks = taskStorage.getAll();
        tasksExporter.exportTasks(tasks, filePath);
    }

    public TaskManager importTasks(String filePath) {
        return tasksImporter.importTasks(filePath);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        return taskStorage.getAll().stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }
}
