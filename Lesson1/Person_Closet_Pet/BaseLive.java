public abstract class BaseLive implements Comparable<BaseLive> {
    public String name;
    public int age;
    public Gender gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender.toString();
    }

    @Override
    public String toString(){
        return name;
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
        } else if (this.getName().equals(((BaseLive) obj).getName()) && this.getAge() == ((BaseLive) obj).getAge() && this.getGender() == ((BaseLive) obj).getGender()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(BaseLive obj){
        return this.getAge() - obj.getAge();
    }
}
