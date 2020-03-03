import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class javaChat extends JFrame {
    private JPanel mainPanel;
    private JButton sendButton;
    private JTextField writeText;
    private JList historyList;
    private JTextField ipText;
    private JTextField portText;
    private JButton newMsgButton;
    private JTextArea showMsg;


    public javaChat(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new javaChat("Chat");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}