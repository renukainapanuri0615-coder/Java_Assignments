class Message {
    Message(String msg) {
        System.out.println("Constructor message: " + msg);
    }
}

public class MessageArray2 {
    public static void main(String[] args) {
        Message[] arr = new Message[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Message("array " + (i + 1));
        }
    }
}