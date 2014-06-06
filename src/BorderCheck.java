import java.util.Arrays;
import java.util.List;

/**
 * Created by Rezonance on 5.06.2014.
 */
public class BorderCheck {
    /* Since the assignment had me checking between the borders of a hexagonal board,
    even lines had different neighbouring directions */
    public static final int[][] legalmove1 = new int[][]{
            {1, 0},
            {1, 1},
            {0, -1},
            {0, 1},
            {-1, 0},
            {-1, 1}
    };
    public static final int[][] legalmove2 = new int[][]{
            {1, 0},
            {1, -1},
            {0, -1},
            {0, 1},
            {-1, 0},
            {-1, -1}
    };

    public static void check(State state, List<List<State>> map) {
        if (state.getY() % 2 != 0) {
            for (int[] move : legalmove1) {
                int movex = state.getX() + move[0];
                int movey = state.getY() + move[1];
                // Check if legal move
                if (movex < BorderCount.mx && movex > -1 && movey < BorderCount.my && movey > -1) {
                    if (state.getColor() == map.get(movey).get(movex).getColor() &&
                            !map.get(movey).get(movex).isChecked()) {
                        map.get(movey).get(movex).setChecked(true);
                        BorderCheck.check(map.get(movey).get(movex), map);
                    } else {
                        if (state.getColor() != map.get(movey).get(movex).getColor() &&
                                !map.get(movey).get(movex).isChecked()) {
                            BorderCount.borders++;
                        }
                    }
                }
            }
        } else {
            for (int[] move : legalmove2) {
                int movex = state.getX() + move[0];
                int movey = state.getY() + move[1];
                // Check if legal move
                if (movex < BorderCount.mx && movex > -1 && movey < BorderCount.my && movey > -1) {
                    if (state.getColor() == map.get(movey).get(movex).getColor() &&
                            !map.get(movey).get(movex).isChecked()) {
                        map.get(movey).get(movex).setChecked(true);
                        BorderCheck.check(map.get(movey).get(movex), map);
                    } else {
                        if (state.getColor() != map.get(movey).get(movex).getColor() &&
                                !map.get(movey).get(movex).isChecked()) {
                            BorderCount.borders++;
                        }
                    }
                }
            }
        }
    }
}