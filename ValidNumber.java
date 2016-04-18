public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        s = s.trim();
        return s.matches("[+-]?((\\d*\\.?\\d+)|(\\d+\\.?\\d*))([eE][+-]?\\d+)?");
    }
}
