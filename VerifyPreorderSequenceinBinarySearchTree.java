public class VerifyPreorderSequenceinBinarySearchTree{
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) return false;
            while (!stack.empty() && stack.peek() < num)
                 min = stack.pop();
            stack.push(num);
        }
        return true;
    }
}