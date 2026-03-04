
/**
 * Clase para representar árboles.
 * 
 * @author David Covián Gómez
 * @version 26/09/2022
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private String typeOfTree;
    private int maxNumberOfFlowers;
    private int numberOfFlowers;
    private int numberOfFruits;
    
    public final static int DEFAULT_MAX_NUMBER_OF_FLOWERS = 12;
    public final static int DEFAULT_NUMBER_OF_FLOWERS = 7;
    public final static String DEFAULT_TYPE_OF_TREE = "Manzano";
    public final static int DEFAULT_NUMBER_OF_FRUITS = 3;
    
    /**
     * Constructor de la clase con unos valores iniciales.
     */
    public Tree(){
     setTypeOfTree(DEFAULT_TYPE_OF_TREE);
     setMaxNumberOfFlowers(DEFAULT_MAX_NUMBER_OF_FLOWERS);
     setNumberOfFlowers(DEFAULT_NUMBER_OF_FLOWERS);
     setNumberOfFruits(DEFAULT_NUMBER_OF_FRUITS);
    }
    /**
     * El número de flores no puede ser mayor que su máximo ni menor que 0.
     */
    private void checkParamFlower(boolean condition){
        if (condition==false) {
            throw new IllegalArgumentException("El número de flores no puede superior al máximo establecido ni ser <0"); 
        }
    }
    /**
     * El número de frutas menor que 0.
     */
    private void checkParamFruit(boolean fruits){
        if (fruits==false) {
            throw new IllegalArgumentException("El número de frutas no puede ser <0"); 
        }
    }
    /**
     * Devuelve el tipo de árbol
     * @return Tipo de árbol
     */
    public String getTypeOfTree(){
        return typeOfTree;
    }    
    
    /**
     * Devuelve el número máximo de flores
     * @return Número máximo de flores
     */
    public int getMaxNumberOfFlowers(){
        return maxNumberOfFlowers;
    }
    
    /**
     * Devuelve el número de flores
     * @return Número de flores
     */
    public int getNumberOfFlowers(){
        return numberOfFlowers;
    }
    
    /**
     * Devuelve el número de frutas
     * @return Número de frutas
     */
    public int getNumberOfFruits(){
        return numberOfFruits;
    }
    
    /**
     * Modifica el tipo de árbol
     * @param typeOfTree Tipo de árbol
     */
    public void setTypeOfTree(String newTypeOfTree){
        typeOfTree=newTypeOfTree;
    }
    
    /**
     * Modifica el número máximo de flores
     * @param maxNumberOfFlowers Número máximo de flores
     */
    public void setMaxNumberOfFlowers(int newMaxNumberOfFlowers){
        maxNumberOfFlowers=newMaxNumberOfFlowers;
    }
    
    /**
     * Modifica el número de flores
     * @param numberOfFlowers Número de flores
     */
    public void setNumberOfFlowers(int numberOfFlowers){
        checkParamFlower(numberOfFlowers<DEFAULT_MAX_NUMBER_OF_FLOWERS && numberOfFlowers>0);
        this.numberOfFlowers=numberOfFlowers;
    }
    
    /**
     * Modifica el número de frutas
     * @param numberOfFruits Número de frutas
     */
    public void setNumberOfFruits(int newNumberOfFruits){
        numberOfFruits=newNumberOfFruits;
    }
    
    /**
     * Devuelve el tipo de aárbol, el número máximo de flores, el número de flores y el número de frutos.
     * @return Tipo de árbol - Número máximo de flores - Número de flores - Número de frutos
     */
    public String toString(){
        return getTypeOfTree() + "-" + getMaxNumberOfFlowers() + "-" + getNumberOfFlowers() + "-" + getNumberOfFruits();
    }
    
    /**
     * Imprime en pantalla el mensaje
     * @return Valores de las propiedades del árbol: Tipo de árbol - Número máximo de flores - Número de flores - Número de frutos
     */
    public void print(){
        System.out.println("Valores de las propiedades del árbol:"  + toString());
    }
    
    /**
     * Si el número de flores es menor que el número máximo de flores entonces se incrementa en una unidad el número de flores. Si el número de frutas es menor que el máximo de flores, se decrementa en una unidad el número de flores y se incrementa en una unidad el número de frutas.
     */
    public void water(){
        if (getNumberOfFlowers()<getMaxNumberOfFlowers()){
        setNumberOfFlowers(getNumberOfFlowers() + 1);
        }
        else if(getNumberOfFruits()<getMaxNumberOfFlowers()){
        setNumberOfFlowers(getNumberOfFlowers() - 1);
        setNumberOfFruits(getNumberOfFruits() + 1);
        }
    }
    
    /**
     * Resta una unidad a las frutas cada vez que se invoca.
     */
    public int gatherFruit(){
        checkParamFruit(getNumberOfFruits()>0);
        setNumberOfFruits(getNumberOfFruits()-1);
        return getNumberOfFruits();
    }
    
    /**
     * Expone el número de frutas y luego lo convierte a 0.
     */
    public int harvest(){
        return getNumberOfFruits();
    }
}

