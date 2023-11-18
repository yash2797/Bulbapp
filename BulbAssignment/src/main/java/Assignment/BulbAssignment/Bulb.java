package Assignment.BulbAssignment;

public class Bulb {
    private String color;
    private boolean isOn;

    public Bulb(String color) {
        this.color = color;
        this.isOn = false; // Default isOff
    }

    public String getColor() {
        return color;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

