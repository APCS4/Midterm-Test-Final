
/**
 * Write a description of class Counting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Counting
{
    int correct[];        // correct answers
    int questions[];      // questions attempted
    int i;
    /**
     * Constructor for objects of class Counting
     */
    public Counting()
    {
        // initialise arrays
        correct = new int[5];
        questions = new int[5];
    }

    public void updateCounters(Boolean isCorrect, int station)
    {
        switch (station)
        {
            case 1:     //Binary
                if (isCorrect)
                    correct[0]++;
                questions[0]++;
                break;
            case 2:     //Data Types
                if (isCorrect)
                    correct[1]++;
                questions[1]++;
                break;
            case 3:     //Control Flow
                if (isCorrect)
                    correct[2]++;
                questions[2]++;
                break;
            case 4:     //Assignment Binary Logic
                if (isCorrect)
                    correct[3]++;
                questions[3]++;
                break;
        }
    }

    public void printCounters()
    {
        System.out.println("Results:");
        for (i = 0; i <= 3; i++)
        {
            System.out.println(correct[i] + "out of " + questions[i]);
        }
    }
}
