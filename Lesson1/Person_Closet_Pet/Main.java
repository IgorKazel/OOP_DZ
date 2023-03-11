public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", Gender.male, 25);
        Closet closet = new Closet("Шкаф", 5);
        Cat cat = new Cat("Белка", Gender.female, 4);

        person.openCloset(closet);
        step();
        person.addItemInCloset(closet, "Майка");
        step();
        person.addItemInCloset(closet, "Кружка");
        step();
        person.seeInCloset(closet);
        step();
        person.getItemInCloset(closet, "Майка");
        step();
        person.seeInCloset(closet);
        step();
        person.closeCloset(closet);
        step();
        person.callCat(cat);
        step();
        person.kickAwayCat(cat);
        step();
        person.feedCat(cat);
        step();
        person.petCat(cat);
    }

    static void step(){
        System.out.println("----------");
    }
}
