import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGPTInterfaceb {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatGPTInterfaceb() {
        ChatApiAccessWithLibrary chatApiAccess = new ChatApiAccessWithLibrary();
        JFrame frame = new JFrame("ChatGPT Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Chat tab
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setWrapStyleWord(true);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        inputField = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                chatArea.append("You: " + userInput + "\n");
                String chatGPTResponse = "ChatGPT: " + chatApiAccess.getResponse(userInput) + "\n";
                chatArea.append(chatGPTResponse);
                inputField.setText("");
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        chatPanel.add(scrollPane, BorderLayout.CENTER);
        chatPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add chat panel to tabbed pane
        tabbedPane.addTab("Chat", chatPanel);

        // Another tab (e.g., Settings)
        JPanel settingsPanel = new JPanel();
        tabbedPane.addTab("Audio Convert", settingsPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}