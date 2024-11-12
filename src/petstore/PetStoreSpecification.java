package petstore;
import java.util.*;

public interface PetStoreSpecification {
    /**
     * update inventory by adding the given pets
     * to the store's current inventory
     * 
     * @param pets
     */
    public void adoptionDrive(ArrayList<Animal> pets);
    
    /**
     * calculate and return dollar amount for current inventory of pets
     * that are in stock
     * 
     * @return total in stock value
     */
    public double inventoryValue();
}
