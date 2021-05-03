public class Main {
    public static void main(String[] args) {
        ITelephone arjunsPhone = new Deskphone(1234123);
        arjunsPhone.powerOn();
        arjunsPhone.callPhone(512323);
        arjunsPhone.answer();

        arjunsPhone = new MobilePhone(412354123);
        arjunsPhone.powerOn();
        arjunsPhone.callPhone(51235123);
        arjunsPhone.answer();
    }
}
