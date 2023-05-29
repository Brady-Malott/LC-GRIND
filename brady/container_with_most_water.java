class Solution {
  
    // O(n) time, O(1) space
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;

        int maxArea = (r-l)*(Math.min(height[l], height[r]));
        while (l < r) {
            int tmp;
            if (height[l] < height[r]) {
                tmp = height[l];
                ++l;                
                while (height[l] < tmp) ++l;
            } else {
                tmp = height[r];
                --r;
                while (height[r] < tmp) --r;
            }
            maxArea = Math.max(maxArea, (r-l)*(Math.min(height[l], height[r])));
        }

        return maxArea;
    }
}
