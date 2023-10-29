public class MergeSortClass {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int start, int mid, int end){

        int s1 = mid - start + 1;
        int s2 = end - mid;

        int[] left = new int[s1];
        int[] right = new int[s2];

        for(int i = 0; i < s1; ++i) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < s2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;

        int k = start;
        while (i < s1 && j < s2){
            if (left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < s1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < s2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    private static void sort(int[] arr, int start, int end){
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr, start,mid,end);
        }
    }

}
