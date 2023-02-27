public class Table {
   private String name;
   private int weight;
   private String material;
   private int legCount;
   private int price;

   public Table () {
   }

    public Table(String name, int weight, String material, int legCount, int price) {
        this.name = name;
        this.weight = weight;
        this.material = material;
        this.legCount = legCount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getLegCount() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
