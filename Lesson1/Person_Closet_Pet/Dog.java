public class Dog extends BaseLive implements Pet {

    private boolean isNear;

    public Dog(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isNear = false;
    }

    @Override
    public void comePerson(){

    }

    @Override
    public void leavePerson() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void joy() {

    }
}
