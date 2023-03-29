import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhonebookMenu {
    public static void menu() throws XMLStreamException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        while (true) {
            System.out.println("\nВведите номер действия:\n" +
                    "1. Добавить контакт\n" +
                    "2. Удалить контакт\n" +
                    "3. Поиск контакта\n" +
                    "4. Вывести все контакты\n" +
                    "5. Импортировать контакты из файла\n" +
                    "6. Экспортировать контакты в файл\n" +
                    "0. Выход\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> phonebook.addContact(scanner);
                case 2 -> phonebook.removeContact(scanner);
                case 3 -> phonebook.searchContact(scanner);
                case 4 -> phonebook.printAllContacts();
                case 5 -> importContacts(scanner, phonebook);
                case 6 -> exportContacts(scanner, phonebook);
                case 0 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Неверный номер");
            }
        }
    }

    private static void importContacts(Scanner scanner, Phonebook phonebook) throws XMLStreamException, FileNotFoundException {
        System.out.println("\nВведите номер действия:\n" +
                "1. Импорт из csv\n" +
                "2. Импорт из xml\n" +
                "0. Выход в главное меню\n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> phonebook.importContactsFromCSV(scanner);
            case 2 -> phonebook.importContactsFromXML(scanner);
            case 0 -> System.out.println("Отмена импорта");
            default -> System.out.println("Неверный номер");
        }
    }

    private static void exportContacts(Scanner scanner, Phonebook phonebook) throws XMLStreamException, FileNotFoundException {
        System.out.println("\nВведите номер действия:\n" +
                "1. Экспорт в csv\n" +
                "2. Экспрот в xml\n" +
                "0. Выход в главное меню\n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> phonebook.exportContactsToCSV(scanner);
            case 2 -> phonebook.exportContactsToXML(scanner);
            case 0 -> System.out.println("Отмена экспорта");
            default -> System.out.println("Неверный номер");
        }
    }
}
