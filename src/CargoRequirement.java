/**
 *  The class is for storing the information of the cargo requirement
 *
 *  @author Jiancong(Jacky) Lei
 *  @Version 25/05/2020
 */
public class CargoRequirement {
    private String cargoRequired;
    private int cargoQuantitiesRequired;

    /**
     * Constructor for objects of class CargoRequirement
     */
    public CargoRequirement(){
        cargoQuantitiesRequired = 0;
        cargoRequired = "";
    }

    /**
     * The Accessor method to get the purpose that the cargo are required
     *
     * @return A String contains the requirement of the cargo
     */
    public String getCargoRequired(){
        return cargoRequired;
    }

    /**
     * The Accessor method to get the number that the mission required in the cargo
     *
     * @return An integer contains the number of the quantities required
     */
    public int getCargoQuantitiesRequired(){
        return cargoQuantitiesRequired;
    }

    /**
     * The Mutator method to set the purpose that the cargo are required
     *
     * @param cargoRequired String that contains the cargo requirement
     */
    public void setCargoRequired(String cargoRequired){
        this.cargoRequired = cargoRequired;
    }

    /**
     * The Mutator method to set the number that the mission required in the cargo
     *
     * @param cargoQuantitiesRequired String that contains the cargo quantities requirement
     */
    public void setCargoQuantitiesRequired(int cargoQuantitiesRequired){
        this.cargoQuantitiesRequired = cargoQuantitiesRequired;
    }
}
