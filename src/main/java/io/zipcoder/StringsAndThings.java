package io.zipcoder;


import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        int totalCount = 0;
        String str = "";

        String[] arrOfStr = input.split(" ");

        for (int i = 0; i< arrOfStr.length; i++){
                str = arrOfStr[i];
            for(int j = 0; j< str.length(); j++);{
                  if((str.charAt(str.length()-1)=='y')||(str.charAt(str.length()-1)=='z'))
                    totalCount++;
            }
        }
        return totalCount;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        String[] arrOfStr = base.split(" ");
        StringJoiner joiner = new StringJoiner(" ");

        for(int i = 0; i< arrOfStr.length; i++)
        {
            arrOfStr[i] = arrOfStr[i].replace(remove, "");
            joiner.add(arrOfStr[i]);
        }
        String joined = joiner.toString();

        return joined;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCount = 0;
        int notCount = 0;

        Pattern isPattern = Pattern.compile("is");
        Pattern notPattern = Pattern.compile("not");

        String[] arrOfStr = input.split(" ");

        for (int i = 0; i< arrOfStr.length; i++) {
            Matcher isMatcher = isPattern.matcher(arrOfStr[i]);
            Matcher notMatcher = notPattern.matcher(arrOfStr[i]);
             while(isMatcher.find())
                 isCount++;
             while(notMatcher.find())
                 notCount++;

        }
        if(isCount!=notCount)
            return false;
        else
            return true;
    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        int gCount = 0;

        Pattern gPattern = Pattern.compile("gg");

            Matcher gMatcher = gPattern.matcher(input);

            while(gMatcher.find())
                gCount++;

        if(gCount==1)
            return true;
        else
            return false;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
       int len = input.length();
       int count = 0;

       for(int i = 0; i< len-2; i++){
           char tmp = input.charAt(i);
           if(tmp == input.charAt(i+1) && tmp == input.charAt(i+2))
               count++;
       }
     return count;
    }
}
