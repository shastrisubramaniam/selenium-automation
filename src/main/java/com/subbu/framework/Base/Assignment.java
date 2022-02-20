package com.subbu.framework.Base;

import java.util.Arrays;
import java.util.HashMap;

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
            System.out.println(createphonenumbers(intnumbers));
            String[] likesarray = {"Peter","Jacob","Alex","Max","John","Mark"};
            System.out.println(whoLikesIt(likesarray));
            System.out.println(maskCreditCard("1234567890123466"));
            System.out.println(findNextSquare(145));
    }
}
