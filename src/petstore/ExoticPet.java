package petstore;     
public class ExoticPet extends Animal{
    public ExoticPet(String name, String species, String sex, int age, double weight, int ID, double price) {
        super(name, species, sex, age, weight, ID, price);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
