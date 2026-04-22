class Message {
    Message(String msg) {
        System.out.println("Constructor message: " + msg);
    }
}

public class MessageArray {
    public static void main(String[] args) {
        Message[] arr = new Message[5];
       
        // No objects created → no constructor messages printed
    }
}