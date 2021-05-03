class Deskphone implements ITelephone {
    
    private int myNumber;
    private boolean isRinging;

    Deskphone(int phoneNumber) {
        this.myNumber = phoneNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, dark phone does not have a power button!");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber);
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answer the desk phone!");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber) {
            isRinging = true;
            System.out.println("Ring ring!");
        } else {
            isRinging = false;
        }

        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}