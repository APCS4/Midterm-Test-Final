import java.util.*; 
/**
 * Write a description of class Shortcuts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shortcuts
{
    private static Scanner sc = new Scanner(System.in); 
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
    
    public static int getInt(int min, int max) {
   
    boolean validAnswer = false; 
    int x = sc.nextInt(); 
    if(x >= min || x<=max) {
            validAnswer = true; 
        }
    
     while(validAnswer ==false) {
        System.out.println("Invalid answer"); 
       
        x = sc.nextInt();
        
        if(x >= min || x<=max) {
            validAnswer = true; 
        }
        }  
    
    return x; 
    
    }
}
