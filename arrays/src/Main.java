public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        int count;
        int negativeCount;
        int positiveSum;
        int positiveMultiply;
        int[] positiveElements;
        count = countNumbersInArray(numbers);
        negativeCount = getNegativeElementCount(numbers);
        positiveSum = getPositiveElementSum(numbers);
        positiveMultiply = getPositiveElemetMultiplication(numbers);
        positiveElements = getArrayOfPositiveElements(numbers);
        printArrayElements(numbers);
        System.out.println();
        System.out.println("Total elements in array: " + count);
        System.out.println("Total negative elements in array: " + negativeCount);
        System.out.println("Sum of  positive elements in array: " + positiveSum);
        System.out.println("Multiplication of all positive elements in array equals to: " + positiveMultiply);
        System.out.print("Positive elements of the array: ");
        printArrayElements(positiveElements);
    }

    static int countNumbersInArray(int[] numbers) {
        int count = 0;
        for (int i : numbers) {
            count++;
        }
        return count;
    }

    static void printArrayElements(int[] numbers) {
        System.out.print("Elements in array: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }

    static int getNegativeElementCount(int[] numbers) {
        int count = 0;
        for (int i : numbers) {
            if (i < 0) {
                count++;
            }
        }
        return count;
    }

    static int getPositiveElementCount(int[] numbers) {
        int count = 0;
        for (int i : numbers) {
            if (i > 0) {
                count++;
            }
        }
        return count;
    }

    static int getPositiveElementSum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }

    static int getPositiveElemetMultiplication(int[] numbers) {
        int multiply = 1;
        int positiveCount = 0;
        for (int i : numbers) {
            if (i > 0) {
                multiply = multiply * i;
                positiveCount++;
            }
        }
        if (positiveCount > 0) {
            return multiply;
        } else {
            return 0;
        }
    }

    static int[] getArrayOfPositiveElements(int[] numbers) {
        int positiveElementCount = getPositiveElementCount(numbers);
        int idx = 0;
        int[] positiveArray = new int[positiveElementCount];
        for (int i : numbers) {
            if (i > 0) {
                positiveArray[idx] = i;
                idx++;
            }
        }
        return positiveArray;
    }
}