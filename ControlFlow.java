
/**
 * Write a description of class ControlFlow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ControlFlow
{
    public int qAmount;
    public int numberCorrect;
    public int roll;
    private Random rand = new Random();
    public ControlFlow(int qA){
        qAmount = qA;
    }
    public int askQuestions(){
        return 0;
    }
    public void askBinaryMath(){
        byte a = (byte)rand.nextInt(8);
        byte b = (byte)rand.nextInt(8);
        String operation = randomBinOperator();
        String question = "("+a+operation+b+")";
        int answer;
        int badAnswer1;
        int badAnswer2;
        int badAnswer3;
        int badAnswer4;
        if(operation.equals("^")){
            answer = (a^b);
            badAnswer1 = ((a^b)==(a&b))?(a&b+1):(a&b);
            badAnswer2 = ((a^b)==(a|b))?(a|b+1):(a|b);
            badAnswer3 = 0;
            badAnswer4 = ((a^b)==(a*b))?(a*b+1):(a*b);
        } else if (operation.equals("|")){
            answer = (a|b);
            badAnswer1 = ((a|b)==(a&b))?(a&b+1):(a&b);
            badAnswer2 = ((a|b)==(a^b))?(a^b+1):(a^b);
            badAnswer3 = 0;
            badAnswer4 = ((a==1)||(b==1))?(a*b-1):(a*b);
        } else if (operation.equals("&")){
            answer = (a&b);
            badAnswer1 = (a==b)?(a|b+1):(a|b);
            badAnswer2 = (a^b);
            badAnswer3 = ((a&b)==0)?(1):0;
            badAnswer4 = ((a==1)||(b==1))?(a*b-1):(a*b);
        } else {
            //so that compiler doesn't say these were never given values
            answer = (a&b);
            badAnswer1 = (a|b);
            badAnswer2 = (a^b);
            badAnswer3 = 0;
            badAnswer4 = (a*b);
            System.out.println("If you're seing this, I did something wrong");
        }
            boolean correctBool = shuffleAndAsk(Integer.toString(answer), Integer.toString(badAnswer1), Integer.toString(badAnswer2), Integer.toString(badAnswer3), Integer.toString(badAnswer4), question, 0);
        if (correctBool){
            numberCorrect-=-1;
        }
        System.out.println(answer);
    }
    public void askBoolLogic(){
        boolean a = rand.nextBoolean();
        boolean b = rand.nextBoolean();
        boolean ab;
        boolean c = rand.nextBoolean();
        boolean d = rand.nextBoolean();
        boolean cd;
        boolean e = rand.nextBoolean();
        boolean f = rand.nextBoolean();
        boolean ef;
        boolean abcd;
        boolean abcdef;
        String aa = randomComparator();
        String bb = randomComparator();
        String cc = randomComparator();
        String dd = randomComparator();
        String ee = randomComparator();
        String question = "\na="+a+"\nb="+b+"\nc="+c+"\nd="+d+"\ne="+e+"\nf="+f+"\nSimplify:\n(((a"+aa+"b)"+bb+"(c"+cc+"d))"+dd+"(e"+ee+"f))";
        if(aa.equals("||"))
            ab = (a||b);
        else if(aa.equals("&&"))
            ab = (a&&b);
        else if(aa.equals("^"))
            ab = (a^b);
        else
            ab = (a=b);
        if(cc.equals("||"))
            cd = (c||d);
        else if(cc.equals("&&"))
            cd = (c&&d);
        else if(cc.equals("^"))
            cd = (c^d);
        else
            cd = (c=d);
        if(ee.equals("||"))
            ef = (e||f);
        else if(ee.equals("&&"))
            ef = (e&&f);
        else if(ee.equals("^"))
            ef = (e^f);
        else
            ef = (e=f);
        if(bb.equals("||"))
            abcd = (ab||cd);
        else if(bb.equals("&&"))
            abcd = (ab&&cd);
        else if(bb.equals("^"))
            abcd = (ab^cd);
        else
            abcd = (ab=cd);
        if(dd.equals("||"))
            abcdef = (abcd||ef);
        else if(dd.equals("&&"))
            abcdef = (abcd&&ef);
        else if(dd.equals("^"))
            abcdef = (abcd^ef);
        else
            abcdef = (abcd=ef);
        char ansK = (abcdef)?'A':'B';
        Question boolQ = new Question("true","false","Not this one","Or this one","Or this one", question, ansK);
        boolQ.answer = (abcdef)?"true":"false";
        boolean correct = boolQ.getAnswer();
        if(correct)
            numberCorrect-=-1;
    }
    private String randomComparator(){
        roll = rand.nextInt(4);
        switch (roll){
            case 1:
                return "||";
                
            case 2:
                return "&&";
                
            case 3:
                return "^";
                
            case 0:
                return "=";
            default:
                return "";
        }
    }
    private String randomBinOperator(){
        roll = rand.nextInt(3);
        switch (roll){
            case 1:
                return "|";
            case 2:
                return "&";
            case 0:
                return "^";
            default:
                return "";
        }
    }
    private boolean shuffleAndAsk(String chA, String chB, String chC, String chD, String chE, String ques, int ans){
        String[] ansArr = new String[5];
        ansArr[0]=chA;
        ansArr[1]=chB;
        ansArr[2]=chC;
        ansArr[3]=chD;
        ansArr[4]=chE;
        String[] ansArrBeforeShuffle = new String[5];
        for(int i = 0; i<5; i++){
            ansArrBeforeShuffle[i] = ansArr[i];
        }
        Collections.shuffle(Arrays.asList(ansArr));
        String answer="";
        char answerChar=' ';
        for(int i=0;i<5;i++){
            if(ansArr[i].equals(ansArrBeforeShuffle[ans])){
                answerChar = (char)(i+65);
            }
        }
        Question thisQ = new Question(ansArr[0],ansArr[1],ansArr[2],ansArr[3],ansArr[4],ques,answerChar);
        thisQ.answer = ansArrBeforeShuffle[0];
        return thisQ.getAnswer();
    }
}
