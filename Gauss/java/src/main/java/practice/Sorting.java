package practice;

/**
 * Created by neerbans on 6/16/2017.
 */
public class Sorting {

    public static void main (String [] args) {

        Sorting obj = new Sorting();
        int [] arr = {3,5,4,1,2};
        obj.printArray(arr);
//        obj.quickSort(arr, 0, arr.length-1);
        obj.mergeSort(arr, 0, arr.length-1);
        obj.printArray(arr);
    }

    private void mergeSort(int [] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int [] arr, int start, int mid, int end) {
        int p = start, q = mid+1, k = 0;
        int [] a = new int[end-start+1];
        for (int i = start; i<=end ; i++) {
            if (p > mid) {
                a[k++] = arr[q++];
            } else if (q > end) {
                a[k++] = arr[p++];
            } else if (arr[p] > arr[q]) {
                a[k++] = arr[q++];
            } else {
                a[k++] = arr[p++];
            }
        }
        for (int x=0; x<k; x++) {
            arr[start++] = a[x];
        }
    }

    private void printArray(int [] array) {
        System.out.println();
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    private void quickSort(int [] arr, int x, int y) {
        if (x < y) {
            int pivot = getPivot(arr, x, y);
            if (pivot > x + 1) {
                quickSort(arr, x, pivot - 1);
            }
            if (pivot < y - 1) {
                quickSort(arr, pivot + 1, y);
            }
        }
    }

    private int getPivot(int [] arr, int x, int y) {
        int pivot = arr[x];
        int j = x;
        for (int i=x+1; i<=y; i++) {
            if (arr[i] < pivot) {
                ++j;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[x];
        arr[x] = temp;
        return j;
    }

    private void swap(int a, int b) {

    }
}
