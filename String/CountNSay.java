public class CountNSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }
    public static String countAndSay(int A) {
        String current = "1";

        for (int i=1; i<A; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            // iterate through the current string and generate new one
            for (int j=0; j<current.length(); j++) {
                // first character, or current character same as previous character
                if (j == 0 || current.charAt(j) == current.charAt(j-1)) {
                    count++;
                }
                // append to string sb
                else {
                    sb.append(count);
                    sb.append(current.charAt(j-1));
                    count = 1;
                }
            }

            // add last sequence to string
            sb.append(count);
            sb.append(current.charAt(current.length() - 1));

            // assign new string to current
            current = sb.toString();
        }

        return current;
    }
}