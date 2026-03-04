

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelStrutTest.
 *
 * @author  David
 * @version 28/10/2022
 */
public class WheelStrutTest
{
    /**
     * Default constructor for test class WheelStrutTest
     */
    public WheelStrutTest()
    {
    }

    /**
     * Pruebas del constructor por defecto
     * Caso 1:
     */
    @Test
    public void defConstOk()
    {
        WheelStrut ws=new WheelStrut(4);
        //verifico que la rueda iésima existe
        for (int i=0; i<ws.numberOfWheels();i++)
        {
            assertNotNull(ws.getWheel(i));
            assertEquals(ws.BOEING_737_PRESSURE, ws.getWheel(i).getMaxPressure());
            assertEquals(ws.BOEING_737_PRESSURE, ws.getWheel(i).getPressure());
        }
        
        assertEquals(ws.IS_DEPLOYED,ws.isDeployed());
        
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 2: número incorrecto de ruedas
     */
    @Test
    public void defConstNumberOfWheelsEqual0()
    {
        try
        {
            WheelStrut ws=new WheelStrut(0);
            fail("Debería haber fallado ya que no es correcto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("El puntal debe de tener un número de ruedas >0", e.getMessage());
        }
        
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 2: número negativo de ruedas
     */
    @Test
    public void defConstNumberOfWheelsNegative()
    {
        try
        {
            WheelStrut ws=new WheelStrut(-10);
            fail("Debería haber fallado ya que no es correcto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("El puntal debe de tener un número de ruedas >0", e.getMessage());
        }
        
    }
    
    /**
     * Pruebas del método deploy
     * Caso 1:
     */
    @Test
    public void deployOk()
    {
       WheelStrut ws=new WheelStrut(4); 
       ws.deploy();
       assertEquals(ws.IS_DEPLOYED,ws.isDeployed());
    }
    
    // /**
     // * Pruebas test()
     // * Caso 2: Una de las ruedas mal
     // */
    // @Test
    // public void testFail()
    // {
        // int nw=10;
        // for(int i=0;i<nw;i++)
        // {
            // WheelStrut ws= new WheelStrut(4);
            // ws.getWheel(i).changePressure(0);
            // assertFalse(ws.getWheel(i).test());
        // }
    // }
    
    /**
     * Pruebas del método toString()
     * Caso1:
     */
    @Test
    public void toStringOk()
    {
        WheelStrut ws=new WheelStrut(4);
        assertEquals("Deployed: true - Test: true[0: true] [1: true] [2: true] [3: true] ",ws.toString());
    }
}
