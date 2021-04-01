/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomconvert;
import java.util.Scanner;
/**
 *
 * @author MELİSA
 */
public class RandomConvert {
 public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here,
        
        
        Scanner input = new Scanner(System.in);
         System.out.println("Write an input");
         String line = input.nextLine();
         System.out.println(line.toLowerCase());
       
         
        int number1= (int)(Math.random() * 26);
        int number2= (int)(Math.random() * 26);
        
       // System.out.println("1st" +AlPHABET[number1]);
    }
    
}
