
/**
 * Write a description of class Binary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class BinaryMath
{   
    /**
     * Constructor for objects of class Binary
     */
    public BinaryMath()
    {
        
    }    
    
    public static void main(String[] args)
    {
        int nums[] = BinaryMath.getTwoRandomNumbers();
        System.out.println("1>" + nums[0] + " 2>" + nums[1]);
        System.out.println(BinaryMath.zeroPadToBinary(nums[0], 5));
    }
    
    static String zeroPadToBinary(int arg, int binaryLength)
    {
        return Integer.toBinaryString((1<<binaryLength)| arg).substring(1);
    }
    
    static public int[] getTwoRandomNumbers()
    {
        int args[];
        
        do{
            args = new Random().ints(1, 15).distinct().limit(2).toArray();
        } while (args[0] <= 1 || args[1] > args[0] || args[1] <= 1 || args[0] % args[1] != 0);

        return args;
    }
   


}
