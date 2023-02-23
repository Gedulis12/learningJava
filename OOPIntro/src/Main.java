public class Main {
    public static void main(String[] args) {
        Student S = new Student();
        S.setName("Bob");
        String name = S.getName();
        Student S2 = new Student("Alice");
        System.out.println("Students name is: " + name);
        name = S2.getName();
        System.out.println("Students name is: " + name);
    }
}