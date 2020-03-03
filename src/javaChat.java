import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class javaChat extends JFrame {
    public socketClient socketToSend;
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
                String message= writeText.getText();
                socketToSend.sendMessage(message);
            }
        });
        newMsgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ip = (int) Double.parseDouble(ipText.getText());
                int port = (int) Double.parseDouble((portText.getText()));
                try {
                    socketClient socketToSend = new socketClient(ip,port);
                    socketToSend.inConversation=true;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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