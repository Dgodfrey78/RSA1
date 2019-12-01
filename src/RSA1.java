
//Daniel Godfrey

/*RSA1 is an simple implementation of an RSA encryption/decryption
algorithm. While this program demonstrates the process that takes place
in the RSA algorithm it is not an application for secure communication.
Instead the program simply prompts the user for a String which will be
encrypted into bytes then displayed, then decrypted and the original
string is then displayed.
 */

import java.io.*;
import java.math.*;
import java.util.*;


public class RSA1 {
    private int bits=1024;
    private final static BigInteger one = new BigInteger("1");

    // Random number for the creation of q and p
    private Random rand;

    private BigInteger q,p,n,phi,e,d;

    public RSA1(){

        rand = new Random();

        //probablePrime is accurate enough in this context to be reliable
        q=BigInteger.probablePrime(bits,rand);
        p=BigInteger.probablePrime(bits,rand);

        //n is equal to the product of the two primes found
        n = p.multiply(q);

        //phi=(p-1)(q-1)
        phi = p.subtract(one).multiply(q.subtract(one));

        //while loop searches for a suitable e value that is
        //coprime to phi and less than phi

        e=BigInteger.probablePrime(bits/2,rand);
        while (phi.gcd(e).compareTo(one)>0 && e.compareTo(phi)<0){
            e.add(one);
        }

        //find private key compenent (d) using modInverse
        d=e.modInverse(phi);


    }
    public byte[] encrypt(String message){
        //convert string into bytes
        byte[] messBytes=message.getBytes();

        //encrypt an by casting the messBytes to an Integer then
        //find messBytes^e mod n
        return (new BigInteger(messBytes)).modPow(e,n).toByteArray();

    }
    public String decrypt(byte[] enMess){

        //decrypt message by using private key (d) and the same mod operation
        byte[] deMess = (new BigInteger(enMess)).modPow(d,n).toByteArray();
        String mess=  new String(deMess);
        return mess;
    }

    //conv a Byte Array into a String
    public static String byteConv(byte[] enMess){
        String message="";

        //loops through individual bytes to convert each to String
        for(byte i: enMess){
            message+=Byte.toString(i);
        }
        return message;
    }


    public void RSAMessage() throws IOException{
        DataInputStream userInput = new DataInputStream(System.in);

        String input;

        //prompt the user for a input string
        System.out.println("Input message to be encrypted: ");
        input = userInput.readLine();

        //encryption stage
        byte[] enMess = this.encrypt(input);

        //display the encrypted Bytes
        System.out.println("Encrypted Message in bytes: " + this.byteConv(enMess));

        //decryption stage
        String deMess=this.decrypt(enMess);
        System.out.println("Here's Your Original Message: "+ deMess);

    }


    public static void main(String args[]) throws IOException{
        RSA1 rsa1 = new RSA1();
        boolean isRunning = true;

        while(isRunning=true){
            rsa1.RSAMessage();


        }

    }

}
