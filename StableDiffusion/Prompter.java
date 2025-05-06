import java.util.ArrayList;
import java.util.List;

public class Prompter {
    public static void main(String[] args) {
        // Initialize questions and suggestions
        List<Question> questions = new ArrayList<>();
        
        // Question 1: Subject
        Question subjectQuestion = new Question(1, "Describe in a sentence your main subject", 
            List.of("A cat", "A mountain", "A city", "A model", "A landscape", "A black hole"));
        questions.add(subjectQuestion);
        
        // Question 2: Action
        Question actionQuestion = new Question(2, "Describe the action the subject is doing, the manner it is done, the secondary characteristics of your subject",
            List.of("is leisurely sunbathing", "reaches the sky in an ominous way", "spreads in a luxuriant valley"));
        questions.add(actionQuestion);
        
        // Question 3: Emotion
        Question emotionQuestion = new Question(3, "Describe the overall emotion of the image",
            List.of("Joyful", "Hopeful", "Peaceful", "Depressing", "Excited"));
        questions.add(emotionQuestion);
        
        // Question 4: Style
        Question styleQuestion = new Question(4, "describe the style :",
            List.of("Polaroid", "Tilt-Shift", "Product Shot", "Long Exposure", "Portrait", "Color-Splash", "Monochrome"));
        questions.add(styleQuestion);
        
        // Question 5: Magic Words
        Question magicWordsQuestion = new Question(5, "Choose magic words : ",
            List.of("HDR, UHD, 64K", "Highly detailed", "Studio lighting", "Professional", 
                     "Trending on artstation", "Unreal engine", "Vivid Colors", "Bokeh"));
        questions.add(magicWordsQuestion);
        
        // Collect responses
        List<String> responses = new ArrayList<>();
        
        for (Question q : questions) {
            String response = getResponse(q);
            responses.add(response);
        }
        
        // Concatenate results
        String result = String.join("|", responses);
        
        printColor("\nFinal concatenated result:", GREEN);
        printColor(result, CYAN);
    }
    
    private static String getResponse(Question question) {
        printColor("\n" + getColoredText(question.getId() + ": ", RED), true);
        printColor(getColoredText(question.getQuestion(), YELLOW));
        
        if (!question.getSuggestions().isEmpty()) {
            printColor("\nPossible suggestions:", BLUE);
            for (int i = 0; i < question.getSuggestions().size(); i++) {
                String suggestion = question.getSuggestions().get(i);
                printColor((i + 1) + ". " + suggestion, CYAN);
            }
        }
        
        return getInput(question);
    }
    
    private static String getInput(Question question) {
        while (true) {
            System.out.print("\nEnter your choice or type a new value: ");
            String input = scanner.nextLine().trim();
            
            if (!input.isEmpty()) {
                try {
                    int num = Integer.parseInt(input);
                    List<String> suggestions = question.getSuggestions();
                    if (num >= 1 && num <= suggestions.size()) {
                        return suggestions.get(num - 1);
                    }
                } catch (NumberFormatException e) {
                    // Not a number, treat as custom input
                }
            }
            
            return input;
        }
    }
    
    static {
        initializeColors();
    }
    
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String NC = "\u001B[0m"; // No Color
    
    private static void initializeColors() {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    }
    
    private static void printColor(String text, String color) {
        System.out.println(color + text + NC);
    }
    
    private static void printColor(String text, boolean isRed) {
        if (isRed) {
            System.out.println(RED + text + NC);
        } else {
            System.out.println(text);
        }
    }
    
    private static Scanner scanner = new Scanner(System.in);

    public static class Question {
        private int id;
        private String question;
        private List<String> suggestions;

        public Question(int id, String question, List<String> suggestions) {
            this.id = id;
            this.question = question;
            this.suggestions = suggestions;
        }

        public int getId() { return id; }
        public String getQuestion() { return question; }
        public List<String> getSuggestions() { return suggestions; }
    }
}
