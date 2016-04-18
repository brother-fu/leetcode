public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length;) {
            balance += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (balance < 0) {
                balance = 0;
                start = i + 1;
            }
            i++;
        }
        if (total < 0 /*|| start >= gas.length*/) return -1;
        return start;
    }
}