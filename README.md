JavaBot AI Chatbot
Project Description

JavaBot is a simple AI chatbot developed using Java. It can communicate with users through a graphical user interface and provide responses to common questions.

The chatbot uses rule-based intent detection and a FAQ knowledge base. It also supports a learning feature that allows users to teach the chatbot new questions and answers.

Features
Simple AI chatbot using Java
Rule-based keyword matching
Intent-based responses
FAQ knowledge base
Persistent knowledge storage
Teach Bot feature
Java Swing graphical user interface
Send and Clear Chat buttons
Supports Java, AI, NLP, Machine Learning and other topics
Learned questions remain available after restarting the application
Technologies Used
Java
Java Swing
Object-Oriented Programming
File Handling
Collections
Rule-Based AI
VS Code
Project Structure
AI-Chatbot/
│
├── Chatbot.java
├── ChatbotGUI.java
├── Intent.java
├── FAQ.java
├── knowledge.txt
└── README.md
How It Works

The chatbot follows these steps:

The user enters a question.
The chatbot converts the message into lowercase text.
It first checks the FAQ knowledge base.
If no FAQ matches, it checks the defined intents.
If a matching intent is found, the corresponding response is displayed.
If no match is found, the chatbot asks the user to teach it.
New questions and answers can be saved permanently in knowledge.txt.
Learning Feature

The chatbot includes a Teach Bot feature.

The user can enter:

Question:

what is github

Answer:

GitHub is a platform used to store and manage code.

The new information is saved in knowledge.txt, allowing the chatbot to remember it after restarting.

How to Run
Compile the project
javac Intent.java FAQ.java Chatbot.java ChatbotGUI.java
Run the GUI
java ChatbotGUI
Example Questions
hello
what is java
what is ai
what is nlp
what is machine learning
what is python
what is mysql
what is cloud computing
what is cybersecurity
what is web development
Future Enhancements
Voice input and output
More advanced Natural Language Processing
Database integration
Online knowledge retrieval
Machine Learning-based responses
User authentication
Chat history storage
Conclusion

JavaBot demonstrates how Java can be used to create a simple intelligent chatbot using rule-based AI, FAQ matching, file handling, and a graphical user interface