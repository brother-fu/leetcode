/*
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
*/

public class RomantoInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>(){{put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100); put('D', 500) ;put('M', 1000);}};
        
        int result = 0;
        int bit = 0;
        for (int i = 0; i < s.length(); i++){
            bit = mp.get(s.charAt(i));
            if (i < s.length() - 1 && bit < mp.get(s.charAt(i + 1)))
                bit = -1 * bit;
            result += bit;
        }
        return result;
    }
}