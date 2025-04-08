import java.util.Scanner;

public class PromptGenerator {
    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_GREEN = "\033[1;32m";
    private static final String ANSI_BLUE = "\033[1;34m";
    private static final String ANSI_YELLOW = "\033[1;33m";

    public static void main(String[] args) {
        PromptBuilder promptBuilder = new PromptBuilder();
        String result = promptBuilder.buildPrompt();
        System.out.println(ANSI_YELLOW + "Generated Prompt:" + ANSI_RESET);
        System.out.println(result);
    }

    private static class PromptBuilder {
        private String result;
        private Scanner scanner = new Scanner(System.in);

        public String buildPrompt() {
            result = "";
            gatherGoal();
            gatherContext();
            gatherWarnings();
            gatherExample();
            return result;
        }

        private void gatherGoal() {
            printHeader("Final Goal");
            printPrompt("What is the primary objective you want the AI to achieve?");
            String goal = readInputWithConfirmation();
            result = goal;
        }

        private void gatherContext() {
            printHeader("Context");
            printPrompt("Please provide any relevant background or context.");
            String context = readInputWithConfirmation();
            result += " | Context: " + context;
        }

        private void gatherWarnings() {
            printHeader("Warnings/Constraints");
            printPrompt("List any constraints or warnings for the AI.");
            String warnings = readInputWithConfirmation();
            result += " | Warnings: " + warnings;
        }

        private void gatherExample() {
            printHeader("Example");
            printPrompt("Provide an example of what you expect.");
            String example = readInputWithConfirmation();
            result += " | Example: " + example;
        }

        private String readInputWithConfirmation() {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                System.out.print("Confirm: " + input + " [y/n]: ");
                String confirmation = scanner.nextLine().trim();
                if (confirmation.equalsIgnoreCase("y")) {
                    return input;
                }
            }
        }

        private void printHeader(String message) {
            System.out.println(ANSI_GREEN + "== " + message + " ==" + ANSI_RESET);
        }

        private void printPrompt(String message) {
            System.out.println(ANSI_BLUE + message + ANSI_RESET);
        }
    }
}
