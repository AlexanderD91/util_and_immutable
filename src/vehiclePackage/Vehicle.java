package vehiclePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Vehicle {
    final private String brand;
    final private String model;
    final private VehicleConfiguration vehicleConfiguration;
    final private Integer price;

    public Vehicle(String brand, String model, VehicleConfiguration vehicleConfiguration, Integer price) {
        this.brand = brand;
        this.model = model;
        try {
            VehicleConfiguration tempVehicleConfig = (VehicleConfiguration) vehicleConfiguration.clone();
            /* Глубокое клонирование правильнее было бы реализовать в классе VehicleConfiguration,
            но для наглядности оставил тут */
            tempVehicleConfig.setConfigList(new ArrayList<>(vehicleConfiguration.getConfigList()));
            this.vehicleConfiguration = tempVehicleConfig;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public VehicleConfiguration getVehicleConfiguration() {
        try {
            VehicleConfiguration tempVehicleConfig = (VehicleConfiguration) this.vehicleConfiguration.clone();
            /* Глубокое клонирование правильнее было бы реализовать в классе VehicleConfiguration,
            но для наглядности оставил тут */
            tempVehicleConfig.setConfigList(new ArrayList<>(this.vehicleConfiguration.getConfigList()));
            return tempVehicleConfig;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle - " + '\n' +
                "brand: " + brand + '\n' +
                "model: " + model + '\n' +
                "complete set - " + vehicleConfiguration + '\n' +
                "price: " + price;
    }
}

class VehicleConfiguration implements Cloneable {
    private String name;
    private List<String> configList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", options: " + configList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleConfiguration that = (VehicleConfiguration) o;
        return Objects.equals(name, that.name) && Objects.equals(configList, that.configList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, configList);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}