/**
 * Created by Rezonance on 5.06.2014.
 */
public class State {
    // This class holds all the necessary information for every hex.
    private boolean checked;
    private int color;
    private int x;
    private int y;

    public State(boolean checked, int color, int x, int y) {
        this.checked = checked;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
