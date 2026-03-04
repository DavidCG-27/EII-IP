import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LampTest.
 *
 * @author  David Covián Gómez
 * @version 21-10-2022
 */
public class LampTest
{
    /**
     * Pruebas del método turnOn()
     * Caso 1:
     */
    @Test
    public void turnOn()
    {
        Lamp l=new Lamp();
        l.turnOn();
        assertEquals(true,l.getStatus());
    }
    
    /**
     * Pruebas del método turnOff()
     * Caso 1:
     */
    @Test
    public void turnOff()
    {
        Lamp l=new Lamp();
        l.turnOff();
        assertEquals(false,l.getStatus());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1: Lámpara apagada
     */
    @Test
    public void toStringLampOff()
    {
        Lamp l=new Lamp();
        l.turnOff();
        l.toString();
        assertEquals("APAGADA",l.toString());
    }
    
     /**
     * Pruebas del método toString()
     * Caso 2: Lámpara encendida
     */
    @Test
    public void toStringLampOn()
    {
        Lamp l=new Lamp();
        l.turnOn();
        l.toString();
        assertEquals("ENCENDIDA",l.toString());
    }
}
