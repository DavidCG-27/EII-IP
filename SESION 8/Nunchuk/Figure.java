
/**
 * Write a description of class Figure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figure
{
   private String name; //Nombre del personaje
   private int xPos; //Posición de la coordenada x del personaje
   private int yPos; //Posición de la coordenada y del personaje
   
   /**
    * Constante que indica el borde inferior de la pantalla de la coordenada x
    */
   public static final int X_LOWER_EDGE = 0;
    /**
    * Constante que indica el borde inferior de la pantalla de la coordenada y
    */
   public static final int Y_LOWER_EDGE = 0;
    /**
    * Constante que indica el borde superior de la pantalla de la coordenada x
    */
   public static final int X_UPPER_EDGE = 640;
   /**
    * Constante que indica el borde superior de la pantalla de la coordenada y
    */
   public static final int Y_UPPER_EDGE = 320;
   /**
    * Constante de tipo char que indica el movimiento (Izqda.)
    */
   public static final char LEFT = 'L';
   /**
    * Constante de tipo char que indica el movimiento (Dcha.)
    */
   public static final char RIGHT = 'R';
   /**
    * Constante de tipo char que indica el movimiento (Abajo)
    */
   public static final char DOWN = 'D';
   /**
    * Constante de tipo char que indica el movimiento (Arriba)
    */
   public static final char UP = 'U';
   /**
    * Constante que indica la distancia en pixeles
    */
   public static final int STEP = 10;
   

    /**
    * Constructor por defecto con nombre "Monstruo" y coordenadas (0,0)
    */
    public Figure()
    {
       this.setName("Monstruo");
       this.setXPos(X_LOWER_EDGE);
       this.setYPos(Y_LOWER_EDGE);
    }
    
    /**
     * Constructor por parámetros.
     */
    public Figure(String name, int xPos, int yPos)
    {
        this();
        this.setName(name);
        this.setXPos(xPos);
        this.setYPos(yPos);    
    }
    
    /**
     * Permite modificar el nombre de la figura
     * @param name Nombre
     */
    private void setName(String name)
    {
        this.name=name;
    }
    
    /**
     * Permite modificar la coordenada x de la figura (atendiendo a los límites establecidos)
     * @param xPos Coordenada x
     */
    private void setXPos(int xPos)
    {
        checkParam(xPos>=X_LOWER_EDGE && xPos<=X_UPPER_EDGE, "Coordenada fuera de rango");
        this.xPos=xPos;
    }
    
    /**
     * Permite modificar la coordenada y de la figura (atendiendo a los límites establecidos)
     * @param yPos Coordenada y
     */
    private void setYPos(int yPos)
    {
        checkParam(yPos>=Y_LOWER_EDGE && yPos<=Y_UPPER_EDGE, "Coordenada fuera de rango");
        this.yPos=yPos;
    }
    
     /**
     * Lanza un error cuando no se cumplen las condiciones.
     */
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false) {
            throw new IllegalArgumentException(errorMsg); 
        }
    }
    
    /**
     * Devuelve el valor del nombre de la figura
     * @return Nombre
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Devuelve el valor de la coordenada x
     * @return Coordenada x
     */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * Devuelve el valor de la coordenada y
     * @return Coordenada y
     */
    public int getYPos()
    {
        return yPos;
    }
    
    /**
     *  Indica la dirección de movimiento del personaje. 
     *  Si recibe LEFT o RIGHT se mueve un paso adelante o atrás en el eje X. 
     *  Si recibe UP o DOWN se mueve un paso arriba o abajo en el eje Y. 
     *  Si al moverse se pasa del borde de la pantalla no se ejecuta el movimiento (no cambia la posición).
     *  @param movement
     */
    public void move(char movement)
    {
        if (movement==LEFT)
        {
            this.setXPos(this.xPos-1);
        }
        else if(movement==RIGHT)
        {
            this.setXPos(this.xPos+1);
        }
        else if(movement==UP)
        {
            this.setYPos(this.yPos+1);
        }
        else if(movement==DOWN)
        {
            this.setYPos(this.yPos-1);
        }
        else
        {}
    }
    
    /**
     * Devuelve un String con el nombre y las coordenadas. Todo concatenado.
     * @return String
     */
    public String toString()
    {
        return getName() + "-" + getXPos() + "-" + getYPos();
    }
}
