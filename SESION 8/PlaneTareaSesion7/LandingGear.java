
/**
 * Tren de aterrizaje con palanca y 3 puntales
 * dos a izquierda y derecha y uno en el morro
 * 
 * David Covián Gómez
 * 04/11/2022
 */
public class LandingGear
{
    public static final boolean LEVER_UP = true;
    public static final boolean LEVER_DOWN = false;
    
    private boolean lever;           // palanca del tren de aterrizaje
    private WheelStrut left;         // puntal izquierdo
    private WheelStrut right;        // puntal derecho
    private WheelStrut nose;         // puntal del morro
    
    
    /**
     * Constructor for objects of class LandingGear
     * Palanca posición baja y los tres puntales desplegados
     */
    public LandingGear()
    {
        this.setLever(LEVER_DOWN);
        this.setLeft(new WheelStrut());
        this.setRight(new WheelStrut());
        this.setNose(new WheelStrut());
        
        this.getLeft().deploy();
        this.getNose().deploy();
        this.getRight().deploy();
    }
    
    /**
     * Constructor con tres parámetros
     * 
     * @param puntal izquierdo
     * @param puntal derecho
     * @param puntal del morro
     * Palanca en posición baja y los tres puntales desplegados
     * 
     */
    public LandingGear(WheelStrut left, WheelStrut right, WheelStrut nose)
    {
        this();
        this.setLever(LEVER_DOWN);
        this.setLeft(left);
        this.setRight(right);
        this.setNose(nose);
        
        this.getLeft().deploy();
        this.getNose().deploy();
        this.getRight().deploy();
    }

    /**
     * Modifica el valor del atributo lever
     * 
     * @param  newLever, nuevo valor para la palanca
     * 
     */
    private void setLever(boolean newLever)
    {
        this.lever = newLever;
    }
    
    /**
     * Modifica el valor del atributo left
     * 
     * @param  newLeft, nuevo valor para el puntal izquierdo
     * 
     */
    private void setLeft(WheelStrut newLeft)
    {
        checkParam(newLeft!=null, "Esperaba puntal izquierdo en lugar de null");
        this.left = newLeft;
    }
    
    /**
     * Modifica el valor del atributo right
     * 
     * @param  newRight, nuevo valor para el puntal derecho
     * 
     */
    private void setRight(WheelStrut newRight)
    {
        checkParam(newRight!=null, "Esperaba puntal derecho en lugar de null");
        this.right = newRight;
    }
    
    /**
     * Modifica el valor del atributo nose
     * 
     * @param  newNose, nuevo valor para el puntal morro
     * 
     */
    private void setNose(WheelStrut newNose)
    {
        checkParam(newNose!=null, "Esperaba puntal derecho en lugar de null");
        this.nose = newNose;
    }
    
    /**
     * @return valor de la palanca
     */
    public boolean getLever() {
        return this.lever;
    }
    
    /**
     * @return valor del puntal izquierdo
     */
    public WheelStrut getLeft() {
        return this.left;
    }
    
    /**
     * @return valor del puntal derecho
     */
    public WheelStrut getRight() {
        return this.right;
    }
    
    /**
     * @return valor del puntal izquierdo
     */
    public WheelStrut getNose() {
        return this.nose;
    }
    
    /**
     * Mueve la palanca
     * Si la mueve hacia arriba implica subir el tren de aterrizaje, es decir
     * los puntales se repliegan
     * Si la mueve hacia abajo los puntales se despliegan
     */
    public void moveLever (boolean action) 
    {
        if(action==LEVER_UP && this.getLever()==LEVER_DOWN)
        {
            this.setLever(LEVER_UP);
            this.getLeft().retract();
            this.getRight().retract();
            this.getNose().retract();
        }
        else if(action==LEVER_DOWN && this.getLever()==LEVER_UP)
        {
            this.setLever(LEVER_DOWN);
            this.getLeft().deploy();
            this.getRight().deploy();
            this.getNose().deploy();
        }
    }
        
    /**
     * Test del tren de aterrizaje
     * @return true, si el método test() de todos los puntales devuelve true, y false, en otro caso.
     */
    public boolean test()
    {
       return this.getLeft().test()==true && this.getNose().test()==true && this.getRight().test()==true;
    }
    
    /**
     * Validación de parámetro
     * @param condición
     * @param mensaje
     */
    private void checkParam(boolean condition, String cause) {
        if (! condition) {
            throw new IllegalArgumentException(cause);
        }
    }
    
    /**
     * Método print de la clase LandingGear
     */
    public void print()
    {
        if(getLever()==true)
        {
            System.out.println("Palanca hacia arriba");
        }
        else
        {
            System.out.println("Palanca hacia abajo");
        }
    }
}
