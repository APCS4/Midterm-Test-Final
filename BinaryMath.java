
/**
 * Write a description of class Binary here.
 *
 * @author Sydney Hsieh
 * @version (a version number or a date)
 */

import java.util.Random;

public class BinaryMath
{   
    Counting tally;
    int count = 1;
    
    /**
     * Constructor for objects of class Binary
     */
    public BinaryMath(Counting _tally)
    {    
        tally = _tally;
    }
    
    public void askQuestion(char operator)
    {
        System.out.println("Binary: Question " + count++);
        int nums[] = BinaryMath.getTwoRandomNumbers();

        tally.updateCounters(formatChoices(nums[0], operator, nums[1]), 1);

    }
    
    //Converts integer values into a binary string
    static String zeroPadToBinary(int arg, int binaryLength)
    {
        return Integer.toBinaryString((1<<binaryLength)| arg).substring(1);
    }
    
    //generate random numbers for question
    public static int[] getTwoRandomNumbers()
    {
        Question question = new Question();
        
        int args[];
        
        do{
            args = new Random().ints(1, 15).distinct().limit(2).toArray();
        } while (args[0] <= 1 || args[1] > args[0] || args[1] <= 1 || args[0] % args[1] != 0);
       
        return args;
    }
    
    //generate random binary number choices
    public static String getRandomBinString(int answer)
    {
        boolean successful = false;
        int args[] = new Random().ints(1, 15).distinct().limit(1).toArray();
        int randNum = args[0];
        String binString = BinaryMath.zeroPadToBinary(randNum, 4);
        
        while (!successful) 
        {    
            if (randNum == (answer))
            {   randNum = (int)(Math.random()*15);
                binString = BinaryMath.zeroPadToBinary(randNum, 4);
                //System.out.println(binString);          
            } else {
                successful = true;
            }
        }
        return binString;
        
    }
    
    //format question, choices, and answers
    public boolean formatChoices(int first, char operator, int second) {
        
        //Formating question
        Question theQuestion = new Question();
        String binary1 = BinaryMath.zeroPadToBinary(first, 4);
        String binary2 = BinaryMath.zeroPadToBinary(second, 4);
        theQuestion.question = String.format(binary1 + " %s " + binary2 + " = ", operator);
        
        //bit length
        int bits = ((first + second) > 15) ? 5 : 4;
        
        //Assigning Choices A through E
        int answerCalc;
        switch(operator)
        {
             case '+':
                answerCalc = first + second;
                theQuestion.choiceC = BinaryMath.zeroPadToBinary(first + second,bits);
                theQuestion.choiceA = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceB = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceD = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceE = "None of the above";
                theQuestion.answerKey = theQuestion.answerC;
                break;
             case '-':
                answerCalc = first - second;
                theQuestion.choiceB = BinaryMath.zeroPadToBinary(first-second,4);
                theQuestion.choiceA = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceC = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceD = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceE = "None of the above";
                theQuestion.answerKey = theQuestion.answerB;
                break;
             case '/':
                answerCalc = first / second;
                theQuestion.choiceA = BinaryMath.zeroPadToBinary(first/second,4);
                theQuestion.choiceB = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceC = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceD = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceE = "None of the above";
                theQuestion.answerKey = theQuestion.answerA;
                break;
             case '&':
                answerCalc = first & second;
                theQuestion.choiceD = BinaryMath.zeroPadToBinary(first&second,4);
                theQuestion.choiceA = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceB = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceC = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceE = "None of the above";
                theQuestion.answerKey = theQuestion.answerD;
                break;
             case '|':
                answerCalc = first | second;
                theQuestion.choiceE = "None of the above";
                theQuestion.choiceA = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceB = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceC = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.choiceD = BinaryMath.getRandomBinString(answerCalc);
                theQuestion.answerKey = theQuestion.answerE;
                break;
             default: // not supported
                
             return false;
             
        }
        
        //format answer statement
        String binary3 = BinaryMath.zeroPadToBinary(answerCalc, bits);
        theQuestion.answer = String.format(binary1 + " %s " + binary2 + " = %s (%d)", operator, binary3, answerCalc);
        return theQuestion.getAnswer();
    }
}
        
        
        
        
  
 



