package com.company;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static int e = 5;   //public key
    private static  int N = 21; //public key
    private static int d = 5;   //private key
    private static int h;

    public static void main(String[] args) throws IOException {
	// write your code here
        Fileio io = new Fileio();
        kk2 k2 = new kk2();


        /*String Text = "hall";


        io.fileWrite("C:\\Users\\TranXuan\\Desktop\\Test.txt", Text.getBytes());

         */


        byte[] inText = new byte[1000];
        try{
            inText = io.fileRead("C:\\Users\\TranXuan\\Desktop\\Test.txt");
        }catch(IOException ex){System.out.println("File: Read Error...");}
        String myString = new String(inText); // conversion from byteArray to String
        System.out.println(myString);

        // converted byte array of our String into int array
        /**
         * converting the byte array (inText) into a int array
         */
        int k1[] = new int[inText.length];
        for(int i=0;i<inText.length;i++){
            k1[i] = inText[i] % 20;
        }
        System.out.println("before encryption");
        for(int i=0;i<inText.length;i++){
            System.out.print(k1[i]);
        }
        // encrypt every section of our int array
        /**
         * encrypting every position k1[i] of out int array
         */
        for(int i=0;i<inText.length;i++){
            k1[i] = io.encrypt(k1[i]);
        }

        System.out.println("\nEncryption");
        // converted our int array into a String
        /**
         * converting our int array into a String by using the Stringbuilder
         */
        StringBuilder kk1 = new StringBuilder();
        if(k1.length>0){
            kk1.append(k1[0]);
            for(int i=1;i<k1.length;i++){
                kk1.append(k1[i]);
            }
        }
        //convert our Stringbuilder to String
        /**
         * converting our Stringbuilder to String with .toString command
         */
        String string = kk1.toString();
        io.fileWrite("C:\\Users\\TranXuan\\Desktop\\Test1.txt",string.getBytes());
        //print our encrypted string
        System.out.println(kk1);

        /**
         * just to activate decryption
         */
        int l = 1;
        if(l==1) {
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
                System.out.print(io.decrypt(k1[i]));
            }
            /**
             * kk1 is the String of bytes
             */
        }
        System.out.println("\n---------------------------------------\n\n");
        System.out.println("next Example\n");
        k2.kk2();

    }
    public static int encrypt(int k){
        int c = (int)(Math.pow(k,e)) % N;
        return c;
    }
    public static int decrypt(int c){
        int k = (int)(Math.pow(c,d)) % N;
        return k;
    }

}

    /**
     * Methoden importiert, sind nicht statisch, jetzt nur
     * noch herausfinden wie das funktioniert
     *
     * gerade herausgefunden wie das funktioniert
     * jetzt verschlüsselungen schreiben encrypt, decrypt.
     **/
