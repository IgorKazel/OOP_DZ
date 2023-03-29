import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Scanner scanner) {
        System.out.println("Введите имя:");
        String firstName = scanner.next();
        System.out.println("Введите фамилию:");
        String lastName = scanner.next();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.next();
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        if (!contacts.contains(contact)){
            contacts.add(contact);
            Collections.sort(contacts);
            System.out.println("Контакт добавлен");
        } else {
            System.out.println("Контакт уже существует");
        }
    }

    public void removeContact(Scanner scanner) {
        System.out.print("Введите имя, фамилию или номер телефона контакта (или часть): ");
        String contactPart = scanner.next();
        int index = 0;
        List<Contact> contactsToRemove = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.toString().contains(contactPart)) {
                contactsToRemove.add(contact);
                index++;
                System.out.println(index + ". " + contact);
            }
        }
        if (index != 0) {
            System.out.println("Введите номер контакта для удаления (0 - отмена)");
            index = scanner.nextInt();
            if (index > 0 && index <= contactsToRemove.size()){
                Contact contactToRemove = contactsToRemove.get(index - 1);
                contacts.remove(contactToRemove);
                System.out.println("Контакт удален");
            } else if (index == 0) {
                System.out.println("Удаление отменено");
            } else {
                System.out.println("Неверный номер");
            }
        } else {
            System.out.println("Контакты не найдены");
        }
    }

    public void searchContact(Scanner scanner) {
        System.out.print("Введите имя, фамилию или номер телефона контакта (или часть): ");
        String contactPart = scanner.next();
        boolean isFound = false;
        for (Contact contact : contacts) {
            if (contact.toString().contains(contactPart)) {
                System.out.println(contact);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Контакты не найдены");
        }
    }

    public void printAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void importContactsFromCSV(Scanner scanner) {
        ContactsImporterCSV ConImCSV = new ContactsImporterCSV();
        System.out.print("Введите имя файла (без .csv): ");
        String fileName = scanner.next();
        contacts = ConImCSV.importContacts(fileName);
    }

    public void importContactsFromXML(Scanner scanner) throws XMLStreamException, FileNotFoundException {
        ContactsImporterXML ConImXML = new ContactsImporterXML();
        System.out.print("Введите имя файла (без .xml): ");
        String fileName = scanner.next();
        contacts = ConImXML.importContacts(fileName);
    }

    public void exportContactsToCSV(Scanner scanner){
        ContactsExporterCSV ConExCSV = new ContactsExporterCSV();
        System.out.print("Введите имя файла (без .csv): ");
        String fileName = scanner.next();
        ConExCSV.exportContacts(contacts, fileName);
    }

    public void exportContactsToXML(Scanner scanner) throws XMLStreamException, FileNotFoundException {
        ContactsExporterXML ConExXML = new ContactsExporterXML();
        System.out.print("Введите имя файла (без .xml): ");
        String fileName = scanner.next();
        ConExXML.exportContacts(contacts, fileName);
    }
}
