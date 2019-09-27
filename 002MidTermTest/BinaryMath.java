
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
        Counting tally = new Counting();
        
        // randomizing logic here to pick arg1 <= 99, arg2 <=9 with Modulo != 0
       
        tally.printCounters();
        
    }    
    
    public  void askQuestion()
    {
        int nums[] = BinaryMath.getTwoRandomNumbers();
        
        System.out.println("1>" + nums[0] + " 2>" + nums[1]);
        
        String binary1 = BinaryMath.zeroPadToBinary(nums[0], 4);
        String binary2 = BinaryMath.zeroPadToBinary(nums[1], 4);
        
    }
    
    static String zeroPadToBinary(int arg, int binaryLength)
    {
        return Integer.toBinaryString((1<<binaryLength)| arg).substring(1);
    }
    
    public static int[] getTwoRandomNumbers()
    {
        Question question = new Question();
        
        int args[];
        
        do{
            args = new Random().ints(1, 15).distinct().limit(2).toArray();
        } while (args[0] <= 1 || args[1] > args[0] || args[1] <= 1 || args[0] % args[1] != 0);
       
        //BinaryMath.formatQuestion(args[0],'/', args[1]);
        
        return args;
    }
    
    public boolean formatQuestion(int first, char operator, int second) {
        
        Question question = new Question();
        
        question.choiceA = String.format("%x", first/second);
        question.choiceB = String.format("%x", first*second);
        question.choiceC = String.format("%x", first|second);
        question.choiceD = String.format("%x", first&second);
        question.choiceE = "None of the above";
        
        int answerCalc;
            switch(operator)
                {
                 case '/':
                    answerCalc = first / second;
                    question.answerKey = question.answerB;
                    break;
                 case '%':
                    answerCalc = first % second;
                    question.answerKey = question.answerD;
                    break;
                 default: // not supported
                    
                 return false;
        }
        return question.getAnswer();
        }
    }
        
        
        
        
  
 



