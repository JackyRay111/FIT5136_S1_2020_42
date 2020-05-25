package FIT5136_Implementation;

public class CargoRequirement {
    private String cargoRequired;
    private int cargoQuantitiesRequired;

    public CargoRequirement(){
        cargoQuantitiesRequired = 0;
        cargoRequired = "";
    }

    public String getCargoRequired(){
        return cargoRequired;
    }

    public int getCargoQuantitiesRequired(){
        return cargoQuantitiesRequired;
    }

    public void setCargoRequired(String cargoRequired){
        this.cargoRequired = cargoRequired;
    }

    public void setCargoQuantitiesRequired(int cargoQuantitiesRequired){
        this.cargoQuantitiesRequired = cargoQuantitiesRequired;
    }
}
