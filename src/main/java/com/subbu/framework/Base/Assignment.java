package com.subbu.framework.Base;

import java.util.HashMap;

public class Assignment {
    public static HashMap returnmyHash() {
        HashMap hm = new HashMap();
        hm.put(1,"Subbu");
        hm.put(2,"Subramaniam");
        return hm;
    }
    public static String reverseString(String input) {
        char[] charinputarray = input.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i=charinputarray.length -1;i>= 0;i--) {
            str.append(charinputarray[i]);
        }
        return str.toString();
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
    }
}
