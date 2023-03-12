public abstract class BaseLive {
    String name;
    int age;
    Gender gender;

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getGender() {
        return gender.toString();
    }
}
