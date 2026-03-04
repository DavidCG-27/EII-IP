

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    private String name; //Nombre del arma
    private int ammunition; //Cantidad de munición
    
    /**
     * Construtor por defecto. Pistola de 100 balas
     */
    public Weapon()
    {
       this.setName("Pistola");
       this.setAmmunition(100);
    }
    
    /**
     * Construtor por parámetros
     * @param name Nombre
     * @param ammunition Munición
     */
    public Weapon(String name, int ammunition)
    {
       this.setName(name);
       this.setAmmunition(ammunition);
    }
    
     /**
     * Permite modificar el nombre del arma
     * @param name Nombre
     */
    private void setName(String name)
    {
        checkParam(name!=null && name!="".trim(), "null o cadena vacía");
        this.name=name.trim();
    }
    
     /**
     * Permite modificar la munición del arma.
     * @param ammunition Munición
     */
    private void setAmmunition(int ammunition)
    {
        checkParam(ammunition>=0, "Munición no permitida");
        this.ammunition=ammunition;
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
     * Devuelve el valor del nombre del arma.
     * @return Nombre
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Devuelve el valor de la munición
     * @return Munición
     */
    public int getAmmunition()
    {
        return ammunition;
    }
    
    /**
     * Método que, si hay munición, imprime BANG en pantalla y disminuye una unidad la munición
     */
    public void shoot()
    {
        if (ammunition!=0)
        {
            setAmmunition(ammunition-1);
            System.out.println("BANG");
            System.out.println();
        }
    }
    
    /**
     * Devuelve un String con el nombre y la munición. Todo concatenado.
     * @return String
     */
    public String toString()
    {
        return getName() + "-" + getAmmunition();
    }
}

