
/**
 * Write a description of class Binary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Printbinary
{   
    String zeroPadToBinary(int arg, int binaryLength)
    
    {return Integer.toBinaryString((1<<binaryLength)| arg).substring(1);
    }   
 
   
    /**
     * Constructor for objects of class Binary
     */
    public Printbinary()
    {
        System.out.println(zeroPadToBinary(1,4));
        System.out.println(zeroPadToBinary(2,4));
        System.out.println(zeroPadToBinary(3,4));
        System.out.println(zeroPadToBinary(4,4));
    }

}
