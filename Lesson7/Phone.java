public abstract class Phone implements Call {
    private String phoneNumber;

    public Phone(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }
}
