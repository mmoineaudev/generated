import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QwenPrompter {
    public static void main(String[] args) {
        // Initialize questions and suggestions
        List<Question> questions = new ArrayList<>();
        
       // Question 1: Subject (Fashion Edition - Persons Only)
Question subjectQuestion = new Question(1, "Describe in a sentence your main fashion subject",
    List.of(
        "A tall model with sharp cheekbones wearing a futuristic metallic dress under LED lights",
        "A gender-fluid model posing in a bold mix of tailoring and sheer fabrics",
        "A street-style influencer in oversized denim and chunky boots",
        "A blonde model in a minimalist white suit against a black backdrop",
        "A dark-haired model draped in silk fabric on a rooftop at golden hour",
        "A model wearing avant-garde couture made from recycled materials",
        "A confident Black model in a neon-colored power suit",
        "A model in a flowing red gown caught mid-stride on cobblestone streets",
        "A punk-styled model in tartan pants and chrome accessories",
        "A male model in a sharply tailored double-breasted suit",
        "A model in a digital fashion avatar outfit within a cyberpunk setting",
        "A retro 90s supermodel lookalike in monochrome trench coat and sunglasses",
        "A model in a layered autumn look walking through rain-soaked downtown",
        "A female model in a sequined evening gown standing alone in shadow",
        "A sneakerhead model styled in high-end sportswear and rare sneakers",
        "A model in a sculptural couture piece displayed like modern art",
        "A pale-skinned model in all-black leather with silver detailing",
        "A model in a gender-neutral jumpsuit with architectural draping",
        "A bridal model with dramatic train walking down an urban alley",
        "A model in a color-blocked editorial look during sunset rooftop shoot",
        "A curvy model wearing a body-conscious latex dress",
        "A model draped like a classical statue in flowing white muslin",
        "A South Asian model in a fusion look blending traditional and modern",
        "A gothic model in lace gloves and velvet corsetry",
        "A model in a deconstructed blazer paired with fishnet tights",
        "A model wearing a translucent top over a bra adorned with crystals",
        "A model in a cropped puffer jacket and mini skirt on a snowy street",
        "A model in a longline fur vest with nothing underneath",
        "A model in a mesh bodysuit layered with statement jewelry",
        "A model in a neon-pink tracksuit leaning against a graffiti wall",
        "A model in a vintage fur stole and wide-leg trousers",
        "A model in a bondage-inspired look with leather harness details",
        "A model in a transparent PVC raincoat over lingerie",
        "A model in a neutral-toned linen suit with platform sandals",
        "A model in a cut-out swimsuit shot on a city rooftop at dusk",
        "A model in a cape-like coat blowing dramatically in the wind",
        "A model in a glittering catsuit striking a strong pose",
        "A model in a sheer blouse over a corset, backlit by soft studio light",
        "A model in a cropped hoodie and cargo pants, mid-stride on the sidewalk",
        "A model in a sheer kaftan worn over a bikini on a rooftop"
    ));
questions.add(subjectQuestion);

// Question 2: Action / Pose / Mood (Fashion Edition - Expanded)
Question actionQuestion = new Question(2, "Describe how the subject is posed or moving, their expression, and any secondary characteristics",
    List.of(
        "struts confidently down an imaginary catwalk with fierce gaze",
        "leans casually against a lamppost with hands in pockets and smirk",
        "gazes intensely into the camera with subtle seduction",
        "twirls gracefully, letting the fabric fly around them dramatically",
        "stands still with arms crossed and piercing stare toward the lens",
        "walks briskly through rain-soaked streets with defiant attitude",
        "poses asymmetrically with one arm raised and head tilted",
        "looks over shoulder with a mysterious half-smile and raised brow",
        "glides through the frame with cape-like fabric flowing behind",
        "adjusts collar while staring into the distance thoughtfully",
        "jumps mid-air with dynamic energy and joyous expression",
        "sits cross-legged on stairs with relaxed elegance and cigarette",
        "tilts head slightly with a contemplative expression and fingers to lips",
        "stares into mirror, reflecting both self and viewer with intensity",
        "plays with hair while leaning slightly forward with coy smile",
        "poses rigidly like a mannequin in a shop window display",
        "moves through fog with silhouette barely visible and arms outstretched",
        "holds a cigarette loosely between fingers for editorial edge",
        "interacts with the environment—touching a wall or tree thoughtfully",
        "stands isolated with strong directional lighting casting sharp shadows",
        "smiles softly while walking barefoot through puddles on wet pavement",
        "strikes a yoga-inspired pose on a rooftop with sunrise in background",
        "pushes hair back dramatically with one hand in windy conditions",
        "crosses legs slowly while seated on a concrete ledge",
        "turns quickly mid-step, creating motion blur and fabric movement",
        "places hand gently on hip while gazing off-camera dreamily",
        "winks playfully while adjusting oversized sunglasses",
        "stares directly into the camera with unshaken confidence",
        "kneels with one leg up, holding a clutch bag close to chest",
        "spins with arms wide open in a moment of pure joy",
        "walks away from the camera with long coat billowing behind",
        "leans forward with elbows on knees, looking up suggestively",
        "covers face partially with scarf for mystery and allure",
        "steps over a puddle with precision and grace",
        "poses in profile with exaggerated facial expression",
        "touches face lightly as if reacting to something unseen",
        "raises chin proudly with eyes closed and sun on skin",
        "clutches a garment tightly as if caught in emotion",
        "runs through a crowd with purpose and style",
        "pauses mid-motion with one foot lifted slightly off ground"
    ));
questions.add(actionQuestion);
        
        // Question 3: Background Features
        Question backgroundFeaturesQuestion = new Question(3, "Describe the background features of the image",
            List.of("Soft bokeh lights reflecting on wet pavement", "Snow-dusted peaks under alpenglow", "Pastel clouds painting the twilight sky", 
                    "Graffiti-covered walls telling urban stories", "Turquoise waves lapping at white sand", "Emerald canopy stretching to the horizon",
                    "Chaos of traffic-filled city streets", "Rolling hills kissed by morning mist", "Futuristic megastructures piercing clouds",
                    "Time-worn monuments standing against time", "Horizon bathed in amber sunset", "Fields of wildflowers swaying in breeze",
                    "Mountain range capped with eternal snow", "Dunes sculpted by desert winds", "Palm trees framing turquoise waters",
                    "Canopy of golden maple trees", "Blossoming cherry trees in spring", "Snow-blanketed pine forest", 
                    "Smoke-belching factory smokestacks", "Quaint countryside cottages", "Crystal-clear night sky filled with stars", 
                    "Rainbow after a summer storm", "Golden wheat fields waving", "Volcanic landscape glowing red-hot", 
                    "Coral reef teeming with marine life"));
        questions.add(backgroundFeaturesQuestion);
        
        // Question 4: Body Features
        Question bodyFeaturesQuestion = new Question(4, "Describe any specific body features of the subject (if applicable)",
            List.of("Athletic physique with defined musculature", "Poised posture radiating confidence", "Relaxed stance exuding comfort", 
                    "Kinetic energy in every movement", "Contemplative seated position", "Tense, ready-for-action stance", 
                    "Expressive hand gestures communicating emotion", "Eyes that tell a thousand stories", "Elaborate tattoos telling personal history",
                    "Designer clothing making bold statement", "Fluid movements like flowing water", "Purposeful stride commanding attention", 
                    "Playful twirl revealing joy", "Tranquil expression conveying peace", "Dynamic pose capturing motion", 
                    "Serene aura radiating calmness", "Intense gaze piercing through shadows", "Genuine smile lighting up the face", 
                    "Powerful build suggesting strength", "Delicate features evoking fragility", "Muscular definition showing discipline", 
                    "Graceful posture suggesting elegance", "Unconventional silhouette creating interest", "Contrapposto stance adding dynamism", 
                    "Proportional symmetry achieving balance"));
        questions.add(bodyFeaturesQuestion);
        
        // Question 5: Face Expression
        Question faceExpressionQuestion = new Question(5, "Choose the face expression of the subject (if applicable)",
            List.of("Radiant smile showing pure joy", "Stoic visage projecting determination", "Wide-eyed wonder at discovery", 
                    "Downcast eyes conveying melancholy", "Fierce glare expressing anger", "Raised eyebrows showing surprise", 
                    "Wistful look suggesting nostalgia", "Beaming grin of accomplishment", "Focused concentration on task", 
                    "Subtle smirk hinting mystery", "Open-mouthed awe at spectacle", "Nervous glance betraying anxiety", 
                    "Contented sigh showing satisfaction", "Pensive chin-stroke contemplating options", "Sparkling eyes full of mischief", 
                    "Furrowed brow wrestling with complexity", "Gentle laugh lines around eyes", "Steely resolve in jawline", 
                    "Dreamy gaze lost in thought", "Awkward grimace at social situation", "Tear-streaked cheeks showing sorrow", 
                    "Joyful laughter lines crinkling eyes", "Skeptical eyebrow arch questioning truth", "Peaceful slumber expression", 
                    "Manic grin bordering on madness"));
        questions.add(faceExpressionQuestion);
        
        // Question 6: Image Composition
        Question imageCompositionQuestion = new Question(6, "Choose the image composition",
            List.of("Rule of thirds with visual tension", "Centered symmetry creating order", "Leading road lines into distance", 
                    "Window frame within frame composition", "Perfect bilateral mirror symmetry", "Low-angle perspective exaggerating height", 
                    "Shallow depth focusing attention", "Cropped composition creating intimacy", "Vast negative space suggesting isolation", 
                    "Balanced elements across visual scale", "Architectural framing within framing", "Diagonal lightning splitting frame", 
                    "Triangular balance of elements", "Repeating patterns creating rhythm", "Eye-level connection with subject", 
                    "Minimalist composition emphasizing simplicity", "Isolated subject against plain backdrop", "High contrast tonal composition", 
                    "Juxtaposition of old and new elements", "Motion blur showing dynamic action", "Golden ratio spiral guiding eye", 
                    "Converging lines directing attention", "Foreground-middle-ground-background layering", "Reflection composition doubling impact", 
                    "Color blocking creating visual punch"));
        questions.add(imageCompositionQuestion);
        
        // Question 7: Emotion
        Question emotionQuestion = new Question(7, "Describe the overall emotion of the image",
            List.of("Exuberant celebration of life", "Quiet optimism about possibilities", "Tranquil serenity of nature", 
                    "Oppressive weight of despair", "Electric excitement of discovery", "Bittersweet longing for past", 
                    "Awe-inspiring grandeur of cosmos", "Warm familiarity of homecoming", "Intriguing enigma begging exploration", 
                    "Adrenaline-fueled intensity of action", "Meditative calm of stillness", "Childlike wonder at world", 
                    "Passionate fire of romance", "Thirst for adventure calling", "Deep contemplation of existence", 
                    "Mischievous delight in chaos", "Dramatic tension of conflict", "Fantasy escape from reality", 
                    "Empowering sense of achievement", "Reflective mood of introspection", "Curious examination of detail", 
                    "Hopeful dawn of new beginnings", "Melancholy end of era passing", "Majestic glory of nature", 
                    "Whimsical fancy of imagination"));
        questions.add(emotionQuestion);
        
        // Question 8: Style
        Question styleQuestion = new Question(8, "Describe the style",
            List.of("Instant film vintage aesthetic", "Miniature model tilt-shift effect", "Commercial product showcase", 
                    "Nighttime light-trail long exposure", "Classic portrait studio setup", "Color-pop vibrance against grayscale", 
                    "Black-and-white timeless appeal", "Sepia-toned historical feel", "Clean modern minimalism", 
                    "Dreamlike surreal fantasy", "Authentic documentary moment", "Urban street photography grit", 
                    "Panoramic landscape capture", "Extreme close-up macro details", "Architectural precision focus", 
                    "Runway fashion editorial shot", "Wildlife nature documentary style", "Action sports frozen-in-time shot", 
                    "Geometric abstract interpretation", "Photojournalistic storytelling", "Astrophotography deep-space view", 
                    "Underwater photography blue tone", "Macro insect photography", "Food photography styling", 
                    "Fine art nudes composition"));
        questions.add(styleQuestion);
        
        // Question 9: Camera Model and Lens
        Question cameraQuestion = new Question(9, "Choose the camera model and lens",
            List.of("Canon EOS R5 with RF 24-70mm f/2.8", "Nikon Z8 with Nikkor Z 70-200mm f/2.8", "Sony A1 with FE 16-35mm f/2.8 GM", 
                    "Leica M11 with Summilux 35mm f/1.4", "Hasselblad X2D with XCD 45mm f/3.5", "Fujifilm GFX100S with GF 32-64mm f/4", 
                    "Panasonic S1R with Lumix 24-105mm f/4", "Olympus OM-1 with M.Zuiko 12-40mm f/2.8", "Pentax K-3 Mark III with DA* 55mm f/1.4", 
                    "Phase One XT with IQ4 150MP back", "Canon 1DX Mark III with EF 400mm f/2.8", "Nikon D6 with Nikkor Z 24-120mm f/4 S", 
                    "Sony A7IV with FE 70-200mm f/2.8 GM", "Leica SL2-S with Vario-Elmarit 24-90mm f/2.8-4", "Hasselblad H6D with HC 100mm f/2.2", 
                    "Fujifilm X-T5 with XF 16-80mm f/4", "Panasonic GH6 with Leica 12-60mm f/2.8-4", "Olympus E-M1 Mark III with 40-150mm f/2.8 Pro", 
                    "Pentax K-1 II with HD FA 70-200mm f/2.8", "Phase One FX with 80mm f/2.8", "Sony ZV-E10 with E 16-50mm f/3.5-5.6 PZ", 
                    "GoPro Hero 11 with Max Lens Mod", "Drone-mounted Hasselblad L2D-20c", "iPhone 14 Pro with ProRAW enabled", 
                    "Samsung Galaxy S23 Ultra with 100x zoom"));
        questions.add(cameraQuestion);
        
        // Question 10: Magic Words
        Question magicWordsQuestion = new Question(10, "Choose magic words",
            List.of("HDR, UHD, 64K resolution", "Photographic perfection", "Professional lighting setup", "Award-winning quality", 
                    "Trending on 500px front page", "Game engine rendering", "Rich saturated colors", "Artistic shallow depth of field", 
                    "Film noir atmosphere", "Heroic grandeur", "Legendary scale", "Sublime beauty", "Motivational power", 
                    "Attention-grabbing composition", "Visually mesmerizing", "Iconic historical significance", 
                    "Timeless artistic value", "Masterful technique", "Gallery exhibition quality", "Commercial excellence", 
                    "Documentary authenticity", "Scientific accuracy", "Fashion-forward styling", "Adventure-ready spirit", 
                    "Technological innovation"));
        questions.add(magicWordsQuestion);
        
        // Collect responses
        List<String> responses = new ArrayList<>();
        for (Question q : questions) {
            String response = getResponse(q);
            responses.add(response);
        }
        
        // List of different angles
        List<String> angles = List.of("Low angle hero shot", "Bird's-eye overhead view", "Eye level intimate connection", 
                                      "Dutch angle tension", "Close-up facial detail", "Wide establishing shot", 
                                      "Three-quarter profile view", "Silhouette dramatic lighting", "Over-the-shoulder perspective", 
                                      "Ground-level bug view", "Dramatic worm's eye upward angle", "Cinematic two-shot framing", 
                                      "Dolly zoom vertigo effect", "Orbital rotating shot", "Point-of-view immersion", 
                                      "Tracking side movement", "Crane shot descent", "Telephoto compression", 
                                      "Aerial drone sweeping arc", "Zoom burst motion effect");
        
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
            if (!responses.get(9).isEmpty()) result.append("Magic Words: ").append(responses.get(9)).append("\n");
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