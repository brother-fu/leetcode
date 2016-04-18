public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) return 0; //0的时候是0
        if (n == 1) return 1;
        int[] steps = new int[n + 1];
        steps[1] = 1; steps[2] = 2;
        for (int i = 3; i <= n; i++)
            steps[i] = steps[i - 1] + steps[i - 2];
        return steps[n];
    }
}