public class isRepeatingCharacter {


    public static void main(String[] args) {

        String s = "BBBB";
        int sLength = s.length();
        if (sLength != 0) {

            char value = s.charAt(0);
            for (int i = 0; i <= sLength - 1; i++) {

                if (value != s.charAt(i)) {
                    System.out.println("false");
                    System.exit(0);
                }

            }
            System.out.println("true dawg");

        }
    }
}