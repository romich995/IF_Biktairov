
public class ColorChanger {
    String oldColor;
    String newColor;

    public ColorChanger(String oldColor, String newColor){
        this.oldColor = oldColor;
        this.newColor = newColor;
    }

    public void apply(Car car){
        if (car.getColor().equals(oldColor)) {
            car.setColor(newColor);
        }
    }

}
