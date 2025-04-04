import java.util.ArrayList;
import java.util.List;

public class FilterCarsByYearOfRelease {
    private int minYearOfRelease;

    public FilterCarsByYearOfRelease(int minYearOfRelease){
        this.minYearOfRelease = minYearOfRelease;
    }

    public void filterAndPrint(List<Car> cars){
        List<Car> filteredCars = filterReleasedLater(cars);
        print(filteredCars);
    }

    public List<Car> filterReleasedLater(List<Car> cars){
        List<Car> filteredCars = new ArrayList<>();
        for (Car car: cars){
            if (car.getYearOfRelease() > minYearOfRelease) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public void print(List<Car> cars){
        for (Car car: cars){
            System.out.printf(car.toString());
        }
    }
}
