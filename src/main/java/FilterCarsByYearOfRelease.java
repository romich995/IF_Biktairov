import java.util.ArrayList;
import java.util.List;

public class FilterCarsByYearOfRelease {
    private int minYearOfRelease;

    public FilterCarsByYearOfRelease(int minYearOfRelease){
        this.minYearOfRelease = minYearOfRelease;
    }

    public void filterReleasedLater(List<Car> cars){
        for (Car car: cars){
            if (car.getYearOfRelease() > minYearOfRelease) {
                System.out.println(car);
            } else {
                System.out.println("устаревший авто");
            }

        }
    }

}
