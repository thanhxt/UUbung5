package com.company;

import java.io.*;

public class Fileio {
    private static int e = 5;   //public key
    private static int N = 21; //public key
    private static int d = 5;   //private key

    byte[] fileRead(String fileName) throws IOException {
        File file = new File(fileName);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            //file is too large
            throw new IOException("File is too large");
        }

        // Creates an byte array to hold the data

        byte[] bytes = new byte[(int) length];

        //Read in the bytes
        int offset = 0;
        int numRead = 0;

        InputStream is = new FileInputStream(file);
        try {
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
        } finally {
            is.close();
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read the file" + file.getName());
        }

        return bytes;
    }

    void fileWrite(String fileName, byte[] buf) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
            fos.write(buf);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (Exception ex) {
                }
        }
    }

    int encrypt(int k) {
        int c = (int)(Math.pow(k,e)) % N;
        return c;
    }

    int decrypt(int c) {
        int k = (int) (Math.pow(c, d)) % N;
        return k;
    }
}

