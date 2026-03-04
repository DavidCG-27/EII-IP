import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class HeaterTest.
 *
 * @author  David Covián Gómez
 * @version 21-10-2022
 */
public class HeaterTest
{
    /**
     * Pruebas del método changeTemperature()
     * Caso P1: Temperatura introducida correcta
     */
    @Test
    public void changeTemperatureInsideLimits()
    {
        Heater h=new Heater();
        h.changeTemperature(h.TEMP_MIN+1);
        assertEquals(h.TEMP_MIN+1, h.getTemperature());
    }
    
    /**
     * Pruebas del método changeTemperature()
     * Caso N1: Temperatura introducida menor que el mínimo
     */
    @Test
    public void changeTemperatureBelowLimits()
    {
        Heater h=new Heater();
        try
        {
            h.changeTemperature(h.TEMP_MIN-1);
            fail("Valor inválido");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método changeTemperature()
     * Caso N1: Temperatura introducida mayor que el máximo
     */
    @Test
    public void changeTemperatureAboveLimits()
    {
        Heater h=new Heater();
        try
        {
            h.changeTemperature(h.TEMP_MAX+1);
            fail("Valor inválido");
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
    public void toStringCorrect()
    {
        Heater h=new Heater();
        assertEquals(0d+"ºC", h.toString());
    } 
}
