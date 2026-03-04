

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WeaponTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WeaponTest
{
    /**
     * Default constructor for test class WeaponTest
     */
    public WeaponTest()
    {
    }

    /**
     * Pruebas del constructor sin parámetros
     * Caso único:
     */
    @Test
    public void constWithoutParams()
    {
        Weapon w=new Weapon();
        
        assertEquals("Pistola", w.getName());
        assertEquals(100,w.getAmmunition());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 1: todo correcto
     */
    @Test
    public void constWithParams()
    {
        Weapon w=new Weapon("Metralleta",30);
        
        assertEquals("Metralleta", w.getName());
        assertEquals(30,w.getAmmunition());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 2: Ammunition igual a 0
     */
    @Test
    public void constWithAmmunEqual0()
    {
        Weapon w=new Weapon("Metralleta",0);
        
        assertEquals("Metralleta", w.getName());
        assertEquals(0,w.getAmmunition());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 3: Ammunition igual a 0
     */
    @Test
    public void constWithAmmunAboveLimits()
    {
        try
        {
            Weapon w=new Weapon("Metralleta",-10);
            fail("Munición incorrecta");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Munición no permitida", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 4: name igual a null
     */
    @Test
    public void constWithNameEqualNull()
    {
        try
        {
            Weapon w=new Weapon(null,100);
            fail("Name incorrecto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("null o cadena vacía", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 5: name igual a blanco
     */
    @Test
    public void constWithNameEqualSpace()
    {
        try
        {
            Weapon w=new Weapon("",100);
            fail("Name incorrecto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("null o cadena vacía", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método shoot()
     * Caso 1: Munición >0
     */
    @Test
    public void shootAmmunInsideLimits()
    {
        Weapon w=new Weapon("p",10);
        
        w.shoot();
        assertEquals(9,w.getAmmunition());
    }
    
    /**
     * Pruebas del método shoot()
     * Caso 2: Munición =0
     */
    @Test
    public void shootAmmunEqual0()
    {
        Weapon w=new Weapon("p",0);
        
        w.shoot();
        assertEquals(0,w.getAmmunition());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1:
     */
    @Test
    public void toStringCorrect()
    {
        Weapon w=new Weapon();
        assertEquals(w.getName() + "-" + w.getAmmunition(),w.toString());
    }
}
