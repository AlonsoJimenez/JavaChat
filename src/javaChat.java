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
    public  JList historyListReal;
    public  JTextArea showMsgReal;
    private JTextField ipText;
    private JTextField portText;
    private JButton newMsgButton;
    private JButton selectButton;
    private int portNumber = socketToReceive.realPort(socketToReceive.port);
    public static JList historyList;
    public static JTextArea showMsg;
    public void setValues(){
        this.showMsgReal=showMsg;
        this.historyListReal=historyList;
    }

    public javaChat(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setValues();
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
                if (false){
                    try {
                        socketToSend.theSocketClient.close();
                        socketClient socketToSend = new socketClient("127.0.0.1",port);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }}else{
                        try {
                            socketClient socketToSend = new socketClient("127.0.0.1",port);
                            socketToSend.inConversation=true;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberSelected = (int) historyList.getSelectedValue();
                history.setText(numberSelected, "");
                if (socketToSend.inConversation){
                    try {
                        socketToSend.disconnect();
                        socketClient socketToSend = new socketClient("127.0.0.1",numberSelected);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }}
                    else{
                        try {
                            socketClient socketToSend = new socketClient("127.0.0.1",numberSelected);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args){
        JFrame frame= new javaChat("Chat1");
        JFrame frame2= new javaChat("chat2");
        frame.setVisible(true);
        frame2.setVisible(true);
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}