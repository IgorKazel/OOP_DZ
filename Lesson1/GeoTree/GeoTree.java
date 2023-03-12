import java.util.ArrayList;

public class GeoTree implements Research {
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

    @Override
    public ArrayList<String> getChildren(Person person) {
        return spend(person, Relationship.parent);
    }

    @Override
    public ArrayList<String> getParent(Person person) {
        return spend(person, Relationship.children);
    }

    @Override
    public ArrayList<String> getPartner(Person person) {
        return spend(person, Relationship.partner);
    }

    @Override
    public ArrayList<String> spend(Person p, Relationship re) {
        ArrayList<String> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.p1.getFullName() == p.getFullName() && t.re == re) {
                result.add(t.p2.getFullName());
            }
        }
        return result;
    }
}
