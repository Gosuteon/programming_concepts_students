package basics;

public class PatternMatching {

    /**
     * Look for one sequence of characters (the pattern) in an input
     * string, and return the position of the pattern in the string
     * (if present). If the pattern is present multiple times in the
     * string, the function must return the leftmost occurrence of the
     * pattern (i.e. the occurrence whose index is the lowest). The
     * function must be case-sensitive (i.e. <code>Hello</code> is not
     * the same as <code>hello</code>).
     * @param pattern The pattern to look for.
     * @param value The string to look in.
     * @result The index of the leftmost occurrence of the pattern in
     * the string. Must be <code>-1</code> if the pattern is absent
     * from the string.
     **/
    public static int find(String pattern, String value) {
        int index = -1;
        int patternLength = pattern.length();
        int valueLength = value.length();
        // remove the indexes that are not possible
        for (int i = 0; i < valueLength - patternLength + 1; i++) {
            // use index + length to get the possible substring
            if (value.substring(i, i + patternLength).equals(pattern)) {
                return i;
            }
        }
        return index;
    }
}