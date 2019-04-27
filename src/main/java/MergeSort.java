import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,5,2,66,11};
        MergeSort.merge(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void merge(int[] arr) {
        if (arr == null) {
            return;
        }
        int length = arr.length;
        if (length > 1) {
            int mid = length / 2;
            int[] a = Arrays.copyOfRange(arr, 0, mid);
            int[] b = Arrays.copyOfRange(arr, mid, length);
            merge(a);
            merge(b);
            sort(a, b, arr);
        }
    }

    public static void sort(int[] a, int[] b, int[] arr) {
        int x = 0;
        int y = 0;
        int z = 0;
        while (x < a.length && y < b.length) {
            if (a[x] > b[y]) {
                arr[z] = a[x];
                x++;
            } else {
                arr[z] = b[y];
                y++;
            }
            z++;
        }
        if(x == a.length){
            while (z < arr.length){
                arr[z] = b[y];
                y++;
                z++;
            }
        }else if(y == b.length){
            while (z < arr.length){
                arr[z] = a[x];
                x++;
                z++;
            }
        }
    }
}