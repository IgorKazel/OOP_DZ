import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskImporterCSV implements TasksImporter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Override
    public TaskManager importTasks(String fileName){
        TaskStorage taskStorage = new TaskStorage();
        TasksExporter taskExporter = new TaskExporterCSV();
        TasksImporter taskImporter = new TaskImporterCSV();
        TaskManager taskManager = new TaskManager(taskStorage, taskExporter, taskImporter);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDateTime addedDateTime = LocalDateTime.parse(parts[1], DATE_TIME_FORMATTER);
                LocalDateTime deadlineDateTime = LocalDateTime.parse(parts[2], DATE_TIME_FORMATTER);
                Priority priority = Priority.valueOf(parts[3]);
                String authorName = parts[4];
                String description = parts[5];
                taskManager.addTask(addedDateTime, deadlineDateTime, priority, authorName, description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskManager;
    }
}
