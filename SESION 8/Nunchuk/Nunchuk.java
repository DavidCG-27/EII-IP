
/**
 * Write a description of class Nunchuk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nunchuk
{
    private Figure figure_nunchuk; //Figura de la clase Figure()
    private Weapon weapon_nunchuk;//Arma de la clase Weapon()
    
    /**
     * Constructor por defecto
     */
    public Nunchuk()
    {
        figure_nunchuk=new Figure("Monstruo",10,10);
        weapon_nunchuk=new Weapon("Pistola",50);
    }
    
    /**
     * Constructor por parámetros
     */
    public Nunchuk(Figure figure, Weapon weapon)
    {
        Figure f=new Figure();
        Weapon w=new Weapon(); 
        
        this.setFigure(f);
        this.setWeapon(w);
    }
    
    /**
     * Permite modificar el atributo figure
     * @param figure
     */
    private void setFigure(Figure f)
    {
        this.figure_nunchuk=f;
    }
    
    /**
     * Permite modificar el atributo weapon
     * @param weapon
     */
    private void setWeapon(Weapon weapon)
    {
        this.weapon_nunchuk=weapon_nunchuk;
    }
    
    /**
     * Devuelve el valor de figure
     * @return figure
     */
    public Figure getFigure()
    {
        return figure_nunchuk;
    }
    
    /**
     * Devuelve el valor de weapon
     * @return weapon
     */
    public Weapon getWeapon()
    {
        return weapon_nunchuk;
    }
    
    /**
     * Indicando la dirección hacia donde debe avanzar el personaje, se desplazará un paso.
     * @param movement
     */
    public void advance(char movement)
    {
        figure_nunchuk.move(movement);
    }
    
    /**
     * Indicando la dirección hacia donde debe avanzar el personaje, se desplazará dos paso.
     * @param movement
     */
    public void midleAdvance(char movement)
    {
         figure_nunchuk.move(movement);
         figure_nunchuk.move(movement);
    }
    
    /**
     * Indicando la dirección hacia donde debe avanzar el personaje, se desplazará dos paso.
     * @param movement
     */
    public void muchAdvance(char movement)
    {
        figure_nunchuk.move(movement);
        figure_nunchuk.move(movement);
        figure_nunchuk.move(movement);
        figure_nunchuk.move(movement);
        figure_nunchuk.move(movement);
    }
    
    /**
     * Si es true disparará 5 veces, si es false dispara 1 vez
     */
    public void shootWeapon(boolean value)
    {
        if (value==true)
        {
            weapon_nunchuk.shoot();
            weapon_nunchuk.shoot();
            weapon_nunchuk.shoot();
            weapon_nunchuk.shoot();
            weapon_nunchuk.shoot();
        }
        else
        {
            weapon_nunchuk.shoot();
        }
    }
    
    /**
     * Avanza un paso a la dirección indicada y dispara.
     * @param movement
     */
    public void shootForward(char movement)
    {
        figure_nunchuk.move(movement);
        weapon_nunchuk.shoot();
    }
    
    /**
     * Imprime los métodos toString de las clases Figure y Weapon
     * @return String imprime de ambas clases
     */
    public void print()
    {
        System.out.println(figure_nunchuk.toString() + "-" + weapon_nunchuk.toString());
    }
    
}
