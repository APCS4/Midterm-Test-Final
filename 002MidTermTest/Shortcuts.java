
/**
 * Write a description of class Shortcuts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shortcuts
{
    public static boolean checkRange(int min, int max, int x) {
    if(x >= min && x<=max) {
        return true; 
    } 
    else {
    return false;    }
    
    }
    
    public static void displayLine() {
       
        System.out.println("\n-----------------------------------------\n");
        
        
    }
    
    public static void clearScreen(){
     System.out.print('\u000C');
    }
}
