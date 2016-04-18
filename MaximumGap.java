public class MaximumGap {
    /*try with both bucket sort and radix sort*/
    public int maximumGap(int[] nums) {
         long base = 1;
         int R = 10, max = 0, len = nums.length;
         int[] aux = new int[len];
         for (int num : nums) {
             max = Math.max(max, num);
         }
         // get maximal bit count;
         while (base <= max) { 
             int[] count = new int[R];
             for (int num : nums) {
                 int b = (int)(num / base % 10);
                 count[b]++;
             }
             int sum = 0;
             for (int i = 0; i < R; i++) {
                 sum += count[i];
                 count[i] = sum;
             }
             for (int i = len - 1; i >= 0; i--) { /*要逆向来*/
                 int b = (int)(nums[i] / base % 10);
                 aux[--count[b]] = nums[i];
             }
             int[] tmp = nums; /*这里转换要彻底，不然aux和num指向同一个区块*/
             nums = aux;
             aux = tmp;
             base *= 10;
         }
         int maxGap = 0;  
         for (int i = 0; i < len - 1; i++) {
             maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
         }
         return maxGap;
    }


    /*bucket sort*/
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //bucketLen 完全可以取1， 但是这样耗费的空间太大；
        //需要先获得数字的范围
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int countLen = Math.max((max - min) / 2 / nums.length, 1); //bucket Length
        int count = (max - min)/countLen + 1;  //这里要加1  {3,6,9} 得三个桶
        int[] maxB = new int[count];
        int[] minB= new int[count];
        Arrays.fill(maxB, Integer.MIN_VALUE);
        Arrays.fill(minB, Integer.MAX_VALUE);
        for (int i : nums) {
            maxB[(i - min)/countLen] = Math.max(maxB[(i - min)/countLen], i);
            minB[(i - min)/countLen] = Math.min(minB[(i - min)/countLen], i);
        }
        int ans = 0;
        int prev = maxB[0];   //第一个值始终有效
        for (int i = 1; i < count; i++) {
            if (maxB[i] == Integer.MIN_VALUE && minB[i] == Integer.MAX_VALUE)  //最小的格子必然放了数的；
                continue;
            ans = Math.max(minB[i] - prev, ans);
            prev = maxB[i];
            
        }
        return ans;
    }
}



/*36, try both radix sorting and bucket sorting*/
/*不敢相信，你上一次做这题是4个月以前;*/