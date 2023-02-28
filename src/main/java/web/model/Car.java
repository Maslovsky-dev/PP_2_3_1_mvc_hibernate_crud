package web.model;

public class Car {
    private String manufacturer;
    private String model;
    private String owner;

    public Car() {
    }

    public Car(String manufacture, String model, String owner) {
        this.manufacturer = manufacture;
        this.model = model;
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
