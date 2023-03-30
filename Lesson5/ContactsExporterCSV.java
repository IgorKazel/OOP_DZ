import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContactsExporterCSV implements ContactsExporter {
    @Override
    public void exportContacts(List<Contact> contacts, String fileName){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName + ".csv"))) {
            for (Contact contact : contacts) {
                bufferedWriter.write(contact.getFirstName() + "," + contact.getLastName());
                for (int i = 0; i < contact.getPhoneNumber().size(); i++) {
                    bufferedWriter.write("," + contact.getPhoneNumber().get(i));
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
