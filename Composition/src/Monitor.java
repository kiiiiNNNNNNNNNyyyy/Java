public class Monitor {
    private String model;
    private String manufactured;
    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufactured, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufactured = manufactured;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }

    public void setNativeResolution(Resolution nativeResolution) {
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixels at " + x + ", " + y + " in color " + color);
    }
}
