/* 题目简单介绍
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

public class ReadNCharactersGivenRead4II  extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int j = 0, lastIn = 0;
    int times = 0;
    char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        /*
        for (; j < lastIn; ) {
            buf[count++] = tmp[j++];
            if (--n == 0) //会有read 0的问题；
                break;
        }*/
        
        int rf = Math.min(n, lastIn - j);
        for (int i = 0; i < rf; i++)
            buf[count++] = tmp[j++];
        n -= rf;
        
        while (n > 0) {
            lastIn = read4(tmp);
            j = Math.min(n, lastIn);
            for (int i = 0; i < j; i++) {
                buf[count++] = tmp[i];
            }
            if (j < 4)
                break;
            n -= 4;
        }
        return count;
    }
}