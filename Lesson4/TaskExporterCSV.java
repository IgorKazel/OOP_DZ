import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskExporterCSV implements TasksExporter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Override
    public void exportTasks(List<Task> tasks, String fileName){
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.printf("%d,%s,%s,%s,%s,%s%n", task.getId(), task.getAddedDateTime().format(DATE_TIME_FORMATTER),
                        task.getDeadlineDateTime().format(DATE_TIME_FORMATTER), task.getPriority(), task.getAuthorName(),
                        task.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
