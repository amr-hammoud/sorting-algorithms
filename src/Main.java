import java.util.Random;
import java.util.Scanner;


public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    static int[] arr;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        String input;
        int size = 0;

        System.out.println("Welcome to the array sorting program!");
        System.out.print("Please input the size of the array to start: ");
        input = scanner.next();


        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println(input + " is not a valid integer");
        }
        arr = createFilledArray(size);


        while(!input.equalsIgnoreCase("5")){
            System.out.print(GREEN + "\n------------------------" + RESET +
                             "\nChoose one of the options:" +
                             GREEN + "\n  1) " + RESET + "Quick Sort" +
                             GREEN + "\n  2) " + RESET + "Merge Sort" +
                             GREEN + "\n  3) " + RESET + "Bubble Sort" +
                             GREEN + "\n  4) " + RESET + "Change Array Size" +
                             GREEN + "\n  5) " + RESET + "Exit Program" +
                             "\nchoice: ");
            input = scanner.next();
            switch (input){
                case "1":
                    sortUsing(arr, "quick");
                    break;
                case "2":
                    sortUsing(arr, "merge");
                    break;
                case "3":
                    sortUsing(arr, "bubble");
                    break;
                case "4":
                    changeArraySize();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }

    private static void changeArraySize(){
        System.out.print("Enter new Array size: ");
        String input = scanner.next();
        arr = createFilledArray(Integer.parseInt(input));
    }

    private static int[] createFilledArray(int size){
        int[] arr = new int[size];
        fillArray(arr, size);
        return arr;
    }


    private static void sortUsing(int[] arr, String method){

        long begin = 0;
        long end = 0;

        System.out.println(GREEN + "\n-- UNSORTED SAMPLES --" + RESET);
        printArray(arr);

        System.out.println(GREEN + "\n\n-- STARTED SORTING --" + RESET);

        if(method.equalsIgnoreCase("quick")){
            begin = System.currentTimeMillis();
            QuickSortClass.quickSort(arr);
            end = System.currentTimeMillis();
        } else if (method.equalsIgnoreCase("merge")) {
            begin = System.currentTimeMillis();
            MergeSortClass.mergeSort(arr);
            end = System.currentTimeMillis();
        } else if (method.equalsIgnoreCase("bubble")) {
//            begin = System.currentTimeMillis();
//            BubbleSortClass.bubbleSort(arr);
//            end = System.currentTimeMillis();
        }
        else{
            System.out.println("\nInvalid Sorting Method");
        }


        System.out.println(GREEN + "-- FINISHED SORTING --" + RESET);

        System.out.println(GREEN + "\n-- SORTED SAMPLES --" + RESET);
        printArray(arr);

        long time = end- begin;
        System.out.println(RED + "\n\nElapsed Time: " + time + "ms" + RESET);

    }

    private static void printArray(int[] arr) {

        System.out.println(YELLOW + "first 10" + RESET);
        for (int i = 0; i < 10 ; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(YELLOW + "\nmiddle 10" + RESET);
        for (int i = arr.length/2 ; i < (arr.length/2) + 10 ; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(YELLOW + "\nlast 10" + RESET);
        for (int i = arr.length - 10 ; i < arr.length ; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void fillArray(int[] array, int range) {

        Random rand = new Random();

        System.out.println("-- Started Filling Array --");

        for (int i = 0; i < array.length ; i++) {
            array[i] = rand.nextInt(range);
        }

        System.out.println("-- Finished Filling Array --");
    }

}