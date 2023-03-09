import com.assignment.base.TransportImpl;
import com.assignment.derived.CarImpl;

public class Main {
    public static void main(String[] args) {

        // create 5 base objects:
        TransportImpl t1 = new TransportImpl("air", true, 2022);
        TransportImpl t2 = new TransportImpl("water", false, 2000);
        TransportImpl t3 = new TransportImpl("ground", true, 2017);
        TransportImpl t4 = new TransportImpl("air", false, 1996);
        TransportImpl t5 = new TransportImpl("water", true, 2017);

        // create 5 inherited objects:
        CarImpl c1 = new CarImpl(1980, "Mercedes", 4, false);
        CarImpl c2 = new CarImpl(2020, "Audi", 2, false);
        CarImpl c3 = new CarImpl(2021, "Hyundai", 4, true);
        CarImpl c4 = new CarImpl(2017, "Tesla", 4, true);
        CarImpl c5 = new CarImpl(2005, "Volkswagen", 4, false);

        // add all objects to list:
        TransportImpl[] vehicles = {t1, t2, t3, t4, t5, c1, c2, c3, c4, c5};

        // print objects of derived class that has EV motor:
        System.out.println("Cars with EV motor:");
        printEVCars(vehicles);

        // get the oldest car and change its brand to 'Rolls-Royce':
        CarImpl oldestCar = getOldestCar(vehicles);
        System.out.println("\nOldest car:");
        System.out.println(oldestCar.toString());
        oldestCar.setBrand("Rolls-Royce");
        System.out.println("Oldest car after the brand change:");
        System.out.println(oldestCar.toString());

        // look for 2 doored "Audi" and change it's manufacturing year to 2000:
        changeYearOf2DooredAudi(vehicles, 2000);

        // print all info about cars which have even manufacturing year
        System.out.println("\nAll details about cars which have even manufacturing year");
        printDetailsOfCarsWithEvenManufacturingYear(vehicles);
    }

    /**
     * Takes list of vehicles, finds 2 doored "Audi" cars and changes their manufacturing year
     * @param cars type TransportImpl[] - list of vehicles
     * @param newYear type int, year that we want to set
     */
    static void changeYearOf2DooredAudi(TransportImpl[] cars, int newYear) {
        for (TransportImpl car : cars) {
            if (car instanceof CarImpl
                    && ((CarImpl) car).getDoorQty() == 2
                    && ((CarImpl) car).getBrand().equals("Audi")) {
                System.out.println("\ndetails of 2 doored Audi:");
                System.out.println(car.toString());
                car.setManufacturedYear(newYear);
                System.out.println("details of 2 doored Audi after the manufactured year change:");
                System.out.println(car.toString());
            }
        }
    }

    /**
     * Takes list of TransportImpl type objects and prints those that are CarImpl type instance has even manufacturing year
     * @param cars type TransportImpl[] a list of vehicles that we want to traverse
     */
    static void printDetailsOfCarsWithEvenManufacturingYear(TransportImpl[] cars) {
        for (TransportImpl car : cars) {
            if (car instanceof CarImpl
                    && ((CarImpl) car).getManufacturedYear() % 2 == 0) {
                System.out.println(car.toString());
            }
        }

    }

    /**
     * Takes a list of TransportImpl type objects and prints all that are CarImpl type instance and has EV motor
     * @param cars type TransportImpl[] a list of vehicles that we want to traverse
     */
    static void printEVCars(TransportImpl[] cars) {
        for (TransportImpl car : cars) {
           if (car instanceof CarImpl && ((CarImpl) car).isEVPowered()) {
               System.out.println(car);
           }
        }
    }

    /**
     * Takes a list of TransportImpl type objects and returns one that is CarImpl type instance and has the oldest manufacturing year
     * @param cars type TransportImpl[] - list of vehicles that we want to traverse
     * @return CarImpl type object that has the lowest manufacturing year out of the list
     */
    static CarImpl getOldestCar(TransportImpl[] cars) {
        int oldest = cars[0].getManufacturedYear();
        TransportImpl oldestCar = cars[0];
        for (TransportImpl car : cars) {
            if (car.getManufacturedYear() < oldest) {
                oldest = car.getManufacturedYear();
                oldestCar = car;
            }
        }
        return (CarImpl) oldestCar;
    }
}