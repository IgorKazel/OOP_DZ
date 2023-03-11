public class Person {
    private String fullName;
    private int age;
    private Gender gender;

    public Person(String fullName, Gender gender, int age) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.gender = Gender.none;
        this.age = age;
    }

    public Person(String fullName) {
        this.fullName = fullName;
        this.gender = Gender.none;
        this.age = -1;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
