

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TreeTest.
 *
 * @author  David Covián Gómez
 * @version 03/10/2022
 */
public class TreeTest
{
    /**
     * Default constructor for test class TreeTest
     */
    public TreeTest()
    {
    }
    
    /**
     * Pruebas del setNumberOfFlowers
     * Caso 1: Número de flores recibidos dentro de los límites.
     */
    @Test
    public void testNumberOfFlowers() {
        Tree t=new Tree();
        
        t.setNumberOfFlowers(2);
        assertEquals(t.getNumberOfFlowers(), t.getNumberOfFlowers());
        
        
    }
    /**
     * Pruebas del setNumberOfFlowers
     * Caso 2: Número de flores recibidos por encima de los límites.
     */
    @Test
    public void testNumberOfFlowersOverLimits(){
        Tree t=new Tree();
        try{
            t.setNumberOfFlowers(t.getMaxNumberOfFlowers() + 1);
            fail("Debería de haber fallado, ya que el número de flores no puede superar a su máximo establecido");
        }
        catch (RuntimeException e){
            assertEquals("El número de flores no puede superior al máximo establecido ni ser <0", e.getMessage());
        }
    }
    /**
     * Pruebas del setNumberOfFlowers
     * Caso 3: Número de flores recibidos por debajo de los límites.
     */
    @Test
    public void testNumberOfFlowersUnderLimits(){
        Tree t=new Tree();
        try{
            t.setNumberOfFlowers((t.getMaxNumberOfFlowers() - 1) - t.getMaxNumberOfFlowers());
            fail("Debería de haber fallado, ya que el número de flores no puede ser negativo");
        }
        catch (RuntimeException e){
            assertEquals("El número de flores no puede superior al máximo establecido ni ser <0", e.getMessage());
        }
    }

} 