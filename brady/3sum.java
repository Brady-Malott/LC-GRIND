class Solution {
  
    // O(n^2) time, O(n^3) space (n^3 space is all because of the solution list, where there can be n choose 3 = n(n-1)(n-2)/6 possible triplets in the worst case)
    public List<List<Integer>> threeSum(int[] nums) {
        // Strategy: sort the array, then reduce to two sum by using the negative of the leftmost value as the target
        // for the first iteration, then moving the target index to the negative of the next element for each iteration
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length-2; ++i) {
            // If this target value is the same as that of the previous iteration, skip this iteration so we don't get
            // duplicates
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1;
            int r = nums.length-1;
            
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    triplets.add(List.of(nums[l], nums[r], nums[i]));

                    // Skip over duplicates
                    while (l != r && nums[l] == nums[l+1]) ++l;
                    while (l != r && nums[r] == nums[r-1]) --r;

                    // Now move to the next distinct elements
                    ++l;
                    --r;
                } else if (nums[l] + nums[r] < -nums[i]) {
                    ++l;
                } else {
                    --r;
                }
            }
        }

        return triplets;
    }
}
