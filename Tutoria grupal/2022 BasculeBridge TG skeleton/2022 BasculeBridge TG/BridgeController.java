
/**
 * Write a description of class BridgControler here.
 * 
 * @author ip-profes
 * @version 1-11-22
 */
public class BridgeController
{
    public static final boolean PRESSED = true;
    
    public static final int LEVER_DOWN = 0;
    public static final int LEVER_MIDDLE = 1;
    public static final int LEVER_UP = 2;
    public static final int INTERVAL = 30;
    
    
    
    // instance variables - replace the example below with your own
    private int lever;
    private boolean clutch;
    private BasculeBridge bridge;

    /**
     * Constructor for objects of class BridgControler
     */
    public BridgeController()
    {        
        setClutch(! PRESSED);
        setLever(LEVER_DOWN); 
        setBridge(new BasculeBridge(BasculeBridge.MIN_SLOPE));       
    }
    
     public BridgeController(int lever)
    {   
        this();
        setLever(lever);   
        bridge.raiseBridge(lever * slopeForLever());     
        
    }
    
    /**
     * Calcula la proporción de inclinación en relación con laa posición de palanca.
     * 
     * @return slope, inclinación del puente por posición
     */
    private int slopeForLever(){
        return (BasculeBridge.MAX_SLOPE - BasculeBridge.MIN_SLOPE) / (LEVER_UP - LEVER_DOWN);
    }
    
    /**
     * Modifica el valor del embrague
     * @param clutch
     */
    private void setClutch(boolean newClutch){
        this.clutch = newClutch;
    }
    
    /**
     * Modifica el valor del puente
     * @param bridge
     */
    private void setBridge(BasculeBridge bridge){
        checkParam(bridge != null, "null en lugar de bridge");
        this.bridge = bridge;
    }
    
    /**
     * Modifica el valor de la palanca y mueve el puente a la posición correcta
     * @param lever
     */
    private void setLever(int lever){
        checkParam(lever >= LEVER_DOWN && lever <= LEVER_UP, 
                   "palanca fuera de rango");
        this.lever = lever;
    }
    
    /**
     * @return clutch, valor del embrague PRESSED o !PRESSED
     */
    public boolean getClutch(){
        return clutch;
    }
    
    /**
     * @return bridge, valor del puente
     */
    public BasculeBridge getBridge(){
        return bridge;
    }
    
    /**
     * @return lever, valor de la palanca
     */
    public int getLever(){
        return lever;
    }
    
    /**
     * Cambia la presión del embrague
     */
    public void changeClutch(){
        setClutch(! getClutch());
    }
    
    /**
     * Si el embrague está presionado, cambia palanca a la posición recibida
     * y mueve el puente en consonancia
     * @param position nueva posición de la palanca
     */
    public void changeLever(int position){
        checkParam(position>= LEVER_DOWN && position <= LEVER_UP , "Posición fuera de límites");
        if (getClutch() == PRESSED){
           
                if (getLever() < position){
                    int slope = (position - getLever()) * slopeForLever();
                    bridge.raiseBridge(slope);
                } else if (getLever() > position) {
                    int slope = (getLever() - position) * slopeForLever();
                    bridge.dropBridge(slope);
                }
                setLever(position);
            }
    }
    
    
    /*
     * Comprueba si la posición está dentro de las permitidas
     */
    private boolean isGoodPosition(int position){
        return position >= LEVER_DOWN && position <= LEVER_UP;
    }
    
    /**
     * Valida el parámetro. Si no se cumple la condición salta
     * IllegalArgumentException
     * 
     */
    private void checkParam(boolean condition, String message){
        if (! condition) {
            throw new IllegalArgumentException(message);
        }
    }
    
    
    
    
}
