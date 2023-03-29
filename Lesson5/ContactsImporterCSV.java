import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsImporterCSV implements ContactsImporter {
    @Override
    public List<Contact> importContacts(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                Contact contact = new Contact(parts[0], parts[1], parts[2]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
