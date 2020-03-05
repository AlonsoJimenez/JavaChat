import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * esta clase maneja un historial para poder almacenar los mensajes y no desordenar conversaciones, igualmente verifica si el mensaje recibido pertenece a una conversacion previamente existenete o si es un uevo ususario.
 */
public class manageHistory {
    int[] ports;

    /**
     *
     * @return convierte la lista de int en una de strings para ser agregados a la Jlist
     */
    String[] listData(){
        for(int i=0; i<ports.length; i++){
            listData()[i]=Integer.toString(ports[i]);
        }
        return listData();
    }
    public String[] messages;

    /**
     *
     * @param portNumber
     * @return evaluacion si es un usuario nuevo o no.
     */
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
        return 0;
    }
    public void setText(int port, String message){
        if(checkExistance(port)){
            messages[getPosition(port)]=this.messages[getPosition(port)]+message;

        }
        else{
            ports[ports.length]=port;
            messages[messages.length]=message;
            this.refreshList();
        }
        javaChat.showMsg.setText(messages[getPosition(port)]);
    }
    public void refreshList(){
        javaChat.historyList.setListData(listData());
    }
}
