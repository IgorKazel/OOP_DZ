public class Cat {
    private String name;
    private int age;
    private Gender gender;
    private boolean isNear;

    public Cat(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isNear = false;
    }

    public void comePerson() {
        if (isNear) {
            System.out.println(name + " и так рядом");
        } else {
            isNear = true;
            System.out.println(name + " подошла");
        }
    }

    public void leavePerson() {
        if (isNear) {
            isNear = false;
            System.out.println(name + " убежала");
        } else {
            System.out.println(name + " не рядом");
        }
    }

    public void joy() {
        if (isNear) {
            System.out.println(name + " довольна");
            System.out.println("Мррррр");
        } else {
            System.out.println(name + " не рядом");
        }
    }
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
