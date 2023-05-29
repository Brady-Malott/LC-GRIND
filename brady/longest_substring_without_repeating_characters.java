class Solution {
  
    // O(n) time, O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int l = 0;
        Set<Character> charsSeen = new HashSet<>();
        charsSeen.add(s.charAt(l));
        int longest = 1;

        for (int r = 1; r < s.length(); ++r) {
            if (charsSeen.contains(s.charAt(r))) {
                // If the letter is the first duplicate in the substring, compare this substring's length, move the
                // substring start index (l) to after the first occurrence of the duplicated character, and empty the set
                longest = Math.max(longest, r-l);

                while (s.charAt(l) != s.charAt(r)) {
                    charsSeen.remove(s.charAt(l));
                    ++l;                   
                } 
                ++l;
            } else if (r == s.length()-1) {
                longest = Math.max(longest, s.length()-l);
            } else {
                charsSeen.add(s.charAt(r));
            }
        }

        return longest;
    }
}
