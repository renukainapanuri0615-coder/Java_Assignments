// Step 1: Create 3 custom exceptions
class MyException1 extends Exception {
    public MyException1(String msg) {
        super(msg);
    }
}

class MyException2 extends Exception {
    public MyException2(String msg) {
        super(msg);
    }
}

class MyException3 extends Exception {
    public MyException3(String msg) {
        super(msg);
    }
}

// Main class
public class CustomExceptionDemo {

    // Step 2: Method that throws all 3 exceptions
    static void checkException(int num) throws MyException1, MyException2, MyException3 {

        if (num == 1) {
            throw new MyException1("This is MyException1");
        } else if (num == 2) {
            throw new MyException2("This is MyException2");
        } else if (num == 3) {
            throw new MyException3("This is MyException3");
        } else {
            // Force a NullPointerException
            String s = null;
            System.out.println(s.length()); // This will throw NullPointerException
        }
    }

    public static void main(String[] args) {

        try {
            checkException(4);  // change value (1,2,3,4) to test
        }

        // Step 3: Single catch block for all exceptions
        catch (MyException1 | MyException2 | MyException3 | NullPointerException e) {
            System.out.println("Caught Exception: " + e);
        }

        // Step 4: Finally block
        finally {
            System.out.println("Finally block always executes");
        }
    }
}