package event.data;

/**
 *
 * @author mpanagrosso
 */
public class KeyTypedData implements IExchangeData {

    String keysTyped;
    String caller;

    public KeyTypedData() {
    }

    public KeyTypedData(String keysTyped, String caller) {
        this.keysTyped = keysTyped;
        this.caller = caller;

    }

    public String getKeyTyped() {
        return keysTyped;
    }

    public String getCaller(){
        return caller;
    
    }
}
