import java.util.*;

/**
 * SortingExample class demonstrates two common sorting algorithms:
 * QuickSort and MergeSort, with sample arrays to showcase their functionality.
 * 
 * @author Mohammad Sadaqa
 * @version 1.1
 */
public class SortingExample {

    /**
     * Main method that demonstrates sorting with QuickSort and MergeSort.
     * It sorts the arrays and outputs the results to the console.
     *
     * @param args Command-line arguments (not used in this case)
     */
    public static void main(String[] args) {
        // Sample unsorted arrays
        Integer[] numbers1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
        int[] numbers2 = { 2, 6, 3, 5, 1 };

        // Apply QuickSort to the first array
        quickSort(numbers1, 0, numbers1.length - 1);
        
        // Print the sorted result
        System.out.println("QuickSorted Array 1: " + Arrays.toString(numbers1));

        // Apply MergeSort to the second array
        mergeSort(numbers2, numbers2.length);
        
        // Print the sorted result
        System.out.println("MergeSorted Array 2: " + Arrays.toString(numbers2));
    }

    /**
     * QuickSort algorithm to sort an array of integers.
     *
     * @param arr The array to be sorted
     * @param low The starting index for sorting
     * @param high The ending index for sorting
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        // Base case for recursion - if the array is null or empty
        if (arr == null || arr.length == 0) {
            return;
        }
        
        // Termination condition for recursion
        if (low >= high) {
            return;
        }

        // Select pivot and partition the array
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        
        int i = low, j = high;
        while (i <= j) {
            // Find element on the left side larger than pivot
            while (arr[i] < pivot) {
                i++;
            }
            
            // Find element on the right side smaller than pivot
            while (arr[j] > pivot) {
                j--;
            }
            
            // Swap elements that are out of order
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursively apply QuickSort on subarrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swap two elements in an array.
     *
     * @param array The array where elements are swapped
     * @param x The index of the first element
     * @param y The index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * MergeSort algorithm to sort an array of integers.
     *
     * @param array The array to be sorted
     * @param length The length of the array
     */
    public static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        // Divide the array into two halves
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, length - mid);

        // Recursively sort each half
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        // Merge the sorted halves
        merge(array, left, right, mid, length - mid);
    }

    /**
     * Merge two sorted arrays into one sorted array.
     *
     * @param array The original array that will hold the merged result
     * @param left The sorted left half
     * @param right The sorted right half
     * @param leftSize The size of the left array
     * @param rightSize The size of the right array
     */
    public static void merge(int[] array, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge the arrays while elements exist in both halves
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left half
        while (i < leftSize) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements from the right half
        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }

    /**
     * Check if an array is sorted in ascending order.
     *
     * @param array The array to check
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
