
/**
 * Write a description of class Counting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Counting
{
    int correct;        // correct answers
    int questions;      // questions attempted
    /**
     * Constructor for objects of class Counting
     */
    public Counting()
    {
        // initialise instance variables
        correct = 0;
        questions = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void updateCounters(Boolean isCorrect)
    {
        if (isCorrect) 
            correct++;
        
        questions++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printCounters()
    {
        System.out.print("Results: ");
        System.out.print(correct);
        System.out.print(" of ");
        System.out.println(questions);
    }
}
