/**
 * Created by Rezonance on 5.06.2014.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BorderCount {
    static int borders = 0;
    static int islands = 0;
    static int mx = 0;
    static int my = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("kxsis.txt"));
        String line = null;
        List<List<State>> borderplex = new ArrayList<List<State>>();
        int y = 0;
        line = reader.readLine();
        String[] parts = line.split("\\s");
        my = Integer.valueOf(parts[0]);
        mx = Integer.valueOf(parts[1]);
        while ((line = reader.readLine()) != null) {
            int x = 0;
            parts = line.split("\\s");
            List<State> a = new ArrayList<State>();
            for (String part : parts) {
                Integer i = Integer.valueOf(part);
                State state = new State(false, i, x, y);
                a.add(state);
                x++;
            }
            borderplex.add(a);
            y++;
        }
        reader.close();
        for (List<State> row: borderplex) {
            for (State state : row) {
                if (!state.isChecked()) {
                    state.setChecked(true);
                    BorderCheck.check(state,borderplex);
                    islands++;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("kxval.txt"));
        out.println(Integer.toString(islands));
        out.println(Integer.toString(borders));
        out.close();
    }
}
