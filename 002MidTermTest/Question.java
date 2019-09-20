
/**
 * Question object is intended to ask operator questions and randomize order
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 

public class Question
{
    // instance variables - replace the example below with your own
    String question, choiceA, choiceB, choiceC, choiceD, choiceE;
    String answer;
    
    char answerA='A', answerB='B', answerC='C', answerD='D', answerE='E';
    char answerKey;
    
    public Question(){
        
    }
    
    public Question(String chA, String chB, String chC, String chD, String chE, String quest, char ans){
     choiceA = chA;
     choiceB = chB;
     choiceC = chC;
     choiceD = chD;
     choiceE = chE;
     question = quest;
     answerKey = ans;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean getAnswer()
    {
        char choice;
        Scanner sc;
        
        // Implement this to randomize order
        System.out.println(question);
        System.out.println("A. " + choiceA );
        System.out.println("B. " + choiceB );
        System.out.println("C. " + choiceC );
        System.out.println("D. " + choiceD );
        System.out.println("E. " + choiceE );
        
        // IO logic of getting answer from console
        do {
            System.out.print ("Enter selection (A-E) --> ");
            sc = new Scanner(System.in);                                // Input from keyboard
            choice = Character.toUpperCase((char) sc.next().charAt(0)); // Convert to upper case
            if (choice >= 'A' && choice <= 'E') break;
            System.out.println(" (invalid) ");
        } while ( true );                                               // until valid input
        
        if (choice == answerKey) System.out.print("(correct) ");
        else System.out.print("(missed it!) ");
        System.out.println(answer);
        System.out.println();
        
        /*Boolean ansStatus = (choice == answerKey);
        calcResult(ansStatus)
        return ansStatus;*/
        return (choice == answerKey);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void calcResult(boolean ansCorrect)
    {
        /*
        // getAnswer return true if question is correct
        if (ansCorrect)
            correct++;
        questions++;
        System.out.println("Tally " + correct + " / " + questions );
        */
    }

}
