class Solution {
  
    // O(n) time, O(n) space
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);

        int longest = 0;
        
        for (int num : nums) {
            if (set.contains(num-1)) continue;

            int length = 0;
            while (set.contains(num+length)) {
                ++length;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
