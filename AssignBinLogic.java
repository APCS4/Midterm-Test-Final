
/**
 * Write a description of class RandomLogic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;
public class AssignBinLogic
{
    Counting tally;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public AssignBinLogic(Counting tally1)
    {
        tally = tally1;
    }
    
    public void askQuestion() 
    {
        Random first = new Random();
        int hold, hold2;    // Random numbers for math questions
        boolean temp, temp2;    // Random booleans for comparing questions
        
        hold = first.nextInt(101);
        hold2 = first.nextInt(101);
        tally.updateCounters(PlusGetsMinusGets(hold, '+', hold2), 4);
        
        hold = first.nextInt(101);
        hold2 = first.nextInt(101);
        tally.updateCounters(PlusGetsMinusGets(hold, '-', hold2), 4);
        
        temp = first.nextBoolean();
        temp2 = first.nextBoolean();        
        tally.updateCounters(AndOr(temp, "||", temp2), 4);
        
        temp = first.nextBoolean();
        temp2 = first.nextBoolean();      
        tally.updateCounters(AndOr(temp, "&&", temp2), 4);
        
        String q = "random.nextInt(10) will generate what";
        String[] as = {
            "An int between 0-10, including 0, not including 10",
            "An int between 0-10, not including 0, not including 10",
            "An int between 0-10, including 0, including 10",
            "An int between 0-10, not including 0, including 10",
            "An int between 0-9, not including 0, including 9"};
        int a = 0;
        tally.updateCounters(McQ(q,as,a), 4);
    }
    
     public boolean PlusGetsMinusGets(int arg1, char operator, int arg2)
    {
        // prepare question from Question class
        Question ques = new Question();
        
        // format question
        ques.question = String.format("Variable 'count' holds " + arg1 +". What is count after count " + "%s" + "= " + arg2 + "?", operator );
        
        // variables so we can print the answers - initialize them
        int temp1;
        int temp2;
        temp1 = arg1 + arg2;
        temp2 = arg1 - arg2;
        
        // format question choices
        ques.choiceA = String.format("%d",temp1);
        ques.choiceB = String.format("%d",arg1/arg2);
        ques.choiceC = String.format("%d",arg1*arg2);
        ques.choiceD = String.format("%d",temp2);
        ques.choiceE = "None of the above";
        
        // real time calc answer based off args AND operator
        int ans = 0;
        switch(operator)
        {
            // plus gets / plus equals
            case '+':
                ans = arg1 + arg2;
                ques.answerKey = ques.answerA;
                break;
            // minus gets / minus equals
            case '-':
                ans = arg1 - arg2;
                ques.answerKey = ques.answerD;
                break;
            default: // not supported
                break;
        }
            
        // format question answer based off of operation calculation
        ques.answer =  String.format("Count holds " + arg1 + ". " + arg1 + " " + "%s " + arg2 + " = " + ans + ", so count now holds " + ans + ".", operator);
        
        // getAnswer return true if question is correct
        return ques.getAnswer();
    }
    
    public boolean AndOr(boolean arg1, String operator, boolean arg2)
    {
        // prepare question from Question class
        Question ques = new Question();
        
        // format question
        ques.question = String.format("What is " + arg1 + " " + "%s " + arg2 + "?", operator );
        
        // format question choices
        ques.choiceA = String.format("%b",(arg1 && arg2));
        ques.choiceB = String.format("%s", "truefalse");
        ques.choiceC = String.format("%b",(arg1 || arg2));
        ques.choiceD = String.format("%s","falsetrue");
        ques.choiceE = "None of the above";
        
        // real time calc answer based off args AND operator
        boolean ans = false;
        switch(operator)
        {
            // and
            case "&&":
                ans = (arg1 && arg2);
                ques.answerKey = ques.answerA;
                break;
            // or
            case "||":
                ans = (arg1 || arg2);
                ques.answerKey = ques.answerC;
                break;
            default: // not supported
                break;
        }
            
        // format question answer based off of operation calculation
        ques.answer =  String.format(arg1 + " %s " + arg2 + " = " + ans, operator);
        
        // getAnswer return true if question is correct
        return ques.getAnswer();
    }
    
    public boolean McQ(String q, String[] answers, int answerLocation)
    {
       Random rNum = new Random();
       int[] rOrd = {0,1,2,3,4};
       
       // randomizes the answers
       for (int i=0; i<rOrd.length; i++) {
          int rPos = rNum.nextInt(rOrd.length);
          int temp = rOrd[i];           
          rOrd[i] = rOrd[rPos];   
          rOrd[rPos] = temp;        
       }
       
       char ans = 'a';
       // finds where the correct answer now is, and sets the value of ans to a letter according to the location
       for (int i=0; i<rOrd.length; i++)
       {
           if (rOrd[i] == answerLocation)
           {
               switch (i)
               {
                  case 0: ans = 'a';
                    break;
                  case 1: ans = 'b';
                    break;
                  case 2: ans = 'c';
                    break;
                  case 3: ans = 'd';
                    break;
                  case 4: ans = 'e';
               }
           }
       }

       Question question = new Question(answers[rOrd[0]], answers[rOrd[1]], answers[rOrd[2]], answers[rOrd[3]], answers[rOrd[4]], q, ans);
       
       question.answer = ("Correct answer: " + answers[answerLocation]);
       return question.getAnswer();
    }
}
