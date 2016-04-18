public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int couple = 0;
        int[] rst = new int[2];
        for (int num : nums)
            couple ^= num;
        //divide by first 1 bit;
        int base = 1;
        while ((couple & base) == 0)
            base <<= 1;
        int tmp = couple;
        for (int num : nums) {
            if ((num & base) == base)
                couple ^= num;
        }
        rst[0] = couple;
        rst[1] = tmp ^ couple;
        return rst;
    }
}