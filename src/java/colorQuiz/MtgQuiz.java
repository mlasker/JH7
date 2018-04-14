package colorQuiz;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MtgQuiz {

    private int whiteScore = 0;
    private int blackScore = 0;
    private int redScore = 0;
    private int blueScore = 0;
    private int greenScore = 0;
    private int counter = 0;
    private ArrayList<quizQuestion> questions;

    public MtgQuiz() {
        
    }
    public MtgQuiz(String filepath) {
        createArray(filepath);
        System.out.println(numOfQuestions());
    }
    public String numOfQuestions(){
      
        String s = "The size of the quizQuestion array is: " + questions.size();
        return s;
    }
    
    public String calculateScore() {

        return "/finish.jsp";
    }
    public quizQuestion getFirstQuestion(){
        
        quizQuestion q = questions.get(counter);
        return q;
    }
    public quizQuestion getNextQuestion(){
        
        counter++;
        quizQuestion q = questions.get(counter);
        return q;
    }
    public boolean continueQuiz(){
    
        if (counter+1 < questions.size())
                return true;
        else
            return false;
    }
    public void trueAnswer(){
        
        whiteScore+=questions.get(counter).getWhite();
        blackScore+=questions.get(counter).getBlack();
        blueScore+=questions.get(counter).getBlue();
        redScore+=questions.get(counter).getRed();
        greenScore+=questions.get(counter).getGreen();
        
    }
    public void falseAnswer(){
        
        whiteScore-=questions.get(counter).getWhite();
        blackScore-=questions.get(counter).getBlack();
        blueScore-=questions.get(counter).getBlue();
        redScore-=questions.get(counter).getRed();
        greenScore-=questions.get(counter).getGreen();
        
    }
    public ArrayList getQuestions() {

        return questions;
    }
    public void debugPrint(){
        System.out.println("question " + questions.get(counter-1).getQuestion());
        System.out.println("white score " + whiteScore);
        System.out.println("black score " + blackScore);
        System.out.println("blue score " + blueScore);
        System.out.println("red score " + redScore);
        System.out.println("green score " + greenScore);
        System.out.println("counter " + counter);
    }
    public void createArray(String filePath){
        
        questions = new ArrayList<>();
        
        try {

            FileInputStream fstream = new FileInputStream(filePath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] tokens = strLine.split("@");
                String question = tokens[0];
                int white = Integer.parseInt(tokens[1]);
                int black = Integer.parseInt(tokens[2]);
                int blue = Integer.parseInt(tokens[3]);
                int red = Integer.parseInt(tokens[4]);
                int green = Integer.parseInt(tokens[5]);
                
                quizQuestion q = new quizQuestion(question, white, black, blue, red, green);
                questions.add(q);
            }
            in.close();
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
