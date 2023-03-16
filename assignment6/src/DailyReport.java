import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class DailyReport implements Comparable<DailyReport> {
    private String worker;
    private String product;
    private int qty;
    private double price;
    static Set<String> uniqueProducts = new HashSet<>();

    public DailyReport () {}

    public DailyReport (String worker, String product, int qty, double price) {
       this.worker = worker;
       this.product = product;
       this.qty = qty;
       this.price = price;
       uniqueProducts.add(product);
    }

    public String getWorker() {
        return this.worker;
    }
    public void setWorker(String worker) {
       this.worker = worker;
    }
    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
       this.product = product;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        double total;
        double price = getPrice();
        int amount = getQty();
        total = price * amount;
        return total;
    }

    public static Set<String> getUniqueProducts() {
        return uniqueProducts;
    }

    @Override
    public String toString() {
        return "DailyReport: " +
                "worker='" + worker + '\'' +
                ", product='" + product + '\'' +
                ", amount=" + qty +
                ", price=" + price +
                ", total output=" + getTotal();
    }

    @Override
    public int compareTo(DailyReport dailyReport) {
        return Comparator
                .comparing(DailyReport::getQty)
                .reversed()
                .thenComparing(DailyReport::getProduct)
                .compare(this, dailyReport);
    }
}