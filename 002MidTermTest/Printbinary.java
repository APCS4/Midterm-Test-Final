
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
        
    }

}
