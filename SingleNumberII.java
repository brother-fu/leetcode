public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int d = a;
            a = ~a&b&c | a&~b&~c;
            b = ~d&~b&c | ~d&b&~c;
        }
        return a | b;
    }
}