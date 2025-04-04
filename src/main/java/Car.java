import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Car {
    private final String model;
    private final int yearOfRelease;
    private String color;
    private String transmission;
    private int seatsNumber;
    private float wheelDiameterInInches;


    public Car(String model, int yearOfRelease,
               String color, String transmission,
               int seatsNumber, float wheelDiameterInInches) {
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.color = color;
        this.transmission = transmission;
        this.seatsNumber = seatsNumber;
        this.wheelDiameterInInches = wheelDiameterInInches;
    }
}