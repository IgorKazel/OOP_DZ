public class View {

    public void Children(Person person, GeoTree tree){
        System.out.println("Дети " + person.getFullName() + ":");
        System.out.println(new Research(tree).spend(person, Relationship.parent));
    }

    public void Parent(Person person, GeoTree tree){
        System.out.println("Родители " + person.getFullName() + ":");
        System.out.println(new Research(tree).spend(person, Relationship.children));
    }

    public void Partner(Person person, GeoTree tree){
        System.out.println("Партнер " + person.getFullName() + ":");
        System.out.println(new Research(tree).spend(person, Relationship.partner));
    }
}
