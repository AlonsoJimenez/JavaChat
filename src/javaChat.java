import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;


public class javaChat extends JFrame {
    public socketServer socketToReceive= new socketServer();
    manageHistory history;
    public socketClient socketToSend;
    private JPanel mainPanel;
    private JButton sendButton;
    private JTextField writeText;
    public static JList historyList;
    private JTextField ipText;
    private JTextField portText;
    private JButton newMsgButton;
    public static JTextArea showMsg;
    private JButton selectButton;
    private int portNumber = socketToReceive.realPort(socketToReceive.port);


    public javaChat(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message= writeText.getText();
                socketToSend.sendMessage(Integer.toString(portNumber)+"%"+message+"\n");
                history.setText(portNumber,"ME:\n"+message);
            }
        });
        newMsgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip=ipText.getText();
                int port = (int) Double.parseDouble((portText.getText()));
                try {
                    socketClient socketToSend = new socketClient(ip,port);
                    socketToSend.inConversation=true;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberSelected = (int) historyList.getSelectedValue();
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