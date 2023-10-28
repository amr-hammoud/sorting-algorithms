public class QuickSortClass {

    public static void quickSort(int[] arr) {

        privateQuickSort(arr, 0, arr.length - 1);

    }

    private static void privateQuickSort(int[] arr, int start, int end){

        if (start < end) {
            int pi = partition(arr, start, end);
            privateQuickSort(arr, start, pi - 1);
            privateQuickSort(arr, pi + 1, end);
        }

    }

    private static int partition(int[] arr, int start, int end ){

        int pivot = arr[end];

        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
