
/**
 * MathOpFun is intended to teach computer math and operator principles, 
 *  plus..
 *      i)      Running MathOps fun will execute and evaluate math operators
 *      ii)     Coding MathOps fun assist in learning syntax of JAVA math operators
 *      iii)    MathOpsFun is dependent on class heirarchy and while working on this Class
 *              you will be learning JAVA OOP methodology
 *      iv)     MathOpsFun will be extended and built in class and with peers as a part of the
 *              MidTermTest project 
 *      v)      Each class member when they get a lab or handout, they will will look to bring
 *              applicable math operations into MathOpsFun
 *
 * @author John Mortensen
 * @version 1.0
 */


public class MathOpsFun
{
    
    
    /**
     * askQuestion is a method that conforms to MidTermTest requirements to ask a question
     *
     * @return    return code:  
     *                          0 - execution completion returned succesful
     *                          >0 - execution aborted with error (needs to be implemented)
     */
    public MathOpsFun()
    {
        
        Counting tally = new Counting();

        // randomize logic to pick supplied amount of questions from method parameter, ie 10 
        
        // randomizing logic here to pick arg1 <= 99, arg2 <=9 with Modulo != 0
        tally.updateCounters( IntMathDivAndModulo(46, '/', 7) );
        tally.updateCounters( IntMathDivAndModulo(46, '%', 7) );
        
        tally.printCounters();
        
    }
  
    /**
     * IntMathDivAndModulo 
     *
     * @param  arg1      1st argument in math expression
     * @param  operator  operator in math expression (/ or % only)
     * @param  arg2      2st argument in math expression
     * @return    error code
     */
    public Boolean IntMathDivAndModulo(int arg1, char operator, int arg2)
    {        
        // prepare question from Question class
        Question question = new Question();
        
        // format question
        question.question = String.format("What is (int)" + arg1 + " " + "%s" + " (int)" + arg2, operator );
        
        // format question choices
        question.choiceA = String.format("%f",(float)arg1/(float)arg2);
        question.choiceB = String.format("%x",arg1/arg2);
        question.choiceC = String.format("%f",(float)arg1*(float)arg2);
        question.choiceD = String.format("%x",arg1%arg2);
        question.choiceE = "None of the above";
        
        // real time calc answer based off args AND operator
        int answerCalc;
        switch(operator)
        {
            case '/':
                answerCalc = arg1 / arg2;
                question.answerKey = question.answerB;
                break;
            case '%':
                answerCalc = arg1 % arg2;
                question.answerKey = question.answerD;
                break;
            default: // not supported
                return false;
        }
            
        // format question answer based off of operation calculation
        question.answer =  String.format(
            "(int)"+arg1 +          // arg1
            " "+
            "%s"+                   // operator
            " " +        
            "(int)"+ arg2 +         // arg2
            " = " + 
            answerCalc              // answer
            ,operator);             // operator parameter % 
                                    // requires var (may be hidden feature :)
        
        // getAnswer return true if question is correct
        return question.getAnswer();

    }
    
}
