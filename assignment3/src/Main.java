public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 17, 8, 4, 53, -6, -79, -1, -30, -5};
        int[] numbersWithMinMaxSwapped = swapMinMaxInArray(numbers);
        double average = calculateAverageOfEvenNumbers(numbers);
        int minOfNegativeEvens = getMinOfNegativeEvens(numbers);
        printArrayBeforeAndAfter(numbers, numbersWithMinMaxSwapped);
        System.out.println("\nCalculated average of even numbers in array: " + average);
        System.out.println("Minimum value of negative even numbers in array is: " + minOfNegativeEvens);
    }

    /**
     * Function calculates amount of even numbers in the integer array
     *
     * @param numbers an integer array
     * @return type int, count of even numbers in the array
     */
    static int countEvenNumbersInArray(int[] numbers) {
        int evenCount = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    /**
     * Function adds up all of the even numbers in the integer array
     *
     * @param numbers an integer array
     * @return type int, sum if all even numbers in the array
     */
    static int addEvenNumbersInArray(int[] numbers) {
        int evenSum = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }
        return evenSum;
    }

    /**
     * Function calculates the average value of all even numbers in the array
     *
     * @param numbers an integer array
     * @return type int, average of even numbers in the array
     */
    static double calculateAverageOfEvenNumbers(int[] numbers) {
        int evenCount = countEvenNumbersInArray(numbers);
        int evenSum = addEvenNumbersInArray(numbers);
        double average = 0;
        average = (double) evenSum / evenCount;
        return average;
    }

    /**
     * Function returns the lowest value of the integer array
     *
     * @param numbers an integer array
     * @return type int, min value of the array
     */
    static int getMinValueInArray(int[] numbers) {
        int min = numbers[0];
        for (int i : numbers) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Function returns the highset value of the integer array
     *
     * @param numbers an integer array
     * @return type int, max value of the array
     */
    static int getMaxValueInArray(int[] numbers) {
        int max = numbers[0];
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Function takes ant integer array and returns the array with it's min and max values swapped
     *
     * @param numbers an integer array
     * @return type int[], an integer array with places swapped for min and max values
     */
    static int[] swapMinMaxInArray(int[] numbers) {
        int min = getMinValueInArray(numbers);
        int max = getMaxValueInArray(numbers);
        int minId = 0;
        int maxId = 0;
        int[] minMaxSwapped = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min) {
                minId = i;
                minMaxSwapped[i] = numbers[i];
            } else if (numbers[i] == max) {
                maxId = i;
                minMaxSwapped[i] = numbers[i];
            } else {
                minMaxSwapped[i] = numbers[i];
            }
        }
        minMaxSwapped[minId] = max;
        minMaxSwapped[maxId] = min;
        return minMaxSwapped;
    }

    /**
     * Function takes two integer arrays and prints them as before and after variants
     *
     * @param before an integer array (before changes)
     * @param after  an integer array (after changes)
     */
    static void printArrayBeforeAndAfter(int[] before, int[] after) {
        System.out.println("Array before applying any changes: ");
        for (int i : before) {
            System.out.print(i + " ");
        }
        System.out.println("\nArray after applying the changes: ");
        for (int i : after) {
            System.out.print(i + " ");
        }
    }

    /**
     * Function takes an integer array and returns the lowest negative even value of the array.
     *
     * @param numbers an integer aray
     * @return type int, lowest negative even value of the integer array.
     */
    static int getMinOfNegativeEvens(int[] numbers) {
        int min = numbers[0];
        for (int i : numbers) {
            if (i < 0 && i % 2 == 0) {
                if (i < min) {
                   min = i;
                }
            }
        }
        if (min < 0) {
            return min;
        } else {
            return 0;
        }
    }
}