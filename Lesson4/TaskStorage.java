import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public void removeById(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public Task getById(int id) {
        for (Task task: tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getAll() {
        return tasks;
    }
}
