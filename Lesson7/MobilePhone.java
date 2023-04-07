public class MobilePhone extends Phone implements Message {

    public MobilePhone(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void call(String phone) {
        System.out.println("Звонок с мобильного телефона на номер " + phone);
    }

    @Override
    public void answer() {
        System.out.println("Ответ на звонок с мобильного телефона");
    }

    @Override
    public void SendMessage(String phone) {
        System.out.println("Отправка сообщения с мобильного телефона на номер " + phone);
    }

    @Override
    public void GetMessage() {
        System.out.println("Получение сообщения на мобильный телефон");
    }
}
