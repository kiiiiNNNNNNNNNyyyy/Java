public class Main {
    public static void main(String[] args) {
        ITelephone timsPhone = new Deskphone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();
        timsPhone = new Mobilephone(654321);
        timsPhone.powerOn();
        timsPhone.callPhone(654321);
        timsPhone.answer();
    }
}