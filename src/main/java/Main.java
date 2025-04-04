import java.util.List;

public class Main {
    //its Main origin
    public static void main(String[] args) {
        List<Car> listOfCars = List.of(
                new Toyota("Camry", 2018, "black", "automatic", 5, 18),
                new Toyota("Camry", 2014, "white", "mechanical", 5, 18),
                new Lada("Niva", 2010, "black", "mechanical", 5, 18),
                new Lada("Niva", 2019, "green", "mechanical", 5, 18),
                new Mazda("CX-7", 2004, "black", "automatic", 5, 18),
                new Mazda("CX-5", 2006, "green", "automatic", 5, 18),
                new Opel("Astra", 2018, "black", "mechanical", 5, 18),
                new Opel("Astra", 2005, "black", "automatic", 5, 18),
                new Renault("Logan", 2005, "black", "mechanical", 5, 18),
                new Renault("Arcana", 2018, "red", "mechanical", 5, 18)
        );

        FilterCarsByYearOfRelease filterCarsByYearOfRelease = new FilterCarsByYearOfRelease(2006);
        filterCarsByYearOfRelease.filterAndPrint(listOfCars);

        ColorChanger colorChanger = new ColorChanger("green", "red");
        colorChanger.apply(listOfCars.get(3));

        FilterCarsByTransmission filterCarsByTransmission = new FilterCarsByTransmission("mechanical");
        List<Car> filteredCars = filterCarsByTransmission.filterByTransmission(listOfCars);
        System.out.printf(filteredCars.toString());

    }
}
