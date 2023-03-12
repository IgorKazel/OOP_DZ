import java.util.ArrayList;

public interface Research {
    ArrayList<String> getParent(Person person);
    ArrayList<String> getChildren(Person person);
    ArrayList<String> getPartner(Person person);
    ArrayList<String> spend(Person person, Relationship re);
}
