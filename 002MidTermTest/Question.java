
/**
 * Question object is intended to ask operator questions and randomize order
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
import java.util.Random;

public class Question
{
    // instance variables - replace the example below with your own
    String question, choiceA, choiceB, choiceC, choiceD, choiceE;
    String answer;
    
    char answerA='A', answerB='B', answerC='C', answerD='D', answerE='E';
    char answerKey;
    String tfAnswerKey;
    String type = "mc";
    String answerOrder[] = {"", "", "", "", ""};
    
    //Prevents errors if no parameters are sent
    public Question(){
        choiceA = "Error: Choice not loaded";
        choiceB = "Error: Choice not loaded";
        choiceC = "Error: Choice not loaded";
        choiceD = "Error: Choice not loaded";
        choiceE = "Error: Choice not loaded";
        question = "Error: Qustion not loaded";
        answerKey = 'x';
        
    }
    
    //Constructor for creating a 5 choice (A-E) multiple choice question
    public Question(String chA, String chB, String chC, String chD, String chE, String quest, char ans){
     choiceA = chA;
     choiceB = chB;
     choiceC = chC;
     choiceD = chD;
     choiceE = chE;
     question = quest;
     answerKey = ans;
     type = "mc";
    }
    
    //Constructor for making a True/False question
    public Question(String quest, String ans){
        question = quest;
        tfAnswerKey = ans;
        type = "tf";
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public boolean getAnswer()
    {
        char choice = 'x';
        String tfChoice = "x";
        Scanner sc = null;
        switch(type){
            case "mc":
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
                break;
            case "tf":
                System.out.println(question);
                System.out.println("True");
                System.out.println("False");
                
                do{
                    System.out.print("Enter selection (True/False) --> ");
                    sc = new Scanner(System.in);
                    tfChoice = sc.nextLine();
                    tfChoice = tfChoice.toUpperCase();
                    if(tfChoice.equals("TRUE") || tfChoice.equals("FALSE")){
                        break;
                    }
                    System.out.println(" (invalid) ");
                }while( true );
                
                if(tfChoice.equalsIgnoreCase(tfAnswerKey)) System.out.print(" (correct) ");
                else System.out.print(" (missed it!) ");
                System.out.println(answer);
                System.out.println();
                break;
    }
    
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
