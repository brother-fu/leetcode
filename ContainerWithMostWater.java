public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int max = Integer.MIN_VALUE;
        int len = height.length;
        int i = 0, j = len - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i]); //这里的宽度稍微注意一下！
                i++;
            } else {
                max = Math.max(max, (j - i) * height[j]);
                j--;
            }
        }
        return max;
    }
}