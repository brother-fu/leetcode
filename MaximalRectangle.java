public class MaximalRectangle {
    /*核心思想是用本层和上层的左右边界求现在的左右边界*/
    /*用能快速写成代码的思想重新组织下： 
     ＊ 以某一j高为高的矩形的左右边界， 不是用height来限制，
     ＊ 而是上一层与自己这一层的左右边界取交集；
    */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) 
            return 0;
        int row = matrix.length, col = matrix[0].length;
        int[] left = new int[col]; int[] right = new int[col]; int[] height = new int[col];
        Arrays.fill(right, col);
        int ans = 0;
        for (int i = 0; i < row; i++) {
            int curleft = 0, curright = col - 1;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') height[j]++; //height只对上负责
                else height[j] = 0;
            }
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(curleft, left[j]); // 上一层的left和这一层的left;
                else { left[j] = 0;  //设为0， 对下一层的left max(0，curleft) 不加限制
                      curleft = j + 1;  //设为j + 1, 对这一层剩余的点的boundary限制！
                    
                } // 这里要重复理解记忆下
            }
            for (int j = col - 1; j >= 0; j--) {//必须逆向来，你从左边过来不会知道右边的边界在哪里！
                if (matrix[i][j] == '1') right[j] = Math.min(curright, right[j]);
                else {
                    right[j] = col - 1;
                    curright = j - 1; 
                }
            }
            for (int j = 0; j < col; j++) {
               ans = Math.max((right[j] - left[j] + 1) * height[j], ans);
            }
        }
        return ans;
    }
}

//参考思路 https://leetcode.com/discuss/20240/share-my-dp-solution;
//通过left[], right[] boundary来限制height[]的有效性；
//当出现0时候，对于自己来说，left，right不影响了，因为高度为1；
//只是为了左右邻居通过max 求left boundary, 和 min求right boundary的时候不影响，用0， 和n来；
//最妙的是height[]只要对自己上面负责就行，！！！ 每个点计算顶上最高height的矩形面积！