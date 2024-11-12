package petstore;

import java.util.*;
import java.io.*;

public class PetStore implements PetStoreSpecification{

    private String storeName;
    Scanner fileScanner;
    
    private ArrayList<Dog> availableDogs = new ArrayList();
    private ArrayList<Cat> availableCats = new ArrayList();
    private ArrayList<ExoticPet> availableExoticPets = new ArrayList();
    private ArrayList<Member> memberList = new ArrayList();
    private ArrayList<PremiumMember> premiumMemberList = new ArrayList();
    private ArrayList<Animal> purchasedAnimals = new ArrayList();
    private ArrayList<Member> newMembers = new ArrayList();
    private ArrayList<PremiumMember> newPremiumMembers = new ArrayList();
    private static int nextPetID = 1;
    private static int nextMemberID = 1;
    
    
    public PetStore(String storeName) {
        try{
            fileScanner = new Scanner(new File("C:\\Users\\ksguy\\Documents/PetstoreInventory.csv"));
            
            String line;
            while(fileScanner.hasNext()){
                line = fileScanner.nextLine();
                int prev;
                if(line.contains("dog")){
                    int id = Integer.valueOf(line.substring(0, line.indexOf(",")));
                    prev = line.indexOf(",", line.indexOf(",") + 1);
                    String name = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String breed = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String sex = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    int age = Integer.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double weight = Double.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double price = Double.valueOf(line.substring(prev + 1, line.length()));
                    availableDogs.add(new Dog(name, breed, sex, age, weight, id, price));
                }
                else if(line.contains("cat")){
                    int id = Integer.valueOf(line.substring(0, line.indexOf(",")));
                    prev = line.indexOf(",", line.indexOf(",") + 1);
                    String name = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String breed = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String sex = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    int age = Integer.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double weight = Double.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double price = Double.valueOf(line.substring(prev + 1, line.length()));
                    availableCats.add(new Cat(name, breed, sex, age, weight, id, price));
                }
                if(line.contains("exotic pet")){
                    int id = Integer.valueOf(line.substring(0, line.indexOf(",")));
                    prev = line.indexOf(",", line.indexOf(",") + 1);
                    String name = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String breed = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    String sex = line.substring(prev + 1, line.indexOf(",", prev + 1));
                    prev = line.indexOf(",", prev + 1);
                    int age = Integer.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double weight = Double.valueOf(line.substring(prev + 1, line.indexOf(",", prev + 1)));
                    prev = line.indexOf(",", prev + 1);
                    double price = Double.valueOf(line.substring(prev + 1, line.length()));
                    availableExoticPets.add(new ExoticPet(name, breed, sex, age, weight, id, price));
                }
            }
            fileScanner.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for inputData.txt. Try again making sure the file name and path are correct.");
        }
        this.storeName = storeName;

        Member member1 = new Member("Jo", getNextMemberID(), true);
        member1.addCat(new Cat("Valjean", "White tabby", "Male", 1, 10, 0, 0));
        memberList.add(member1);

        PremiumMember member2 = new PremiumMember("Sage", getNextMemberID(), false, false);
        premiumMemberList.add(member2);
        member2.addExoticPet(
            new ExoticPet("Smaug", "Bearded Dragon", "Male", 5, 1, 0, 0)
        );

    }

    public static int getNextPetID() {
        nextPetID++;
        return nextPetID - 1;
    }
    
    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Dog> getAvailableDogs() {
        return availableDogs;
    }

    public void setAvailableDogs(ArrayList<Dog> availableDogs) {
        this.availableDogs = availableDogs;
    }

    public ArrayList<Cat> getAvailableCats() {
        return availableCats;
    }

    public void setAvailableCats(ArrayList<Cat> availableCats) {
        this.availableCats = availableCats;
    }

    public ArrayList<ExoticPet> getAvailableExoticPets() {
        return availableExoticPets;
    }

