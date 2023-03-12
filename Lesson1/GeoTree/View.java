public class View {

    public void Children(Person person, GeoTree tree){
        System.out.println("Дети " + person.getFullName() + ":");
        System.out.println(tree.getChildren(person));
    }

    public void Parent(Person person, GeoTree tree){
        System.out.println("Родители " + person.getFullName() + ":");
        System.out.println(tree.getParent(person));
    }

    public void Partner(Person person, GeoTree tree){
        System.out.println("Партнер " + person.getFullName() + ":");
        System.out.println(tree.getPartner(person));
    }
}
