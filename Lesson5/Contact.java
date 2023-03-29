public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()){
            return false;
        } else if (this.getFirstName().equals(((Contact) obj).getFirstName())
                && this.getLastName().equals(((Contact) obj).getLastName())
                && this.getPhoneNumber().equals(((Contact) obj).getPhoneNumber())){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Contact obj) {
        int result = this.firstName.compareTo(obj.getFirstName());
        if (result == 0) {
            result = this.lastName.compareTo(obj.getLastName());
        }
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + phoneNumber;
    }
}
