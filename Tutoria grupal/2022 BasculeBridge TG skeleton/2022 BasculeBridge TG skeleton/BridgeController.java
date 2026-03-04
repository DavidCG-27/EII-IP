
/**
 * 
 * 
 * @author 
 * @version 
 */
public class BridgeController
{
    /**
     * Posición del embrague
     */
    public static final boolean PRESSED = true;    
    /**
     * Posición mínima de la palanca, corresponde a 0 inclinación del puente 
     */
    public static final int LEVER_DOWN = 0;
    /**
     * Posición media de la palanca, corresponde a 30 grados inclinación del puente 
     */
    public static final int LEVER_MIDDLE = 1;
    /**
     * Posición máxima de la palanca, corresponde a 60 grados inclinación del puente 
     */
    public static final int LEVER_UP = 2;
    /**
     * Ángulo que se mueve el puente de una posición a otra
     */
    public static final int INTERVAL = 30;
    
    //# public static final int INTERVAL (...)
    
    
    
    private int lever;              // palanca
    private boolean clutch;         // embrague
    private BasculeBridge bridge;   // puente

    /**
     * Constructor que deja 
     * el embrague NO presionado, 
     * la palanca abajo 
     * y el puente congruente con la palanca
     */
    public BridgeController()
    {        
       BasculeBridge b=new BasculeBridge(BasculeBridge.MIN_SLOPE);
       
       this.setBridge(b);
       this.setClutch(false);
       this.setLever(LEVER_DOWN);
       
    }
    
    /**
     * Constructor que recibe la palanca 
     * deja el embrague por defecto y el puente en la posición
     * que se corresponde con la palanca recibida
     * @param lever, posición de la palanca
     */
     public BridgeController(int lever)
    {        
        this();
        this.setLever(lever);
        bridge.raiseBridge(lever * INTERVAL);
    }
    
    
    
    /**
     * Modifica el valor del embrague
     * @param clutch
     */
    private void setClutch(boolean newClutch){
        this.clutch=newClutch;
    }
    
    /**
     * Modifica el valor del puente
     * @param bridge
     */
    private void setBridge(BasculeBridge bridge){
        checkParam(bridge!=null, "null en lugar de bridge");
        this.bridge = bridge;
    }
    
    /**
     * Modifica el valor de la palanca y mueve el puente a la posición correcta
     * @param lever
     */
    private void setLever(int lever)
    {
       checkParam(lever==LEVER_UP || lever==LEVER_DOWN || lever==LEVER_MIDDLE, "Posición incorrecta");
       this.lever=lever;
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
     * Cambia la presión del embrague. Si estaba presionada la deja no presionada y viceversa
     */
    public void changeClutch()
    {
        if (clutch==true)
        {
            setClutch(false);
        }
        else
        {
            setClutch(true);
        }
    }
    
    /**
     * Si el embrague está presionado, cambia palanca a la posición recibida
     * y mueve el puente en consonancia
     * Si la posición no es correcta salta excepción con mensaje "Posición fuera de límites"
     * @param position nueva posición de la palanca
     */
    public void changeLever(int position)
    {
       checkParam(position>=LEVER_DOWN,"Posición por debajo de rango");
       checkParam(position<=LEVER_UP, "Posición por encima de rango");
       if (getClutch()==PRESSED)
       {
            if (getLever() < position)
            {
                int slope=(position - getLever())*INTERVAL;
                bridge.raiseBridge(slope);
            }
            else if(getLever() > position)
            {
                int slope=(getLever() - position)*INTERVAL;
                bridge.raiseBridge(slope);
            }
            setLever(position);
        }
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
