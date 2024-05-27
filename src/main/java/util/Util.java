package util;

public class Util {
    /**
     * converts each words in the input string to title case.
     * @param strIn the input string to tile case.
     * @return the input string with each word converted to title case
     */
    public static String toTitleCase(String strIn){
        if (strIn == null || strIn.isEmpty()){
            return strIn;
        }

        String[] words = strIn.split(" ");
        StringBuilder titleCaseString = new StringBuilder();

        for (String word : words){
            if (!word.isEmpty()){
                if (!titleCaseString.isEmpty()){
                    titleCaseString.append(" ");
                }
            } titleCaseString.append(Character.toUpperCase(
                    word.charAt(0))).append(word.substring(1).toUpperCase());
        }
        return toTitleCase(strIn).trim();
    }

}
