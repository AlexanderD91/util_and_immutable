package vehiclePackage;

import java.util.ArrayList;
import java.util.List;

public class VehicleTestExample {
    public static void main(String[] args) {
        VehicleConfiguration vc1 = new VehicleConfiguration();
        vc1.setName("Base");
        List<String> list1 = new ArrayList<>();
        list1.add("Climate control system");
        list1.add("2 airbags");
        list1.add("ABS");
        list1.add("Multimedia system");
        vc1.setConfigList(list1);

        Vehicle vehicle1 = new Vehicle("AutoMotoBrand", "NewSuperPremModel-01", vc1, 50_000);

        // Убедимся визуально, что получили ожидаемый результат:
        System.out.println(vehicle1);
        System.out.println("===============================================================================================");
        // Убедимся визуально, что поле vehicleConfiguration клонировался успешно:
        System.out.println("Field (vehicleConfiguration)");
        System.out.println("Original: " + vc1);
        System.out.println("Copy: " + vehicle1.getVehicleConfiguration());
        System.out.println("===============================================================================================");
        // Проверка поля списков опций на равенство / равенство ссылок (equals и ==):
        System.out.println("List (cofigList)");
        System.out.println("Equals: " + list1.equals(vehicle1.getVehicleConfiguration().getConfigList()));
        System.out.println("==: " + (list1 == vehicle1.getVehicleConfiguration().getConfigList()));
        System.out.println("===============================================================================================");
        // Проверка поля vehicleConfiguration на равенство / равенство ссылок (equals и ==):
        System.out.println("Field (vehicleConfiguration)");
        System.out.println("Equals: " + vc1.equals(vehicle1.getVehicleConfiguration()));
        System.out.println("==: " + (vc1 == vehicle1.getVehicleConfiguration()));
        System.out.println("===============================================================================================");
        // Данные манипуляции на наш immutable объект не повлияли:
        vehicle1.getVehicleConfiguration().setName("Advanced");
        System.out.println(vehicle1);
    }
}
