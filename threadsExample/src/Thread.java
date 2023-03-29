public class Thread extends java.lang.Thread {
   private String name;

   public Thread(String name) {
       this.name = name;
   }

    @Override
    public void run() {
        System.out.println(name + "1");
        System.out.println(name + "2");
        System.out.println(name + "3");

    }

}
