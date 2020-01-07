package com.company;

import java.io.IOException;

public class kk2 {

    void kk2() {
        Fileio io = new Fileio();
        byte[] inText = new byte[1000];
        try {
            inText = io.fileRead("C:\\Users\\TranXuan\\Desktop\\Test.txt");
        } catch (
                IOException ex) {
            System.out.println("File: Read Error...");
        }
        String myString = new String(inText); // conversion from byteArray to String
        System.out.println(myString);

        // converted byte array of our String into int array
        /**
         * converting the byte array (inText) into a int array
         */
        int k2[] = new int[inText.length];
        for (int i = 0; i < inText.length; i++) {
            k2[i] = inText[i] / 20;
        }
        System.out.println("before encryption");
        for (int i = 0; i < inText.length; i++) {
            System.out.print(k2[i]);
        }
        // encrypt every section of our int array
        /**
         * encrypting every position k1[i] of out int array
         */
        for (int i = 0; i < inText.length; i++) {
            k2[i] = io.encrypt(k2[i]);
        }

        System.out.println("\nEncryption");
        // converted our int array into a String
        /**
         * converting our int array into a String by using the Stringbuilder
         */
        StringBuilder kk1 = new StringBuilder();
        if (k2.length > 0) {
            kk1.append(k2[0]);
            for (int i = 1; i < k2.length; i++) {
                kk1.append(k2[i]);
            }
        }
        //convert our Stringbuilder to String
        /**
         * converting our Stringbuilder to String with .toString command
         */
        String string = kk1.toString();
        io.fileWrite("C:\\Users\\TranXuan\\Desktop\\Test3.txt", string.getBytes());
        //print our encrypted string
        System.out.println(kk1);

        /**
         * just to activate decryption
         */
        int l = 1;
        if (l == 1) {
            //read file to decrypt
            /**
             * read our file for our decryption
             */
            byte[] inText1 = new byte[1000];
            try {
                inText1 = io.fileRead("C:\\Users\\TranXuan\\Desktop\\Test.txt");
            } catch (IOException ex) {
                System.out.println("File: Read Error...");
            }
            String myString1 = new String(inText1); // conversion from byteArray to String

            /**
             * decryption is happening
             */
            System.out.println("Decryption");
            for (int i = 0; i < inText1.length; i++) {
                System.out.print(io.decrypt(k2[i]));
            }


        }
    }
}
