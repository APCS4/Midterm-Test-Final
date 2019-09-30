







import java.util.*;
/**
 * MidTermTest is intended to teach Object Oriented Methodology, the JAVA language,
 * Computer Science principles, and Agile project methodolgy while be very active
 * in coding.  Here are some additional guidelines to the project... 
 * 
 *      i)      While running MidTermTest it is executing and evaluating language proficiency
 *              of Tester
 *      ii)     While coding MidTermTest we are learning detail syntax and semantics of Java
 *      iii)    MidTermTest is dependent on class heirarchy (ie Question) as you enhance
 *              the MidTermTest project it will assist in learning JAVA coding and methodology
 *      iv)     MidTermTest will be built in class as a part of a 6 week project 
 *      v)      MidTermTest project members will look to bring applicable labs and lectures into 
 *              alway with the intention of minimizing hard coding and have execution interpret 
 *              correct and incorrect answeres
 *      vi)     MidTermTest can be extended by any class member as long as they follow class 
 *              project guidelines and version control protocol
 *      vi)     MidTermTest will contain capability to  be run in abbreviated or comprehensive 
 *              test formats
 *      vii)    MidTermTest will calculate question attempted, questions answered correctly and 
 *              save results
 *      viii)   MidTermTest will randomize test execution and problem execution to ensure learing
 *              is thorough, versus simple memorizing the answers
 *
 * @authors John Mortensen
 * @version 1.0
 * @created    August 29, 2019
 */
public class MidTermTest
{
    
  static Scanner sc = new Scanner(System.in);  
  
  int correct = 0;
  int questions = 0;
  static int counter = 0; 
  /**
   *  The main program for the MidTerm class
   *
   * @param  args  The command line arguments
   */
  public static void main(String[] args)
  {
     // BlueJ clear console command
     Shortcuts.clearScreen(); 
     
     // MathOpFun is Class that askQuestions about Math Operators
     
     runMenu(); 
     
     
    }
    
    private static void runMenu() {
     int runNumber = 0;
        infiniteLoop: 
    for(;;) {
    displayMenu();
    runNumber = Shortcuts.getInt(0,counter);
    Shortcuts.clearScreen();
    
    switch(runNumber) {
    case 0:
    System.out.println("Running MathOps Fun ");
    MathOpsFun math = new MathOpsFun();
    math.askQuestion(); 
    break; 
    
    case 1:
    System.out.println("Running BinaryMath");
    BinaryMath bmath = new BinaryMath(); 
    bmath.askQuestion(); 
    break; 
    
    case 2:
    System.out.println("Exiting...");
    break infiniteLoop;
    
    default: 
    System.out.println("This is not valid. Please try again"); 
    }    
    
    //sc.nextLine();
    sc.nextLine(); //Needs to be called twice in order to function properly
    } 
    
    }
    
    private static void displayMenu() {
        counter = 0; 
        Shortcuts.clearScreen(); 
        
        System.out.println("Which test would you like to take?");
        Shortcuts.displayLine(); 
        System.out.println(counter + ". MathOps Fun"); 
        counter++;
        System.out.println(counter + ". Binary Math"); 
        counter++; 
        System.out.println(counter + ". Exit");
    }
}

