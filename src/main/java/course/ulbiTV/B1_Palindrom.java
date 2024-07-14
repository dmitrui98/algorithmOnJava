package course.ulbiTV;

public class B1_Palindrom {

    public static void main(String[] args) {
        new B1_Palindrom().go();
    }

    private void go() {
        String s = "aabcbaa";
        System.out.println(s + ": " + isPalindrom(s));

        s = "aabab";
        System.out.println(s + ": " + isPalindrom(s));

        s = "aZazA";
        System.out.println(s + ": " + isPalindrom(s));
    }

    public boolean isPalindrom1(String word) {
        word = word.toLowerCase();
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrom(String word) {
        word = word.toLowerCase();
        return word.contentEquals(new StringBuilder(word).reverse());
    }
}
