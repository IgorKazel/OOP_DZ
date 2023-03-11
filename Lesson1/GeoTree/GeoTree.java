import java.util.ArrayList;

public class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void addChildren(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }

    public void addPartner(Person partner1, Person partner2) {
        tree.add(new Node(partner1, Relationship.partner, partner2));
        tree.add(new Node(partner2, Relationship.partner, partner1));
    }
}
