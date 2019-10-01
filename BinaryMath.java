
/**
 * Write a description of class Binary here.
 *
 * @author (your name)
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
    
    public static String getRandomBinString(String answer)
    {
        boolean successful = false;
        int randNum = (int)(Math.random()*10);
        String binString = BinaryMath.zeroPadToBinary(randNum, 4);
        
        while (!successful) 
        {    if (randNum == (Integer.parseInt(answer)))
            {   randNum = (int)(Math.random()*10);
                binString = BinaryMath.zeroPadToBinary(randNum, 4);
                System.out.println(binString);
                return binString;
            } else {
                successful = true;
            }
        }
        return binString;
        
    }
    public boolean formatChoices(int first, char operator, int second) {
        
        Question theQuestion = new Question();
        String binary1 = BinaryMath.zeroPadToBinary(first, 4);
        String binary2 = BinaryMath.zeroPadToBinary(second, 4);
        theQuestion.question = String.format(binary1 + " %s " + binary2 + " = ", operator);
        
        int answerCalc;
        switch(operator)
        {
             case '+':
                theQuestion.choiceC = BinaryMath.zeroPadToBinary(first + second,4);
                theQuestion.choiceA = BinaryMath.getRandomBinString(theQuestion.choiceC);
                theQuestion.choiceB = BinaryMath.getRandomBinString(theQuestion.choiceC);
                theQuestion.choiceD = BinaryMath.getRandomBinString(theQuestion.choiceC);
                theQuestion.choiceE = "None of the above";
                answerCalc = first + second;
                theQuestion.answerKey = theQuestion.answerC;
                break;
             case '-':
                theQuestion.choiceB = BinaryMath.zeroPadToBinary(first-second,4);
                theQuestion.choiceA = BinaryMath.getRandomBinString(theQuestion.choiceB);
                theQuestion.choiceC = BinaryMath.getRandomBinString(theQuestion.choiceB);
                theQuestion.choiceD = BinaryMath.getRandomBinString(theQuestion.choiceB);
                theQuestion.choiceE = "None of the above";
                answerCalc = first - second;
                theQuestion.answerKey = theQuestion.answerB;
                break;
             case '/':
                theQuestion.choiceA = BinaryMath.zeroPadToBinary(first/second,4);
                System.out.println(theQuestion.choiceA);
                theQuestion.choiceB = BinaryMath.getRandomBinString(theQuestion.choiceA);
                theQuestion.choiceC = BinaryMath.getRandomBinString(theQuestion.choiceA);
                theQuestion.choiceD = BinaryMath.getRandomBinString(theQuestion.choiceA);
                theQuestion.choiceE = "None of the above";
                answerCalc = first / second;
                theQuestion.answerKey = theQuestion.answerA;
                break;
             case '&':
                theQuestion.choiceD = BinaryMath.zeroPadToBinary(first&second,4);
                theQuestion.choiceA = BinaryMath.getRandomBinString(theQuestion.choiceD);
                theQuestion.choiceB = BinaryMath.getRandomBinString(theQuestion.choiceD);
                theQuestion.choiceC = BinaryMath.getRandomBinString(theQuestion.choiceD);
                theQuestion.choiceE = "None of the above";
                answerCalc = first & second;
                theQuestion.answerKey = theQuestion.answerD;
                break;
             case '|':
                theQuestion.choiceE = "None of the above";
                theQuestion.choiceA = BinaryMath.getRandomBinString("0");
                theQuestion.choiceB = BinaryMath.getRandomBinString("0");
                theQuestion.choiceC = BinaryMath.getRandomBinString("0");
                theQuestion.choiceD = BinaryMath.getRandomBinString("0");
                answerCalc = first | second;
                theQuestion.answerKey = theQuestion.answerE;
                break;
             default: // not supported
                
             return false;
             
        }
        
        String binary3 = BinaryMath.zeroPadToBinary(answerCalc, 4);
        theQuestion.answer = String.format(binary1 + " %s " + binary2 + " = %s (%d)", operator, binary3, answerCalc);
        return theQuestion.getAnswer();
    }
}
        
        
        
        
  
 



