
/**
 * The SpaceShuttle class is used to store infromation of the
 * space shuttles.
 *
 * @author  Daniel
 * @version (02nd / June / 2020)
 */
public class SpaceShuttle
{
    // attributes
    private String shuttleName;
    private int manufacturingYear;
    private int fuelCapacity;
    private int passengerCapacity;
    private int cargoCapacity;
    private int travelSpeed;
    private int shuttleOrigin;
    private int shuttleId;

    /**
     * Constructor for objects of class spaceShuttle
     */
    public SpaceShuttle()
    {
        // initialise attributes
        shuttleName = "enter shuttle name";
        manufacturingYear = 0;
        fuelCapacity = 0;
        passengerCapacity = 0;
        cargoCapacity = 0;
        travelSpeed = 0;
        shuttleOrigin = 0;
        shuttleId = 0;
    }

    /**
     * Constructor for objects of class spaceShuttle
     */
    public SpaceShuttle(String newShuttleName, int newManufacturingYear, int newFuelCapacity, int newPassengerCapacity, int newCargoCapacity, int newTravelSpeed, int newShuttleOrigin, int newShuttleId)
    {
        // initialise attributes
        shuttleName = newShuttleName;
        manufacturingYear = newManufacturingYear;
        fuelCapacity = newFuelCapacity;
        passengerCapacity = newPassengerCapacity;
        cargoCapacity = newCargoCapacity;
        travelSpeed = newTravelSpeed;
        shuttleOrigin = newShuttleOrigin;
        shuttleId = newShuttleId;
    }
    
    /**
     * Accessor Method to get the name of the shuttle
     * 
     * @return a String which contains the shuttle name
     */
    public String getShuttleName(){
        return shuttleName;
    }
    
    /**
     * Mutator Method to set the name of the shuttle
     * 
     * @param newShuttleName String to define the new 
     *          shuttle name
     */
    public void setShuttleName(String newShuttleName){
        shuttleName = newShuttleName;
    }
    
    /**
     * Accessor Method to get the shuttle manufacturing year
     * 
     * @return an integer which contains the shuttle manufacturing year
     */
    public int getManufacturingYear(){
        return manufacturingYear;
    }
    
    /**
     * Mutator Method to set the value of the shuttle manufacturing year
     * 
     * @param newManufacturingYear integer to define the new value for the the 
     *          shuttle manufacturing year
     */
    public void setManufacturingYear(int newManufacturingYear){
        manufacturingYear = newManufacturingYear;
    }
    
    /**
     * Accessor Method to get the shuttle fuel capacity
     * 
     * @return an integer which contains the shuttle fuel capacity
     */
    public int getFuelCapacity(){
        return fuelCapacity;
    }
    
    /**
     * Mutator Method to set the shuttle fuel capacity
     * 
     * @param newFuelCapacity integer to define the 
     *          new shuttle fuel capacity
     */
    public void setFuelCapacity(int newFuelCapacity){
        fuelCapacity = newFuelCapacity;
    }
    
    /**
     * Accessor Method to get the shuttle passenger capacity
     * 
     * @return an integer which contains the shuttle passenger capacity
     */
    public int getPassengerCapacity(){
        return passengerCapacity;
    }
    
    /**
     * Mutator Method to set the shuttle passenger capacity
     * 
     * @param newPassengerCapacity integer to define the new 
     *          shuttle passenger capacity
     */
    public void setPassengerCapacity(int newPassengerCapacity){
        passengerCapacity = newPassengerCapacity;
    }
    
    /**
     * Accessor Method to get the shuttle cargo capacity 
     * 
     * @return an integer which contains the shuttle cargo capacity 
     */
    public int getCargoCapacity(){
        return cargoCapacity;
    }
    
    /**
     * Mutator Method to set the shuttle cargo capacity 
     * 
     * @param newCargoCapacity integer to define the new 
     *          shuttle cargo capacity 
     */
    public void setCargoCapacity(int newCargoCapacity){
        cargoCapacity = newCargoCapacity;
    }
    
    /**
     * Accessor Method to get the shuttle travel speed
     * 
     * @return an integer which contains the shuttle travel speed
     */
    public int getTravelSpeed(){
        return travelSpeed;
    }
    
    /**
     * Mutator Method to set the shuttle travel speed
     * 
     * @param newTravelSpeed integer to define the new 
     *          shuttle travel speed
     */
    public void setTravelSpeed(int newTravelSpeed){
        travelSpeed = newTravelSpeed;
    }

    /**
     * Accessor Method to get the shuttle origin
     *
     * @return an integer which contains the shuttle origin
     */
    public int getShuttleOrigin(){
        return shuttleOrigin;
    }

    /**
     * Mutator Method to set the shuttle origin
     *
     * @param newShuttleOrigin integer to define the new
     *          shuttle origin
     */
    public void setShuttleOrigin(int newShuttleOrigin){
        shuttleOrigin = newShuttleOrigin;
    }

    /**
     * Accessor Method to get the shuttle ID
     *
     * @return an integer which contains the ID
     */
    public int getShuttleId(){
        return shuttleId;
    }

    /**
     * Mutator Method to set the shuttle ID
     *
     * @param newShuttleId integer to define the new
     *          shuttle ID
     */
    public void setShuttleId(int newShuttleId){
        shuttleId = newShuttleId;
    }

    /**
     * Display Method to show the shuttle information
     */
    public void displayShuttleInfo() {
        System.out.println("* Shuttle ID: " + shuttle.getShuttleId());
        System.out.println("1.Shuttle Name: " + shuttle.getShuttleName());
        System.out.println("2.Country Of Origin: " + shuttle.getShuttleOrigin());
        System.out.println("3.Manufacturing Year: " + shuttle.getManufacturingYear());
        System.out.println("4.Passenger Capacity: " + shuttle.getPassengerCapacity());
        System.out.println("5.Fuel Capacity: " + shuttle.getFuelCapacity());
        System.out.println("6.Travel Speed: " + shuttle.getTravelSpeed());
        System.out.println("7.Cargo Capacity: " + shuttle.getCargoCapacity())
    }
}
