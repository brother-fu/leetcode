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
}



/*36, try both radix sorting and bucket sorting*/
/*不敢相信，你上一次做这题是4个月以前;*/