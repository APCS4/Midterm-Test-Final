
/**
 * Write a description of class QuestionClassExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionClassExample
{
    public static void main(){
        /*
      String question = "What number is between 3 and 5.";
      String a = "2";
      String b = "4";
      String c = "6";
      String d = "7";
      String e = "8";
      char answer = 'b';
      
      Question mcQuest = new Question(a, b, c, d, e, question, answer);
      mcQuest.getAnswer();
      */
     
     
      String question = "There are 10 types of people in this world, those who understand binary and those who don't.";
      String answer = "true";
      
      Question tfQuest = new Question (question, answer);
      tfQuest.getAnswer();
      
    }
}
