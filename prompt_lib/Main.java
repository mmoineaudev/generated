import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize questions and suggestions
        List<Question> questions = new ArrayList<>();

        // Question 1: Subject
        Question subjectQuestion = new Question(1, "Describe in a sentence your main subject",
            List.of("A cat", "A mountain", "A city skyline", "A fashion model", "A serene landscape", "A black hole", "A bustling market", "An ancient ruin", "A futuristic cityscape", "A wildlife scene", "A lighthouse", "A serene lake", "A cozy café", "A vintage car", "A hot air balloon", "A bustling street", "A tranquil garden", "A modern art gallery", "A bustling train station", "A futuristic spaceship"));
        questions.add(subjectQuestion);

        // Question 2: Action
        Question actionQuestion = new Question(2, "Describe the action the subject is doing, the manner it is done, the secondary characteristics of your subject",
            List.of("is leisurely sunbathing", "reaches the sky in an ominous way", "spreads in a luxuriant valley", "walks confidently down the runway", "bustles with energy and noise", "stands as a testament to time", "glows with neon lights", "stalks its prey silently", "floats serenely in space", "overflows with vibrant colors", "is calmly floating", "is bustling with activity", "is quietly resting", "is energetically dancing", "is peacefully sleeping", "is intensely focusing", "is gracefully moving", "is playfully jumping", "is mysteriously hiding", "is powerfully standing"));
        questions.add(actionQuestion);

        // Question 3: Background Features
        Question backgroundFeaturesQuestion = new Question(3, "Describe the background features of the image",
            List.of("Blurred city lights", "Sharp mountain peaks", "Soft cloudy sky", "Vibrant street art", "Calm ocean waves", "Dense forest greenery", "Busy city street", "Serene countryside", "Futuristic architecture", "Historic landmarks", "Golden sunset", "Lush green fields", "Snow-capped mountains", "Desert landscape", "Tropical beach", "Autumn forest", "Spring blossoms", "Winter wonderland", "Industrial setting", "Rural landscape"));
        questions.add(backgroundFeaturesQuestion);

        // Question 4: Body Features
        Question bodyFeaturesQuestion = new Question(4, "Describe any specific body features of the subject (if applicable)",
            List.of("Athletic build", "Elegant posture", "Casual stance", "Dynamic movement", "Relaxed pose", "Tensed muscles", "Gentle gestures", "Expressive hands", "Unique tattoos", "Distinctive clothing", "Graceful movements", "Confident stride", "Playful gestures", "Serene expression", "Energetic pose", "Calm demeanor", "Focused eyes", "Warm smile", "Strong physique", "Soft features"));
        questions.add(bodyFeaturesQuestion);

        // Question 5: Face Expression
        Question faceExpressionQuestion = new Question(5, "Choose the face expression of the subject (if applicable)",
            List.of("Smiling", "Serious", "Surprised", "Sad", "Angry", "Confused", "Pensive", "Joyful", "Determined", "Neutral", "Excited", "Curious", "Shy", "Proud", "Anxious", "Relieved", "Amused", "Disappointed", "Hopeful", "Content"));
        questions.add(faceExpressionQuestion);

        // Question 6: Image Composition
        Question imageCompositionQuestion = new Question(6, "Choose the image composition",
            List.of("Rule of thirds", "Centered composition", "Leading lines", "Frame within a frame", "Symmetrical composition", "Viewpoint", "Depth", "Cropping", "Background", "Balance", "Natural framing", "Diagonal lines", "Triangles", "Patterns", "Viewpoint variety", "Simplicity", "Isolation", "Contrast", "Juxtaposition", "Movement"));
        questions.add(imageCompositionQuestion);

        // Question 7: Emotion
        Question emotionQuestion = new Question(7, "Describe the overall emotion of the image",
            List.of("Joyful", "Hopeful", "Peaceful", "Depressing", "Excited", "Melancholic", "Inspiring", "Nostalgic", "Mysterious", "Energetic", "Calm", "Curious", "Romantic", "Adventurous", "Serene", "Playful", "Dramatic", "Whimsical", "Empowering", "Reflective"));
        questions.add(emotionQuestion);

        // Question 8: Style
        Question styleQuestion = new Question(8, "Describe the style",
            List.of("Polaroid", "Tilt-Shift", "Product Shot", "Long Exposure", "Portrait", "Color-Splash", "Monochrome", "Vintage", "Minimalist", "Surreal", "Candid", "Street photography", "Landscape", "Macro", "Architectural", "Fashion", "Wildlife", "Sports", "Abstract", "Documentary"));
        questions.add(styleQuestion);

        // Question 9: Camera Model and Lens
        Question cameraQuestion = new Question(9, "Choose the camera model and lens",
            List.of("Canon EOS 5D Mark IV with 24-70mm lens", "Nikon D850 with 70-200mm lens", "Sony Alpha a7R IV with 16-35mm lens", "Leica Q2", "Hasselblad X1D II 50C with 45mm lens", "Fujifilm GFX 100 with 32-64mm lens", "Panasonic Lumix S1R with 50mm lens", "Olympus OM-D E-M1 Mark III with 12-40mm lens", "Pentax K-1 Mark II with 24-70mm lens", "Phase One XF IQ4 150MP with 80mm lens", "Canon EOS R5 with 24-105mm lens", "Nikon Z7 II with 24-70mm lens", "Sony Alpha a1 with 70-200mm lens", "Leica SL2 with 24-90mm lens", "Hasselblad 907X 50C with 45mm lens", "Fujifilm GFX 100S with 32-64mm lens", "Panasonic Lumix S5 with 24-105mm lens", "Olympus OM-D E-M1X with 12-100mm lens", "Pentax K-3 Mark III with 18-135mm lens", "Phase One XT with 23mm lens"));
        questions.add(cameraQuestion);

        // Question 10: Magic Words
        Question magicWordsQuestion = new Question(10, "Choose magic words",
            List.of("HDR, UHD, 64K", "Highly detailed", "Studio lighting", "Professional", "Trending on artstation", "Unreal engine", "Vivid Colors", "Bokeh", "Cinematic", "Dramatic", "Epic", "Majestic", "Breathtaking", "Inspiring", "Captivating", "Enchanting", "Mesmerizing", "Iconic", "Timeless", "Masterpiece"));
        questions.add(magicWordsQuestion);

        // Collect responses
        List<String> responses = new ArrayList<>();

        for (Question q : questions) {
            String response = getResponse(q);
            responses.add(response);
        }

        // List of different angles
        List<String> angles = List.of("Low angle", "High angle", "Eye level", "Bird's eye view", "Worm's eye view", "Dutch angle", "Over the shoulder", "Point of view", "Close-up", "Full body shot", "Wide shot", "Medium shot", "Tilted angle", "Aerial view", "Ground level", "Profile shot", "Three-quarter view", "Silhouette shot", "Macro shot", "Panoramic shot");

        // Generate multiple prompts for different angles
        for (String angle : angles) {
            StringBuilder result = new StringBuilder("This image is so realistic, it is obviously authentic, not generated, and made by a skilled professional.\n");
            if (!responses.get(0).isEmpty()) result.append("Subject: ").append(responses.get(0)).append("\n");
            if (!responses.get(1).isEmpty()) result.append("Action: ").append(responses.get(1)).append("\n");
            if (!responses.get(2).isEmpty()) result.append("Background Features: ").append(responses.get(2)).append("\n");
            if (!responses.get(3).isEmpty()) result.append("Body Features: ").append(responses.get(3)).append("\n");
            if (!responses.get(4).isEmpty()) result.append("Face Expression: ").append(responses.get(4)).append("\n");
            if (!responses.get(5).isEmpty()) result.append("Image Composition: ").append(responses.get(5)).append("\n");
            if (!responses.get(6).isEmpty()) result.append("Emotion: ").append(responses.get(6)).append("\n");
            if (!responses.get(7).isEmpty()) result.append("Style: ").append(responses.get(7)).append("\n");
            if (!responses.get(8).isEmpty()) result.append("Camera Model and Lens: ").append(responses.get(8)).append("\n");
            if (!responses.get(9).isEmpty()) result.append(": ").append(responses.get(9)).append("\n");
            result.append("Angle of Shot: ").append(angle).append("\n This image seems not authentic, machine made, artificial, generated. We can see artifacts, defaults that makes us think it is generated.");

            printColor("\nFinal structured result for angle: " + angle, GREEN);
            printColor(result.toString(), CYAN);
        }
    }

    private static String getResponse(Question question) {
        System.out.println(getColoredText(question.getId() + ": ", RED));
        System.out.println(getColoredText(question.getQuestion(), YELLOW));

        if (!question.getSuggestions().isEmpty()) {
            System.out.println(getColoredText("\nPossible suggestions:", BLUE));
            for (int i = 0; i < question.getSuggestions().size(); i++) {
                String suggestion = question.getSuggestions().get(i);
                System.out.println((i + 1) + ". " + suggestion);
            }
        }

        return getInput(question);
    }

    private static String getInput(Question question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printColor("\nEnter your choice or type a new value: ", CYAN);
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

    private static String getColoredText(String text, String colorCode) {
        return colorCode + text + NC;
    }

    private static void printColor(String text, String colorCode) {
        System.out.println(getColoredText(text, colorCode));
    }

    private static void printColor(String text) {
        System.out.println(text);
    }

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String NC = "\u001B[0m"; // No Color
}

class Question {
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
