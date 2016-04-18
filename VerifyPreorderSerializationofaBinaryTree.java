public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String[] nodes = preorder.split(",");
        Queue<String> queue = new LinkedList(Arrays.asList(nodes));
        boolean visited = visit(queue);
        return visited && queue.size() == 0;
    }
    private boolean visit(Queue<String> queue) {
        if (queue.size() == 0)
            return false;
        String now = queue.poll();
        if (now.equals("#"))
            return true;
        else {
            return visit(queue) && visit(queue);
        }
        
    }
}