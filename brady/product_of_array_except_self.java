class Solution {
  
    // O(n) time, O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        // Store the left side product of each num and the right side product of each num
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];

        // Calculate the left products
        leftProducts[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            leftProducts[i] = leftProducts[i-1] * nums[i-1];
        }

        // Calculate the right products
        rightProducts[rightProducts.length-1] = 1;
        for (int i = nums.length-2; i >= 0; --i) {
            rightProducts[i] = rightProducts[i+1] * nums[i+1];
        }

        for (int i = 0; i < answer.length; ++i) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }

        return answer;
    }
}
