package com.wesleyreisz.exercises;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class WordUtil
{
    //optimized for readibility
    public static boolean isPalindrome(String input){
        if(StringUtils.isEmpty(input)){
            return false;
        }
        input = sanitize(input);

        //check reversed string
        if (input.equalsIgnoreCase(reverse(input))){
            return true;
        }else{
            return false;
        }
    }

    private static String sanitize(String input) {
        //clean/sanitize input
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            if (Character.isAlphabetic(c)){
                sb.append(c);
            }
        }
        input = sb.toString();
        return input;
    }
    public static String reverse(String input){
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0;i--){
            sb.append((input.charAt(i)));
        }
        return sb.toString();
    }


    public static boolean isPalindromeDynamic(String input){

        if (input==null)
            return false;

        if (input.length()<=0)
            return false;

        input = sanitize(input);

        if (input.equalsIgnoreCase(dynamicReverse(input))){
            return true;
        }else{
            return false;
        }

    }
    public static String dynamicReverse(String input){
        char[] result = new char[input.length()];
        for (int i=0;i<input.length();i++){
            int arrayPostition = (input.length()-i)-1; //-1 handles offset from 0 based positioning
            result[arrayPostition]=input.charAt(i);
        }
        return String.valueOf(result);
    }
}
