package colorQuiz;

public class quizQuestion {
    
    private String question;
    private int white;
    private int black;
    private int blue;
    private int red;
    private int green;
    
    quizQuestion(){
        
    }
    
    quizQuestion(String question, int white, int black, int blue, int red, int green){
        
        this.question = question;
        this.white = white;
        this.black = black;
        this.red = red;
        this.green = green;
        
    }
    
    public void setQuestion(String question){
        
        this.question = question;
        
    }
    public void setWhite(int white){
        
        this.white = white;
        
    }
    public void setBlack(int black){
        
        this.black = black;
        
    }
    public void setBlue(int blue){
        
        this.blue = blue;
        
    }
    public void setRed(int red){
        
        this.red = red;
        
    }
    public void setGreen(int green){
        
        this.green = green;
        
    }
    public String getQuestion(){
        
        return question;
        
    }
    public int getWhite(){
        
        return white;
        
    }
    public int getBlack(){
        
        return black;
        
    }
    public int getBlue(){
        
        return blue;
        
    }
    public int getRed(){
        
        return red;
        
    }
    public int getGreen(){
        
        return green;
        
    }
}
