public class Main {
    public static void main(String[] args) {
        runThreads();
    }

    public static void runThreads() {
        Thread t1 = new Thread("First");
        Thread t2 = new Thread("Second");
        t1.start(); t2.start();
    }
}