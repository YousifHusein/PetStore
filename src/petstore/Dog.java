package petstore;
public class Dog extends Animal{
    
    public Dog(String name, String breed, String sex, int age, double weight, int ID, double price) {
        super(name, breed, sex, age, weight, ID, price);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
