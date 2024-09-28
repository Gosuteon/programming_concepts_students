package basics;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        int O = 0;
        int count = 0;
        char[] mot = str.toCharArray();
        while (O != mot.length){
            if (mot[O] == delimiter){
                count += 1;
            }
            O += 1;
        }
        String[] finale = new String[count+1];
        count = 0;
        finale[0] ="";
        for(int i = 0; i<mot.length;i++){
            if (mot[i] == delimiter){
                count += 1;
                finale[count] = "";
            }
            else {
                finale[count] += mot[i];
                System.out.println(finale[count]);
            }
        }
        return finale;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        int i = str.indexOf(sub);
         return i;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
        String retou = str.toLowerCase();
         return retou;
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        char[] mot = str.toCharArray();
        boolean test = true;
        for (int i=0; i<str.length()-1;i++){
            if (mot[i] == mot[str.length()-i-1]){
                test = true;
            }
            else{
                test = false;
            }
        }
         return test;
    }




}