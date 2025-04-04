import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Car {
    private final String model;
    private final String yearOfRelease;
    private String color;
    private String transmission;
    private int seatsNumber;
    private float wheelDiameterInInches;


    public Car(String model, String yearOfRelease,
               String color, String transmission,
               int seatsNumber, float wheelDiameterInInches) {
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.color = color;
        this.transmission = transmission;
        this.seatsNumber = seatsNumber;
        this.wheelDiameterInInches = wheelDiameterInInches;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", wheelDiameterInInches=" + wheelDiameterInInches +
                '}';
    }
}


