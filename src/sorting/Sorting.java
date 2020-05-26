package sorting;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {9,8,7,5,4,3,2,1};
        
        array = selectionSort(array);

        System.out.println(array);

    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }

            //swap
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int minItem = array[i];

            int j = i - 1;
            while (j >= 0 && minItem < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = minItem;
        }

        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isSwapped = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!isSwapped)
                break;
        }
        return array;
    }
}
