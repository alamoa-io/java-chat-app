import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class ChatGPTInterface {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatGPTInterface() {
        ChatApiAccessWithLibrary chatApiAccess = new ChatApiAccessWithLibrary();
        ChatApiAccessWithOfficialLibrary officialLibraryAccess = new ChatApiAccessWithOfficialLibrary();
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

        JScrollPane scrollPane = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

        // Audio Convert tab
        JPanel audioPanel = new JPanel(new BorderLayout());
        JTextArea audioResponseArea = new JTextArea();
        audioResponseArea.setEditable(false);
        audioResponseArea.setWrapStyleWord(true);
        audioResponseArea.setLineWrap(true);
        JScrollPane audioScrollPane = new JScrollPane(audioResponseArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton selectFileButton = new JButton("Select File");

        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    Path selectedFile = fileChooser.getSelectedFile().toPath();
                    String response = officialLibraryAccess.getResponse(selectedFile);
                    audioResponseArea.setText(response);
                }
            }
        });

        audioPanel.add(audioScrollPane, BorderLayout.CENTER);
        audioPanel.add(selectFileButton, BorderLayout.SOUTH);

        // Add audio panel to tabbed pane
        tabbedPane.addTab("Audio Convert", audioPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}