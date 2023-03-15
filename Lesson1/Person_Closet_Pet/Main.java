import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", Gender.male, 25);
        Closet closet = new Closet("Шкаф", 5);
        Cat cat = new Cat("Белка", Gender.female, 4);
        Item tshirt = new Item("Майка");
        Item cap = new Item("Кружка");

        person.openCloset(closet);
        step();
        person.addItemInCloset(closet, tshirt);
        step();
        person.addItemInCloset(closet, cap);
        step();
        person.seeInCloset(closet);
        step();
        person.getItemInCloset(closet, tshirt);
        step();
        person.seeInCloset(closet);
        step();
        person.closeCloset(closet);
        step();
        person.callCat(cat);
        step();
        person.kickAwayCat(cat);
        step();
        cat.askEat(person);
        step();
        person.petCat(cat);
    }

    static void step(){
        System.out.println("----------");
    }
}
