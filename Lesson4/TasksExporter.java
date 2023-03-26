import java.util.List;

public interface TasksExporter {
    void exportTasks(List<Task> tasks, String fileName);
}
