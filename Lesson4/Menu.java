import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(new TaskStorage(), new TaskExporterCSV(), new TaskImporterCSV());

        boolean quit = false;

        while (!quit) {
            System.out.println("\n1. Добавить задачу\n" +
                    "2. Изменить задачу\n" +
                    "3. Посмотреть задачу\n" +
                    "4. Удалить задачу\n" +
                    "5. Просмотреть все задачи\n" +
                    "6. Экспортировать задачи в файл\n" +
                    "7. Импортировать задачи из файла\n" +
                    "0. Выйти из приложения\n");

            int choice = scanner.nextInt();
            scanner.nextLine();
            int taskId;


            switch (choice) {
                case 1:
                    try {
                        LocalDateTime addedDateTime = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
                        System.out.print("Введите дату и время дедлайна задачи в формате \"dd.MM.yyyy HH:mm\" : ");
                        LocalDateTime deadlineDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_TIME_FORMATTER);
                        System.out.print("Введите приоритет задачи (low, medium, high): ");
                        Priority priority = Priority.valueOf(scanner.nextLine().toLowerCase());
                        System.out.print("Введите имя автора задачи: ");
                        String authorName = scanner.nextLine();
                        System.out.print("Введите описание задачи: ");
                        String description = scanner.nextLine();
                        taskManager.addTask(addedDateTime, deadlineDateTime, priority, authorName, description);
                    } catch (DateTimeParseException e) {
                        System.out.println("Некорректный формат даты и/или времени. Попробуйте еще раз.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Некорректный приоритет задачи. Попробуйте еще раз.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Введите ID задачи, которую нужно изменить: ");
                        taskId = scanner.nextInt();
                        scanner.nextLine();
                        Task taskToEdit = taskManager.getTaskById(taskId);
                        if (taskToEdit == null) {
                            System.out.println("Задача с таким ID не найдена.");
                        } else {
                            System.out.print("Введите новое описание задачи: ");
                            String newDescription = scanner.nextLine();
                            taskToEdit.setDescription(newDescription);
                            System.out.println("Задача успешно изменена.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                        scanner.next();
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Введите ID задачи: ");
                        taskId = scanner.nextInt();
                        scanner.nextLine();
                        Task taskById = taskManager.getTaskById(taskId);
                        if (taskById == null) {
                            System.out.println("Задача с таким ID не найдена.");
                        } else {
                            System.out.println(taskById);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                        scanner.next();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Введите id задачи, которую нужно удалить");
                        taskId = scanner.nextInt();
                        scanner.nextLine();
                        if (taskManager.getTaskById(taskId) == null) {
                            System.out.println("Такой задачи нету");
                        } else {
                            System.out.println("Нажмите 1 для удаления :" + taskManager.getTaskById(taskId));
                            if (scanner.nextInt() == 1) {
                                taskManager.removeTask(taskId);
                                System.out.println("Задача удалена.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                        scanner.next();
                    }
                    break;
                case 5:
                    try {
                        List<Task> tasks = taskManager.getAllTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("Задачи не найдены.");
                        } else {
                            for (Task task : tasks) {
                                System.out.println(task);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении списка задач: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Введите путь и файл для экспорта");
                        String file = scanner.next();
                        taskManager.exportTasks(file);
                        System.out.println("Задачи успешно экспортированы.");
                    } catch (Exception e) {
                        System.out.println("Ошибка при экспорте задач: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Введите путь и файл для импорта");
                        String file = scanner.next();
                        taskManager = taskManager.importTasks(file);
                        System.out.println("Задачи успешно импортированы.");

                    } catch (Exception e) {
                        System.out.println("Ошибка при импорте задач: " + e.getMessage());
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте еще раз.");
                    break;
            }
        }
        scanner.close();
    }
}
