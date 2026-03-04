
/**
 * Clase Switch
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Switch
{
    private boolean button; //Atributo que representa el botón (true-->ON, false-->OFF)
    
    /**
     * Constante que indica que el botón esta en ON
     */
    public static final boolean ON = true;
    /**
     * Constante que indica que el botón esta en OFF
     */
    public static final boolean OFF = false;
    
    /**
     * Constructor por defecto de la clase Switch.
     */
    public Switch()
    {
        
    }
    
    /**
    * Método que devuelve el valor booleano del atributo
    * @return Valor booleano de button.
    */
   public boolean getButton()
   {
     return button;
    }
    
    /**
     * Método que cambia el estado del botón cada vez que se invoca.
     */
    public void press()
    {
        if(button==true)
        {
            button=false;
        }
        
        else
        {
            button=true;
        }
    }
    
    /**
     * Método que devuelve el estado del botón
     * @return Estado del botón.
     */
    public String toString()
    {
        if(button==ON)
        {
            return "ON";
        }
        else
        {
            return "OFF";
        }
    }
    
}