    public void setAvailableExoticPets(ArrayList<ExoticPet> availableExoticPets) {
        this.availableExoticPets = availableExoticPets;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<PremiumMember> getPremiumMemberList() {
        return premiumMemberList;
    }

    public void setPremiumMemberList(ArrayList<PremiumMember> premiumMemberList) {
        this.premiumMemberList = premiumMemberList;
    }

    public void removePet(String type, int index) {
        if (type.equals("dog")) 
            availableDogs.remove(index);
        else if (type.equals("cat")) 
            availableCats.remove(index);
        else if (type.equals("exoticPet")) 
            availableExoticPets.remove(index);

    }

    public void addNewMember(String name, boolean premium) {
        if (premium) {
            premiumMemberList.add(new PremiumMember(name,getNextMemberID(),false,false));
            newPremiumMembers.add(new PremiumMember(name, getNextMemberID(), false, false));
        } else {
            memberList.add(new Member(name,getNextMemberID(), false));
            newMembers.add(new Member(name, getNextMemberID(), false));
        }
    }
    
    public void addNewPurchasedAnimals(ArrayList<Animal> animals){
        for(Animal a : animals){
            purchasedAnimals.add(a);
        }
    }
     
    public void endOfDayData(){
        FileOutputStream fs;
        try{
            fs = new FileOutputStream("C:\\Users\\ksguy\\Documents/EndOfDayReport.txt");
            PrintWriter outFS = new PrintWriter(fs);
            
            outFS.println("End of day report:");
            
            outFS.println("\nPurchased Animals:");
            for(Animal animals : purchasedAnimals){
                outFS.println(animals.getID() + ". $" + animals.getPrice() + " - " + animals.getBreed() + "(" + animals.getName() + ")");
            }
            
            outFS.println("\nTotal New Memebers: " + (newMembers.size() + newPremiumMembers.size()));
            
            double total = 0;
            for(Animal animals : purchasedAnimals){
                total += animals.getPrice();
            }
            outFS.println("\nTotal Sales: " + total);
            
            outFS.close();
            fs.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for EndOfDayReport.txt. Try again making sure the file name and path are correct.");
        }
        catch(IOException ex){
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
        try{
            fs = new FileOutputStream("C:\\Users\\ksguy\\Documents/UpdatedPetstoreInventory.csv");
            PrintWriter outFS = new PrintWriter(fs);
            
            outFS.println("productID,type,breed,gender,age,weight,price");
            
            for(Dog dog : availableDogs){
                outFS.println(dog.getID() + ",dog," + dog.getName() + "," + dog.getBreed() + "," + dog.getSex() + "," + dog.getAge() + "," + dog.getWeight() + "," + dog.getPrice());
            }
            for(Cat cat : availableCats){
                outFS.println(cat.getID() + ",cat," + cat.getName() + "," + cat.getBreed() + "," + cat.getSex() + "," + cat.getAge() + "," + cat.getWeight() + "," + cat.getPrice());
            }
            for(ExoticPet exoticPet : availableExoticPets){
                outFS.println(exoticPet.getID() + ",exotic pet," + exoticPet.getName() + "," + exoticPet.getBreed() + "," + exoticPet.getSex() + "," + exoticPet.getAge() + "," + exoticPet.getWeight() + "," + exoticPet.getPrice());
            }
            
            outFS.close();
            fs.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for UpdatedPetStoreInventory.csv. Try again making sure the file name and path are correct.");
        }
        catch(IOException ex){
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
    }

    @Override
    public void adoptionDrive(ArrayList<Animal> pets) {
        for(Animal pet : pets){
            if(pet instanceof Dog){
                availableDogs.add((Dog)pet);
            }
            else if(pet instanceof Cat){
                availableCats.add((Cat)pet);
            }
            else{
                availableExoticPets.add((ExoticPet)pet);
            }
        }
    }

    @Override
    public double inventoryValue() {
        double total = 0;
        for(Dog dogs : this.getAvailableDogs()){
            total += dogs.getPrice();
        }
        for(Cat cats : this.getAvailableCats()){
            total += cats.getPrice();
        }
        for(ExoticPet exoticPets : this.getAvailableExoticPets()){
            total += exoticPets.getPrice();
        }
        return total;
    }
}
