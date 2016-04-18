public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] levels = path.replaceAll("\\/+", "/").split("\\/");
        Stack<String> stack = new Stack<String>();
        for (String level : levels) {
            if (level.equals(".") || level.equals(""))
               continue;
            else if (level.equals("..")) {
                if (!stack.empty()) 
                   stack.pop();
                //else return "/";
            } else {
                stack.push(level);
            }
        }
        if (stack.empty())
           return "/";
        String ans = "";
        for (String level : stack) {
            ans = ans + "/" + level;
        }
        return ans;
    }
}