

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SwitchTest.
 *
 * @author  David Covián Gómez
 * @version 21-10-22
 */
public class SwitchTest
{
    /**
     * Pruebas del método press()
     * Caso 1: Botón encendido
     */
    @Test
    public void pressButtonOn()
    {
        Switch s=new Switch();
        s.press();
        assertEquals(true, s.getButton());
    }
    
    /**
     * Pruebas del método press()
     * Caso 2: Botón apagado
     */
    @Test
    public void pressButtonOff()
    {
        Switch s=new Switch();
        s.press();
        s.press();
        assertEquals(false, s.getButton());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1: Botón encendido
     */
    @Test
    public void toStringOn()
    {
        Switch s=new Switch();
        s.press();
        s.toString();
        assertEquals("ON", s.toString());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 2: Botón apagado
     */
    @Test
    public void toStringOff()
    {
        Switch s=new Switch();
        s.toString();
        assertEquals("OFF", s.toString());
    }
}
