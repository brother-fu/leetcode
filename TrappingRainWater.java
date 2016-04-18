public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int trap = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                maxLeft = Math.max(maxLeft, height[i]);
                trap += maxLeft - height[i];
                i++;
            } else {
                maxRight = Math.max(maxRight, height[j]);
                trap += maxRight - height[j];
                j--;
            }
        }
        return trap;
    }
}

//大神的思路： https://leetcode.com/discuss/16171/sharing-my-simple-c-code-o-n-time-o-1-space