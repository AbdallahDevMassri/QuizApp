import java.util.Arrays;

public class Question {
    private int id;
    private String question;
    private Opt[] options =new Opt[3] ;
    private String answer;
    
    
    public Question(int id, String question, Opt[] options, String answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public Opt[] getOptions() {
        return options;
    }
    public void setOptions(Opt[] options) {
        this.options = options;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", options=" + Arrays.toString(options) + ", answer="
                + answer + "]";
    }

    
}
