public class Cat extends BaseLive implements Pet {
    private boolean isNear;

    public Cat(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isNear = false;
    }

    @Override
    public void comePerson() {
        if (isNear) {
            System.out.println(name + " и так рядом");
        } else {
            isNear = true;
            System.out.println(name + " подошла");
        }
    }

    @Override
    public void leavePerson() {
        if (isNear) {
            isNear = false;
            System.out.println(name + " убежала");
        } else {
            System.out.println(name + " не рядом");
        }
    }

    @Override
    public void joy() {
        if (isNear) {
            System.out.println(name + " довольна");
            System.out.println("Мррррр");
        } else {
            System.out.println(name + " не рядом");
        }
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
}
