package com.subbu.framework.Base;

import java.util.*;
import static java.lang.Math.round;
public class Assignment {
    public static HashMap returnmyHash() {
        HashMap hm = new HashMap();
        hm.put(1,"Subbu");
        hm.put(2,"Subramaniam");
        return hm;
    }
    public static String createphonenumbers( int[] numbers) {
        String strnumbers = Arrays.toString(numbers).replace("[","").replace("]","");
        String[] arraynums = strnumbers.split(",");
        String npa = "";
        String nxx = "";
        String localnum = "";
        for ( int i =0;i <3;i++) {
           npa = npa.concat(arraynums[i]);
        }
        for ( int j =3;j <6;j++) {
            nxx= nxx.concat(arraynums[j]);
        }
        for ( int k =6;k < 10;k++) {
            localnum = localnum.concat(arraynums[k]);
        }
        return npa + "-" + nxx + "-" + localnum;
    }
    public static String[] splitStrings(String input,float splitcnt) {
        int i=0;
        int start = 0;
        int end = i + (int)splitcnt;
        int loop = round(input.length() / splitcnt);
        String[] output = new String[loop];
            for (i = 0; i < loop; i++) {
                if (start >= input.length()) {
                    output[i]= input.substring(input.length() + 1 - (int)splitcnt);
                    for (int j = output[i].length(); j < splitcnt; j++) {
                        output[i] = output[i].concat("_");
                    }
                    return output;
                }
                output[i]= input.substring(start, end);
                start = start + end;
                end = start + end;

            }
        return output;
    }
    public static String whoLikesIt(String[] names) {
        switch (names.length) {
            case 0:
                return "no one likes it";
            case 1:
                return names[0] + "likes it";
            case 2:
                return names[0] + "and" + names[1] + "like this";
            case 3:
                return names[0] + "," + names[1] + " and " + names[2] + " others like this";
            default:
                return names[0] + "," + names[1] + " and " + (names.length -2) + " others like this";
                }
        }
    public static String maskCreditCard(String creditcard) {
        char[] creditarray = creditcard.toCharArray();
        String maskedcreditcard="";
        StringBuilder str = new StringBuilder();
        for (int i=0;i <= creditcard.length() -5;i++ ) {
            creditarray[i] = 'x';
        }
        str = str.append(creditarray);
        return str.toString();
    }
    public static int findNextSquare(double number) {
        double squarenum = (Math.sqrt(number)*Math.sqrt(number));
        if (Math.sqrt(number)<=(int)Math.sqrt(number)){
            System.out.println("Equal to or less than");
            return (int)squarenum;
        }
            return ((int)(Math.sqrt(number)) +1) * ((int)(Math.sqrt(number)) +1);
    }
    public static String bitCounting(int number) {
        return Integer.toBinaryString(number);
    }
    public static String reverseString(String input) {
        char[] charinputarray = input.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i=charinputarray.length -1;i>= 0;i--) {
            str.append(charinputarray[i]);
        }
        return str.toString();
    }
    public static boolean checkIfPrime(int input) {
        if (input==0  || input ==1){
            return false;
        }
        if (input ==2 || (input % 2 > 0) ){
            return true;
        }
        return false;
    }
    public static int singlenumber (int[] nums) {
        int a=0;
        for (int x: nums) {
            a =a ^ x;
        }
        return a;
    }
    public static int removeDuplicates(int[] nums) {
        int j=0;
        int i =1;
        while ( i < nums.length) {
            if (nums[j] !=nums[i]) {
                nums[j] = nums[i];
                j++;
            }
                i++;
            }
        return j;
    }
    public static int sum(String input) {
        StringTokenizer str = new StringTokenizer(input,"+");
        int result = 0;
        for (int i=0;i <= str.countTokens();i++) {
            result = result + Integer.parseInt(str.nextToken());
        }
        return result;
    }
    public static int pow(int x,int n) {
        if (n==0)
            return 1;
        if (x==0)
            return 0;
        return pow(x,n-1)* x;
    }
    public static int[] duplicatearray(int[] num ) {
        int[] result = new int[num.length];
        for (int i=0;i <num.length;i++) {
            for (int j=i+1;j < num.length;j++) {
                if (num[i] == num[j]) {
                    result[i] = num[i];
                    //System.out.println("Duplicate:" + num[i]);
                    break;
                }
            }
        }
        return result;
    }
    public static int[] bubblesort(int[] x) {
        int n = x.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (x[j] > x[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
        return x;
    }
    public static int[] insertionsort(int[] x) {
        int n = x.length;
        for (int i=0; i < n;i++) {
            int key = x[i];
            int j = i-1;
            while (j >=0 && x[j] > key) {
                x[j+1] = x[j];
                j--;
            }
            x[j+1]= key;
        }
        return x;
    }
    public static int[] binaryinsertionsort(int[] x) {
        int n = x.length;
        for (int i=1;i <n;i++) {
            int key = x[i];
            int j = Math.abs(Arrays.binarySearch(x,0,i,key) +1);
            System.arraycopy(x,j,x,j+1,i-j);
            x[j]= key;
        }
        return x;
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static int[] quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static int[] mergesort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
    static void printArray(String method,int arr[])
    {
        int n = arr.length;
        System.out.print(method);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static void printArray(String method,List<String> arr)
    {
        int n = arr.size();
        System.out.print(method);
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
    static void printResults(String method,String result) {
        System.out.print(method);
        System.out.print(result);
        System.out.println();
    }
    static void printResults(String method,int result) {
        System.out.print(method);
        System.out.print(result);
        System.out.println();
    }
    static int closest_sum(int[] arr, int target) {
        int i=0;
        int sum=0;
        int[] summarray = new int[arr.length -2];
        int diff=0;
        int k=1;
        int min=0;
        while (i < summarray.length) {
            for (int j=i;j < i+3;j++) {
                sum+=arr[j];

            }
            summarray[i] = sum - target;
            sum=0;
            i++;
        }
        diff = summarray[0];
        min= Math.min(Math.abs(summarray[1]),Math.abs(summarray[2]));
        min = Math.min(min,Math.abs(diff));
        for (int o=0;o<summarray.length;o++)
            if (summarray[o] > 0)
                return Math.abs(min + target);
        return Math.abs(min-target);
    }
    //Function to rotate array arr by "rotate" positions
    //arr = {1,2,3,4,5,6,7}
    //Rotate by 2 produces the output :
    // arr = {3,4,5,6,7,1,2}
    //Algo :
    //1.Define a rotation Swap array and create a sub array from arr.
    //2.Move 2 elements from the right to the left and use the Swap array
    // to move it to the right.
    static int[] rotateArray(int[] arr,int rotate) {
        int shiftcnt =0;
        int[] swaparr = new int[rotate];
        for (int j=0;j <rotate;j++)
            swaparr[j] = arr[j];
        while (shiftcnt < rotate){
            for ( int i =0; i< arr.length-1;i++){
                arr[i] = arr[i+1];
            }
            shiftcnt++;
        }
        for (int j=arr.length-rotate;j <arr.length;j++)
            arr[j] = swaparr[j-(arr.length-rotate)];
        return arr;
    }
    static void get_K_Occurrences(String blob,int k) {
        //Blob = "Call me when you get me and when you call remember me and of course you don't get it really well"
        //k = 12
        //me 3
        //you 3
        //and 2
        //call 2
        //when 2
        //course 1
        //don't 1
        //get 1
        //of 1
        //it 1
        //really
        //remember 1
        int ocurrcounter =0;
        Map<String, Integer> count = new TreeMap<String, Integer>();
        String[] words = blob.toLowerCase().split(" ");
        Arrays.sort(words);
        for (String word : words) {
            count.put(word,count.getOrDefault(word,0) +1);
        }
        count  = sortByValues(count);
        //System.out.println("Count Array:" +count.entrySet().stream().findAny());
        System.out.println(count);
        Set sortedwords = count.entrySet();
        Iterator it = sortedwords.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            ocurrcounter+=(int)me.getValue();
            if (ocurrcounter <= k) {
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        }
    }
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };
        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
    static List<String> get_K_Occurrences_Priority_Queue(String blob,int k) {
        String[] words = blob.split(" ");
        List<String> result = new ArrayList<String>();
        Map<String,wordoccurrence>  wordcount = new HashMap< String,wordoccurrence>();
        for (String word : words) {
            if (!wordcount.containsKey(word))
                wordcount.put(word,new wordoccurrence(word));
            else
                wordcount.get(word).inc();
        }
        Queue<wordoccurrence> wordqueue = new PriorityQueue<>(new Comparator<wordoccurrence>(){
            @Override
            public int compare(wordoccurrence a,wordoccurrence b) {
                int result = b.occurrence - a.occurrence;
                if (result==0)
                    return a.word.compareTo(b.word);
                return result;
            }
        });
        for (Map.Entry<String,wordoccurrence> entry:wordcount.entrySet()) {
            wordqueue.offer(entry.getValue());
        }
        for (int i=0;i <k;i++)
            result.add(wordqueue.poll().word);
        return result;
    }
    public static void main(String[] args) {

        /*
        int j;
        int i[] = {10, 11, 12, 21, 22, 23, 31, 32, 33};
        for (j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
         */
            for (int k=1;k < (returnmyHash().size() +1);k++) {
                System.out.println(returnmyHash().get(k));
            }
            System.out.println(reverseString("Subbu now is the time to get your act together"));
            System.out.println(checkIfPrime(17));
            for (int k = 0;k < splitStrings("abcde",2).length;k++) {
                System.out.println(splitStrings("abcde",2)[k]);
            }
            int[] intnumbers = {0,1,2,3,4,5,6,7,8,9};
            printResults("Create Phone numbers: ",createphonenumbers(intnumbers));
            String[] likesarray = {"Peter","Jacob","Alex","Max","John","Mark"};
            printResults("Likes Result: ",whoLikesIt(likesarray));
            printResults("Mask Credit card: ",maskCreditCard("1234567890123466"));
            printResults("Next Square: ",findNextSquare(145));
            printResults("Bit Counting result: ",bitCounting(8));
            int [] nums = {2,2,1,1,3};
            printResults("Single number result: ",singlenumber(nums));
            printResults("Sum result: ",sum("1+7"));
            System.out.println("Power method result : " + pow(10,5));
            int [] sortinput1 = {9,8,7,6,5,4,3,2,1};
            printArray("Bubble sort:",bubblesort(sortinput1));
            int [] sortinput2 = {7,6,2,1,3,4,5,9};
            printArray("Insertion Sort: ",insertionsort(sortinput2));
            int [] sortinput3 = {7,6,7,8,8,4,5,9};
            printArray("Get Duplicates : ",duplicatearray(sortinput3));
            int [] sortinput4 = {9,1,2,3,4,6,7};
            printArray("Binary Insertion sort : ",binaryinsertionsort(sortinput4));
            int [] sortinput5 = {9,1,2,3,4,6,7};
            printArray("Quick sort : ",quickSort(sortinput5,0,sortinput5.length-1));
            int [] sortinput6 = {9,1,2,3,4,6,7};
            printArray("Merge Sort: ",mergesort(sortinput6,0,sortinput6.length-1));
            int [] sortinput7 = {1,2,1,1,3};
            printResults("Sum that is closest to target: ",closest_sum(sortinput7,7));
            int[] sortinput8 = {1,2,3,4,5,6,7,8};
            printArray("Array Rotation Result:",rotateArray(sortinput8,3));
            get_K_Occurrences("Call me when you get me and when you call remember me and of course you don't get it really well",12);
            //printArray("Get K Occurences with a Priority Queue: ",get_K_Occurrences_Priority_Queue("Call me when you get me and when you call remember me and of course you don't get it really well",5));
        }
    }
class wordoccurrence {
    String word;
    Integer occurrence;
    wordoccurrence(String word) {
        this.occurrence =1;
        this.word = word;
    }
    void inc() {
        occurrence++;
    }
}