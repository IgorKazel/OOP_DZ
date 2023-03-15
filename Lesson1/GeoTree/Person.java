public class Person implements Comparable<Person> {
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

    @Override
    public String toString(){
        return fullName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        } else if (this.getClass() != obj.getClass()){
            return false;
        } else if (this.getFullName().equals(((Person) obj).getFullName()) && this.getAge() == ((Person) obj).getAge() && this.getGender() == ((Person) obj).getGender()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Person obj){
        return this.getAge() - obj.getAge();
    }
}
