package com.amaresh.google;

import java.io.InputStream;

public class MyBytesReader {
    InputStream in;
    
    public MyBytesReader(InputStream in) {
        this.in = in;
    }

    public int read4kb() {
        //reads 4kb from a stream
        return 4096;
    }
    
    public int read() {
        return 1;
    }
    
    /**
     * uses read4kb
     * returns the number of bytes read
     * 
     * @param n number of bytes to read at one time
     * @param in input stream
     * @return number of bytes read
     * 
     */
    public int readNbytes(int n) {
        int bytesRead = 0;
        while(read4kb() != 0) {
            bytesRead += 4096;
        }
        //some bytes (1 to 4095) are still left in the stream
        boolean empty = false;
        while( !empty ) {
            int i = 0;
            for(i=0; i<n; i++) {
                if(read() == -1) {
                    empty = true;
                    break;
                }
            }
            if(i == n) {
                bytesRead += n;
            }
        }
        return bytesRead;
    }
}
