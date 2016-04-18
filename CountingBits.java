public class CountingBits {
    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        int base = 1;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) //shit， 顺序又记错了！
                base = i;
            rst[i] = rst[i - base] + 1;
        }
        return rst;
    }
}