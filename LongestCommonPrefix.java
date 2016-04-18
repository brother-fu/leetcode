public String longestCommonPrefix(String[] strs) {
    int n=strs.length;
    if(n==0) return "";
    StringBuilder st=new StringBuilder(strs[0]);
    for(int i=1;i<n;i++){
        while(!strs[i].startsWith(st.toString())) st.deleteCharAt(st.length()-1);
    }
    return st.toString();
}

/*https://leetcode.com/discuss/84267/my-6-lines-java-solution-90%25*/