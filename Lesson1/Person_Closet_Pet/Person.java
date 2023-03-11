public class Person {
    private String fullName;
    private int age;
    private Gender gender;

    public Person(String fullName, Gender gender, int age) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
    }

    public void openCloset(Closet name){
        name.openDoor();
    }

    public void closeCloset(Closet name){
        name.closeDoor();
    }

    public void addItemInCloset(Closet name, String item){
        name.addItem(item);
    }

    public void getItemInCloset(Closet name, String item){
        name.getItem(item);
    }

    public void seeInCloset(Closet name){
        name.printAllItem();
    }

    public void callCat(Cat name){
        name.comePerson();
    }

    public void kickAwayCat(Cat name){
        name.leavePerson();
    }

    public void petCat(Cat name){
        name.joy();
    }

    public void feedCat(Cat name){
        name.eat();
    }
}