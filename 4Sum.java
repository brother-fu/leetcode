public class 4Sum {
    /*// n^2 algorithm
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++)  {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i); list.add(j);
                int tmp = nums[i] + nums[j];
                if (! map.containsKey(tmp)) {
                    map.put(tmp, new ArrayList<List<Integer>>());
                }
                map.get(tmp).add(list);
            }
        }
        
        //traverse through the answers;
        for (Integer key : map.keySet()) {
            if (map.containsKey(target - key)) {
                getAns(ans, map.get(key), map.get(target - key));
            }
        }
        return ans;
    }
    private void getAns(List<List<Integer>> ans, List<List<Integer>> list1, List<List<Integer>> list2) {
        for (List<Integer> node1 : list1) {
            List<Integer> s = new ArrayList<Integer>(node1);
            for (List<Integer> node2 : list2) {
                if (!s.contains(node2.get(0)) && !s.contains(node2.get(1))) {
                    s.add(node2.get(0)); s.add(node2.get(1)); 
                    Collections.sort(s);
                    ans.add(s);
                }
            }
        }
    }
    */
        public List<List<Integer>> fourSum(int[] num, int target) {
        /* your code */
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4){
            return ans;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length -3; i++){
            if (i != 0 && num[i] == num[i - 1]){
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++){
                if (j != i + 1 && num[j] == num[j - 1]){ //j != i + 1
                    continue;
                }
                
                for (int left = j + 1, right = num.length - 1; left < right;){
                    int tmp = num[i] + num[j] + num[left] + num[right];
                    if (tmp < target)
                        left++;
                    else if (tmp > target){
                        right--;
                    }else {
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(num[i]);
                        al.add(num[j]);
                        al.add(num[left]);
                        al.add(num[right]);
                        ans.add(al);
                        left++;
                        right--;
                        while(left < right && num[left] == num[left - 1])
                            left++;
                        while(left < right && num[right] == num[right + 1])
                            right--;
                    }
                }
                 
            }
        }
        
        return ans;
    }
    /* try n^3 algorithm
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
    }
    */
}