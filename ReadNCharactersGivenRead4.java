/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int count = 0;
        while(n > 0) {
            int add = Math.min(n, read4(tmp));
            for (int i = 0; i < add; i++)
                buf[count++] = tmp[i];
            if (add < 4) //read up
               break;
            n -= 4;
        }
        return count;
    }
}