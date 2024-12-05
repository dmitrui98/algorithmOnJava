package course.leetcode.TopInterview150;

/**
 * 58. Length of Last Word
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */
public class A12_LengthOfLastWord {

    public static void main(String[] args) {
        new A12_LengthOfLastWord().go();
    }

    private void go() {
        String s;
        int result;

        s = "Hello World";
        result = lengthOfLastWord(s);
        assert result == 5;

        s = "   fly me   to   the moon  ";
        result = lengthOfLastWord(s);
        assert result == 4;

        s = "luffy is still joyboy";
        result = lengthOfLastWord(s);
        assert result == 6;
    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0) {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
