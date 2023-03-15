public class Cat extends BaseLive implements Pet {
    private boolean isNear;

    public Cat(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isNear = false;
    }

    public boolean getIsNear(){
        return isNear;
    }

    @Override
    public void comePerson() {
            isNear = true;
            System.out.println(name + " подошла");
    }

    @Override
    public void leavePerson() {
        isNear = false;
        System.out.println(name + " убежала");
    }

    @Override
    public void joy() {
            System.out.println(name + " довольна");
            System.out.println("Мррррр");
    }

    @Override
    public void eat() {
        if (isNear){
            System.out.println(name + " ест");
            System.out.println("Хрум хрум хрум");
        } else {
            isNear = true;
            System.out.println(name + " подошла и ест");
            System.out.println("Хрум хрум хрум");
        }
    }

    public void askEat(Person person){
        if (isNear){
            System.out.println(name + "просит есть");
        } else {
            isNear = true;
            System.out.println(name + " подошла и просит есть");
        }
        System.out.println("Мяяяяяу");
        person.feedCat(this);
    }
}
