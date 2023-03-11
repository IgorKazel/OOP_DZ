public class Main {
    public static void main(String[] args) {
        Person yura = new Person("Юра", Gender.male, 62);
        Person irina = new Person("Ирина", Gender.female, 60);
        Person petya = new Person("Петя", Gender.male, 64);
        Person katya = new Person("Катя", Gender.female, 63);
        Person vasya = new Person("Вася", Gender.male, 41);
        Person masha = new Person("Маша", Gender.female, 40);
        Person jane = new Person("Женя", Gender.female, 19);
        Person ivan = new Person("Ваня", Gender.male, 15);

        GeoTree gt = new GeoTree();
        gt.addChildren(yura, vasya);
        gt.addChildren(irina, vasya);
        gt.addChildren(petya, masha);
        gt.addChildren(katya, masha);
        gt.addChildren(vasya, jane);
        gt.addChildren(masha, jane);
        gt.addChildren(vasya, ivan);
        gt.addChildren(masha, ivan);
        gt.addPartner(yura, irina);
        gt.addPartner(petya, katya);
        gt.addPartner(vasya, masha);

        new View().Children(vasya, gt);
        new View().Parent(vasya, gt);
        new View().Partner(vasya, gt);
    }
}
