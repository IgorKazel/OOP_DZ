public class Smartphone extends Phone implements Message, Email{

    public Smartphone(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void call(String phone) {
        System.out.println("Звонок со смартфона на номер " + phone);
    }

    @Override
    public void answer() {
        System.out.println("Ответ на звонок со смартфона");
    }

    @Override
    public void SendMessage(String phone) {
        System.out.println("Отправка сообщения со смартфона на номер " + phone);
    }

    @Override
    public void GetMessage() {
        System.out.println("Получение сообщения на смартфон");
    }

    @Override
    public void SendEmail(String email){
        System.out.println("Отправка имейла со смартфона на адрес " + email);
    }

    @Override
    public void GetEmail(){
        System.out.println("Получение имейла на смартфон");
    }
}
