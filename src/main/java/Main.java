import util.PropertyUtil;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatGPTInterface::new);
        PropertyUtil.makeInstance();
    }
}
