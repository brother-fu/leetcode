class NQueensII {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper (ways, list, n);
        return ways.size();
    }
    private void helper(ArrayList<ArrayList<Integer>> ways,
                        ArrayList<Integer> list,
                        int cols
                        ) 
    {
        if (list.size() == cols) {
            ways.add(new ArrayList<Integer>(list));
            return;
        }
        for (int col = 0; col < cols; col++) {
            if (isValid(list, col)) {
                list.add(col);
                helper(ways, list, cols);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(ArrayList<Integer> list, int col) {
        int row = list.size();
        for(int i = 0; i < list.size(); i++) {
            if (i + list.get(i) == col + row) 
               return false;
        }
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) - i == col - row) 
               return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == col)
                return false;
        }
        return true;
    }
};


