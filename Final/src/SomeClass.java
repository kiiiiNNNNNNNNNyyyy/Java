public class SomeClass {
    public final int instanceNumber;
    private static int classCounter = 0;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " crated, instance is " + instanceNumber);
    }

    public static int getClassCounter() {
        return classCounter;
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
