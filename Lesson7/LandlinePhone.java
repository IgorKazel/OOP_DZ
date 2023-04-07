public class LandlinePhone extends Phone {

    public LandlinePhone(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void call(String phone) {
        System.out.println("Звонок со стационарного телефона на номер " + phone);
    }

    @Override
    public void answer() {
        System.out.println("Ответ на звонок со стационарного телефона");
    }
}
