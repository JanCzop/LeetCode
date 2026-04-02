import java.util.Arrays;
import java.util.HashMap;

public class LongestUniqueSubstring {
    // Array ver
    public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int start = 0;
    int[] lastIndex = new int[128];
    Arrays.fill(lastIndex, -1);
    
    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);

        if (lastIndex[currentChar] != -1) {
            start = Math.max(start, lastIndex[currentChar] + 1);
        }

        lastIndex[currentChar] = i;
        longestLength = Math.max(longestLength, i - start + 1);
    }

    return longestLength;
    }

    // HashMap ver
    public int lengthOfLongestSubstringMap(String s) {
        int longestLength = 0;
        int start = 0;
        HashMap<Character, Integer> charLastIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (charLastIdx.containsKey(currentChar)) {
                start = Math.max(start, charLastIdx.get(currentChar) + 1);
            }
            charLastIdx.put(currentChar, i);

            longestLength = Math.max(longestLength, i - start + 1);    
        }

        return longestLength;
    }
    
}
