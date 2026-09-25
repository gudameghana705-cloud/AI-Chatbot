import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chatbot {

    private static List<Intent> intents = new ArrayList<>();
    private static List<FAQ> faqs = new ArrayList<>();

    private static final String FILE_NAME = "knowledge.txt";

    public static void createIntents() {

        intents.add(new Intent(
                "greeting",
                new String[]{"hello", "hi", "hey", "good morning", "good evening"},
                "Hello! How can I help you?"
        ));

        intents.add(new Intent(
                "java",
                new String[]{"java", "java language", "java programming"},
                "Java is a popular object-oriented programming language used to build many types of applications."
        ));

        intents.add(new Intent(
                "ai",
                new String[]{"artificial intelligence"},
                "AI stands for Artificial Intelligence. It allows computers to perform tasks that normally require human intelligence."
        ));

        intents.add(new Intent(
                "nlp",
                new String[]{"nlp", "natural language processing"},
                "NLP stands for Natural Language Processing. It helps computers understand and process human language."
        ));

        intents.add(new Intent(
                "machine_learning",
                new String[]{"machine learning", "machine-learning"},
                "Machine Learning is a branch of AI where computers learn patterns from data."
        ));

        intents.add(new Intent(
                "programming",
                new String[]{"programming", "coding", "program"},
                "Programming is the process of writing instructions that tell a computer what to do."
        ));

        intents.add(new Intent(
                "student",
                new String[]{"student", "college", "study"},
                "Students can learn programming, AI and other technologies to build useful projects."
        ));

        intents.add(new Intent(
                "help",
                new String[]{"help", "support"},
                "You can ask me about Java, AI, NLP, Machine Learning, programming, Python, MySQL and more."
        ));

        intents.add(new Intent(
                "thanks",
                new String[]{"thanks", "thank you", "thank"},
                "You're welcome! Happy to help."
        ));

        intents.add(new Intent(
                "goodbye",
                new String[]{"bye", "goodbye", "exit", "quit"},
                "Goodbye! Have a nice day!"
        ));
    }

    public static void createFAQs() {

        faqs.add(new FAQ(
                "what is java",
                "Java is a high-level, object-oriented programming language."
        ));

        faqs.add(new FAQ(
                "what is ai",
                "AI stands for Artificial Intelligence. It enables computers to perform intelligent tasks."
        ));

        faqs.add(new FAQ(
                "what is nlp",
                "NLP stands for Natural Language Processing. It helps computers understand human language."
        ));

        faqs.add(new FAQ(
                "what is machine learning",
                "Machine Learning is a part of AI where computers learn patterns from data."
        ));

        faqs.add(new FAQ(
                "what is programming",
                "Programming is the process of creating instructions for a computer."
        ));

        faqs.add(new FAQ(
                "what is chatbot",
                "A chatbot is a software application that communicates with users using text or speech."
        ));

        faqs.add(new FAQ(
                "what is computer science",
                "Computer Science is the study of computers, software, algorithms and computational systems."
        ));

        faqs.add(new FAQ(
                "what is python",
                "Python is a popular high-level programming language known for its simple syntax."
        ));

        faqs.add(new FAQ(
                "what is database",
                "A database is an organized collection of data that can be stored and accessed efficiently."
        ));

        faqs.add(new FAQ(
                "what is mysql",
                "MySQL is a popular relational database management system that uses SQL."
        ));
    }

    public static void loadKnowledge() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {

                    faqs.add(
                            new FAQ(parts[0], parts[1])
                    );
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Could not load saved knowledge."
            );
        }
    }

    public static void saveKnowledge(
            String question,
            String answer) {

        try {

            FileWriter writer =
                    new FileWriter(FILE_NAME, true);

            writer.write(
                    question + "|" + answer + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Could not save the new knowledge."
            );
        }
    }

    public static String checkFAQ(String message) {

        for (FAQ faq : faqs) {

            if (message.contains(
                    faq.getQuestion().toLowerCase())) {

                return faq.getAnswer();
            }
        }

        return null;
    }

    public static String checkIntent(String message) {

        for (Intent intent : intents) {

            for (String keyword :
                    intent.getKeywords()) {

                if (message.contains(
                        keyword.toLowerCase())) {

                    return intent.getResponse();
                }
            }
        }

        return null;
    }

    public static String getResponse(String message) {

        message = message.toLowerCase().trim();

        String faqResponse =
                checkFAQ(message);

        if (faqResponse != null) {
            return faqResponse;
        }

        String intentResponse =
                checkIntent(message);

        if (intentResponse != null) {
            return intentResponse;
        }

        return "Sorry, I don't understand that question. You can teach me using the Teach Bot button.";
    }

    public static void addLearnedFAQ(
            String question,
            String answer) {

        faqs.add(
                new FAQ(question, answer)
        );

        saveKnowledge(
                question,
                answer
        );
    }

    public static void teachChatbot(
            Scanner scanner) {

        System.out.println();
        System.out.println(
                "Bot: Let's learn something new!"
        );

        System.out.print(
                "Enter the question: "
        );

        String question =
                scanner.nextLine()
                        .toLowerCase()
                        .trim();

        System.out.print(
                "Enter the answer: "
        );

        String answer =
                scanner.nextLine().trim();

        if (question.isEmpty() ||
                answer.isEmpty()) {

            System.out.println(
                    "Bot: Question and answer cannot be empty."
            );

            return;
        }

        addLearnedFAQ(
                question,
                answer
        );

        System.out.println(
                "Bot: Great! I learned something new."
        );

        System.out.println(
                "Bot: I will remember this even after restarting."
        );

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        createIntents();

        createFAQs();

        loadKnowledge();

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "             JAVABOT AI CHATBOT"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Saved knowledge loaded."
        );

        System.out.println(
                "Type 'teach' to teach me something."
        );

        System.out.println(
                "Type 'bye' to exit."
        );

        System.out.println();

        while (true) {

            System.out.print("You: ");

            String userMessage =
                    scanner.nextLine();

            if (userMessage.equalsIgnoreCase(
                    "teach")) {

                teachChatbot(scanner);

                continue;
            }

            String response =
                    getResponse(userMessage);

            System.out.println(
                    "Bot: " + response
            );

            System.out.println();

            if (userMessage.equalsIgnoreCase("bye") ||
                    userMessage.equalsIgnoreCase("exit") ||
                    userMessage.equalsIgnoreCase("quit")) {

                break;
            }
        }

        scanner.close();
    }
}