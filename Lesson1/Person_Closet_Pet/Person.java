public class Person extends BaseLive {

    public Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void openCloset(Closet name){
        if (name.getIsOpen()) {
            System.out.println("Двери " + name + " и так окрыты");
        } else {
            name.openDoor();
            System.out.println("Двери " + name + " окрыты");
        }
    }

    public void closeCloset(Closet name){
        if (name.getIsOpen()) {
            name.closeDoor();
            System.out.println("Двери " + name + " закрыты");
        } else {
            System.out.println("Двери " + name + " и так закрыты");
        }
    }

    public void addItemInCloset(Closet name, Item item) {
        if (name.getIsOpen()) {
            name.addItem(item);
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }

    public void getItemInCloset(Closet name, Item item){
        if (name.getIsOpen()) {
            name.getItem(item);
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }

    public void seeInCloset(Closet name){
        if (name.getIsOpen()) {
            name.printAllItem();
        } else {
            System.out.println("Сначала нужно открыть двери " + name);
        }
    }

    public void callCat(Cat name){
        if (name.getIsNear()) {
            System.out.println(name + " и так рядом");
        } else {
            System.out.println(this.name + " зовет " + name);
        }
        name.comePerson();
    }

    public void kickAwayCat(Cat name){
        if (name.getIsNear()) {;
            System.out.println(this.name + " прогоняет " + name);
        } else {
            System.out.println(name + " не рядом");
        }
        name.leavePerson();
    }

    public void petCat(Cat name){
        if (name.getIsNear()) {
            System.out.println(this.name + " гладит кошку");
            name.joy();
        } else {
            System.out.println(name + " не рядом");
        }
    }

    public void feedCat(Cat name){
        System.out.println(this.name + " кормит кошку");
        name.eat();
    }
}