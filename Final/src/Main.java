public class Main {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        //one.instanceNumber = 4;
        System.out.println(Math.PI);

        int pass = 4123453;
        Password password = new Password(pass);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(4123213);
        password.letMeIn(44123);
        password.letMeIn(4123453);
    }
}
