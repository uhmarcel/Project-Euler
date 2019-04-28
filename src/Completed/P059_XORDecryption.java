package Completed;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Problem No. 59 - XOR decryption */

public class P059_XORDecryption {

    public static final String INPUT_FILENAME = "src/input/input_p059.txt";
    public static final int KEY_LENGTH = 3;
    
    public static String encryptMsg(String msg, String key) {
        char[] out = new char[msg.length()];
        
        for (int i=0; i<msg.length(); i++) {
            out[i] = (char) (msg.charAt(i) ^ (key.charAt(i % key.length())));
        }
        return String.valueOf(out);
    }
        
    public static String getInput(String filename) throws Exception {
        Scanner s = new Scanner(new File(filename));
        String[] input = s.useDelimiter("\\A").next().replace("\n","").split(",");
        s.close();
        
        char[] parsed = new char[input.length];
        for (int i=0; i<input.length; i++) {
            parsed[i] = (char) Integer.parseInt(input[i]);
        }
        return String.valueOf(parsed);
    }
    
    public static char decryptKeyChar(char mostFrequent) {
        char c;
        for (c='a'; c<='z'; c++) {
            if ((mostFrequent ^ c) == ' ')
                break;
        }
        return c;
    }
    
    public static char getFrequencyOffset(String txt, int offset, int cycle) {
        Map<Character,Integer> ocurrance = new HashMap<>();
        char mostFrequentChar = '\0';
        int highestFrequency = 0;
        
        for (int i=offset; i<txt.length(); i+=cycle) {
            char current = txt.charAt(i);
            if (ocurrance.containsKey(current)) {
                int currentFrequency = ocurrance.get(current) + 1;
                ocurrance.put(current, currentFrequency);
                if (currentFrequency > highestFrequency) {
                    mostFrequentChar = current;
                    highestFrequency = currentFrequency;
                }
            }
            else
                ocurrance.put(current, 1);    
        }
        return mostFrequentChar;
    }
    
    public static String deriveKey(String msg, int keyLength) {
        char[] decrypted = new char[keyLength];
        for (int i=0; i<keyLength; i++) {
            decrypted[i] = decryptKeyChar(getFrequencyOffset(msg,i,keyLength));
        }
        return String.valueOf(decrypted);
    }
    
    
    public static void main(String[] args) throws Exception {
        String encrypted = getInput(INPUT_FILENAME);
        String key = deriveKey(encrypted, KEY_LENGTH);
        String decrypted = encryptMsg(encrypted, key);
        
        System.out.println("Encrypted message:");
        System.out.println(encrypted);
        System.out.println("Matching key found:");
        System.out.println(key);
        System.out.println("Decrypted message:");
        System.out.println(decrypted);
        
        int sum = 0;
        for (int i=0; i<decrypted.length(); i++)
            sum += decrypted.charAt(i);
        System.out.println("Sum of characters: " + sum);
        
    }
}
