public class manageHistory {
    int[] ports;
    public String[] messages;
    public boolean checkExistance(int portNumber){
        for(int i=0 ; i<ports.length; i++){
            if(portNumber==ports[i]){
                return true;
            }
        }
        return false;
    }
    public int getPosition(int port){
        for(int i=0; i<ports.length; i++){
            if(port==ports[i]){
                return i;
            }
        }
    }
    public void setText(int port, String message){
        if(checkExistance(port)){
            messages[getPosition(port)]=this.messages[getPosition(port)]+message;

        }
        else{
            ports[ports.length]=port;
            messages[messages.length]=message;
        }
        javaChat.showMsg.setText(messages[getPosition(port)]);
    }
}
