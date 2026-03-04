

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
     * Caso único:
     */
    @Test
    public void defConst()
    {
        WheelStrut ws=new WheelStrut();
        
        assertNotNull(ws.getLeftWheel());
        assertEquals(ws.BOEING_737_PRESSURE, ws.getLeftWheel().getMaxPressure());
        assertEquals(ws.BOEING_737_PRESSURE, ws.getLeftWheel().getPressure());
        
        assertNotNull(ws.getRightWheel());
        assertEquals(ws.BOEING_737_PRESSURE, ws.getRightWheel().getMaxPressure());
        assertEquals(ws.BOEING_737_PRESSURE, ws.getRightWheel().getPressure());
        
        assertEquals(ws.IS_DEPLOYED,ws.isDeployed());
        
    }
}
