
/**
 * Write a description of class RandomLogic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomLogic
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public RandomLogic()
    {
    }
    
    public void askQuestion() 
    {
        Counting count = new Counting();
        
        count.updateCounters(PlusGetsMinusGets(46, '+', 7), 1);
        count.updateCounters(PlusGetsMinusGets(46, '-', 7), 1);
        count.updateCounters(AndOr(true, "||", false), 1);
        count.updateCounters(AndOr(true, "&&", false), 1);
        count.printCounters();
    }
    
     public Boolean PlusGetsMinusGets(int arg1, char operator, int arg2)
    {
        // prepare question from Question class
        Question ques = new Question();
        
        // format question
        ques.question = String.format("Variable 'count' holds " + arg1 +". What is count " + "%s" + "= " + arg2 + "?", operator );
        
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
        int ans;
        switch(operator)
        {
            case '+':
                ans = arg1 + arg2;
                ques.answerKey = ques.answerA;
                break;
            case '-':
                ans = arg1 - arg2;
                ques.answerKey = ques.answerD;
                break;
            default: // not supported
                return false;
        }
            
        // format question answer based off of operation calculation
        ques.answer =  String.format("Count holds " + arg1 + ". " + arg1 + " " + "%s " + arg2 + " = " + ans, operator);
        
        // getAnswer return true if question is correct
        return ques.getAnswer();
    }
    
    public Boolean AndOr(boolean arg1, String operator, boolean arg2)
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
        boolean ans;
        switch(operator)
        {
            case "&&":
                ans = (arg1 && arg2);
                ques.answerKey = ques.answerA;
                break;
            case "||":
                ans = (arg1 || arg2);
                ques.answerKey = ques.answerD;
                break;
            default: // not supported
                return false;
        }
            
        // format question answer based off of operation calculation
        ques.answer =  String.format(arg1 + " %s " + arg2 + " = " + ans, operator);
        
        // getAnswer return true if question is correct
        return ques.getAnswer();
    }
}
