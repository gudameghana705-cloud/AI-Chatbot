import javax.swing.*;
import java.awt.*;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;
    private JButton teachButton;

    public ChatbotGUI() {

        setTitle("JavaBot AI Chatbot");
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titleLabel =
                new JLabel("🤖 JavaBot AI Chatbot");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        JLabel subtitleLabel =
                new JLabel("Your simple Java-based intelligent assistant");

        subtitleLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(
                new BoxLayout(titlePanel, BoxLayout.Y_AXIS)
        );

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        clearButton = new JButton("Clear Chat");

        headerPanel.add(
                clearButton,
                BorderLayout.EAST
        );

        add(headerPanel, BorderLayout.NORTH);

        // ================= CHAT AREA =================

        chatArea = new JTextArea();

        chatArea.setEditable(false);
        chatArea.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        chatArea.setMargin(
                new Insets(15, 15, 15, 15)
        );

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ================= INPUT AREA =================

        JPanel bottomPanel =
                new JPanel(new BorderLayout(10, 10));

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        inputField = new JTextField();

        inputField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        inputField.setToolTipText(
                "Type your message here..."
        );

        sendButton = new JButton("Send");

        sendButton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        teachButton = new JButton("Teach Bot");

        teachButton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        bottomPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                sendButton,
                BorderLayout.EAST
        );

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        5
                )
        );

        buttonPanel.add(teachButton);

        bottomPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // ================= WELCOME MESSAGE =================

        chatArea.append(
                "Bot: Hello! 👋\n"
                + "I am JavaBot, your AI assistant.\n"
                + "Ask me about Java, AI, NLP, Machine Learning and more.\n\n"
        );

        // ================= SEND =================

        sendButton.addActionListener(
                e -> sendMessage()
        );

        // ================= ENTER KEY =================

        inputField.addActionListener(
                e -> sendMessage()
        );

        // ================= CLEAR =================

        clearButton.addActionListener(e -> {

            chatArea.setText("");

            chatArea.append(
                    "Bot: Chat cleared! 👋 "
                    + "How can I help you?\n\n"
            );
        });

        // ================= TEACH BOT =================

        teachButton.addActionListener(
                e -> teachBot()
        );
    }

    // ================= SEND MESSAGE =================

    private void sendMessage() {

        String userMessage =
                inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        chatArea.append(
                "You: " + userMessage + "\n"
        );

        String botResponse =
                Chatbot.getResponse(userMessage);

        chatArea.append(
                "Bot: " + botResponse + "\n\n"
        );

        inputField.setText("");

        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }

    // ================= TEACH BOT =================

    private void teachBot() {

        String question =
                JOptionPane.showInputDialog(
                        this,
                        "Enter the question you want me to learn:",
                        "Teach JavaBot",
                        JOptionPane.QUESTION_MESSAGE
                );

        if (question == null ||
                question.trim().isEmpty()) {

            return;
        }

        String answer =
                JOptionPane.showInputDialog(
                        this,
                        "Enter the answer:",
                        "Teach JavaBot",
                        JOptionPane.QUESTION_MESSAGE
                );

        if (answer == null ||
                answer.trim().isEmpty()) {

            return;
        }

        question =
                question.toLowerCase().trim();

        answer =
                answer.trim();

        // Add to chatbot memory
        Chatbot.addLearnedFAQ(
                question,
                answer
        );

        chatArea.append(
                "You taught me: "
                + question + "\n"
        );

        chatArea.append(
                "Bot: Great! I learned something new "
                + "and will remember it.\n\n"
        );
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        Chatbot.createIntents();
        Chatbot.createFAQs();
        Chatbot.loadKnowledge();

        SwingUtilities.invokeLater(() -> {

            ChatbotGUI gui =
                    new ChatbotGUI();

            gui.setVisible(true);
        });
    }
}