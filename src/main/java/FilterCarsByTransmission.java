import java.util.ArrayList;
import java.util.List;

public class FilterCarsByTransmission {
    private String transmission;

    public FilterCarsByTransmission(String transmission){
        this.transmission = transmission;
    }

    public List<Car> filterByTransmission(List<Car> cars){
        List<Car> filteredCars = new ArrayList<>();
        for (Car car: cars){
            if (car.getTransmission().equals(transmission)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

}
