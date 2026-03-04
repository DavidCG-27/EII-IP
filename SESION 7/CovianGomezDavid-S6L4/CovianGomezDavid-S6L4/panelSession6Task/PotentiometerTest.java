import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PotentiometerTest.
 *
 * @author  David Covián Gómez
 * @version 21-10-2022
 */
public class PotentiometerTest
{
    /**
     * Pruebas del método movePosition()
     * Caso P1: Valor correcto
     */
    @Test
    public void movePositionInsideLimits()
    {
        Potentiometer p=new Potentiometer();
        p.movePosition(p.MIN_VALUE);
        assertEquals(p.MIN_VALUE, p.getPosition());     
    }
    
    /**
     * Pruebas del método movePosition()
     * Caso N1: Valor por encima del límite
     */
    @Test
    public void movePositionAboveLimits()
    {
        Potentiometer p=new Potentiometer();
        try
        {
            p.movePosition(p.MAX_VALUE+1);
            fail("Posición incorrecta");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método movePosition()
     * Caso N1: Valor por debajo del límite
     */
    @Test
    public void movePositionBelowLimits()
    {
        Potentiometer p=new Potentiometer();
        try
        {
            p.movePosition(p.MIN_VALUE-1);
            fail("Posición incorrecta");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1:
     */
    @Test
    public void toStringTest()
    {
        Potentiometer p=new Potentiometer();
        p.toString();
        assertEquals(""+p.getPosition(), p.toString());
    }
}
