public class GearBox {
    
    private boolean clutchIsIn;

    public void operateCluctch(String inOrOut) {
        this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
    }
}