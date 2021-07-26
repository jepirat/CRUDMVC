package entities;
public class Car {
    String name;
    String speed;
    String color;

    public Car() {
    }

    public Car(String name, String speed, String color) {
        this.name = name;
        this.speed = speed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
