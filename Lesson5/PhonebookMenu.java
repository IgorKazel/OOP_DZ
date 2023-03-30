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
                    "2. Добавить контакту номер телефона\n" +
                    "3. Удалить контакту номер телефона\n" +
                    "4. Удалить контакт\n" +
                    "5. Поиск контакта\n" +
                    "6. Вывести все контакты\n" +
                    "7. Импортировать контакты из файла\n" +
                    "8. Экспортировать контакты в файл\n" +
                    "0. Выход\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> phonebook.addContact(scanner);
                case 2 -> phonebook.addContactPhone(scanner);
                case 3 -> phonebook.removeContactPhone(scanner);
                case 4 -> phonebook.removeContact(scanner);
                case 5 -> phonebook.searchContact(scanner);
                case 6 -> phonebook.printAllContacts();
                case 7 -> importContacts(scanner, phonebook);
                case 8 -> exportContacts(scanner, phonebook);
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
