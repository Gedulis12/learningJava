import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 10 daily report entries
        DailyReport r1 = new DailyReport("Mantas", "Varžtas", 330, 0.7);
        DailyReport r2 = new DailyReport("Tadas", "Vinis", 7000, 0.5);
        DailyReport r3 = new DailyReport("Tomas", "Veržlė", 200, 0.2);
        DailyReport r4 = new DailyReport("Lukas", "Poveržlė", 3000, 0.15);
        DailyReport r5 = new DailyReport("Petras", "Varžtas", 500, 0.7);
        DailyReport r6 = new DailyReport("Antanas", "Vinis", 3000, 0.5);
        DailyReport r7 = new DailyReport("Jonas", "Veržlė", 8000, 0.2);
        DailyReport r8 = new DailyReport("Paulius", "Poveržlė", 3000, 0.15);
        DailyReport r9 = new DailyReport("Povilas", "Varžtas", 150, 0.7);
        DailyReport r10 = new DailyReport("Algirdas", "Vinis", 700, 0.5);

        // Adding all objects to list
        List<DailyReport> dailyReports = new ArrayList<>();
        Collections.addAll(dailyReports, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        printProductSummary((ArrayList<DailyReport>) dailyReports);

        // Sorting the objects by produced quantity and product name
        System.out.println("----------");
        System.out.println("All reports before sorting:");
        printAllreports((ArrayList<DailyReport>) dailyReports);
        Collections.sort(dailyReports);
        System.out.println("All reports after sorting:");
        printAllreports((ArrayList<DailyReport>) dailyReports);

        // Removing objects with total output exceeding 1000 EUR:
        System.out.println("----------");
        System.out.println("All reports after removals:");
        removeOverOneK((ArrayList<DailyReport>) dailyReports);
        printAllreports((ArrayList<DailyReport>) dailyReports);

    }

    static void printProductSummary(List<DailyReport> reports) {
        Set<String> uniqueProducts = DailyReport.getUniqueProducts();
        for (String product : uniqueProducts) {
            int totalQty = 0;
            double totalAmount = 0;
            String dailyRateReached = " DAILY RATE REACHED";
            for (DailyReport report : reports) {
                if (report.getProduct().equals(product)) {
                    totalQty += report.getQty();
                    totalAmount += report.getTotal();
                }
            }
            if (totalQty < 1000) {
                dailyRateReached = " DAILY RATE NOT REACHED";
            }
            System.out.println("Total " + product + " produced: " + totalQty + " which is worth " + totalAmount + " EUR" + " | " + dailyRateReached);
        }
    }

    static void printAllreports(ArrayList<DailyReport> reports) {
        reports.forEach(report -> System.out.println(report));
        System.out.println("----------");
    }

    static void removeOverOneK(ArrayList<DailyReport> reports) {
        Iterator<DailyReport> iterator = reports.iterator();
        while (iterator.hasNext()) {
            DailyReport report = iterator.next();
            if (report.getTotal() > 1000) {
                iterator.remove();
            }
        }
    }
}