# RSA1

Documentation

RSA1

RSA1 is a simple implementation of an RSA encryption/decryption algorithm. 
While this program demonstrates the process that takes place in the RSA 
algorithm it is not an application for secure communication. Instead the program 
simply prompts the user for a String which will be encrypted into bytes then 
displayed, then decrypted and the original string is then displayed.

A standard RSA algorithm is implemented in this program. I used the java math 
package to find a probable prime number to find the values of p and q. Given 
that the numbers have been reduced to only 1024 bits the likelihood of not getting 
a prime number is low. Phi is then derived from the p and q by subtracting 1 from
each then multiplying them. e is found by looping through until a coprime to phi is 
found that is less than phi. d is then found by using modInverse(e,phi).

Encrypt

A string message is passed to encrypt then converted to bytes. It then uses 
the public keys e and n to encrypt the message by finding the Inverse mod.

Decrypt

A byte array is passed to the decrypt method which uses the private key to to find 
the inverse mod. It then converts the byte array into a string and returns it.

RSAMessage

A simple use of the RSA1 the RSAMessage method simple take in a string, displays the 
converted byte array then converts it back to the original string.

Input

The user is asked to input a message in the form of a command line prompt. That message 
is taken then converted into an encrypted byte array.

Output

Once the message is converted into an encrypted byte array it is displayed onto the 
terminal window. Then the original message is redisplayed. The program repeats from the beginning.
