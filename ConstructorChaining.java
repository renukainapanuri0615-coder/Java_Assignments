class Demo {
    Demo() {
        this(10);  // calling second constructor
        System.out.println("First constructor called");
    }

    Demo(int x) {
        System.out.println("Second constructor called with value: " + x);
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        new Demo();
    }
}