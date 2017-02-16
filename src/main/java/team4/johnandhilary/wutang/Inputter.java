package team4.johnandhilary.wutang;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by johnsquier on 2/16/17.
 */
public class Inputter {

    Scanner scanner;

    public Inputter(InputStream in) {
        scanner = new Scanner(in);
    }

    public String getString() {
        if ( scanner.hasNextLine() ) {
            return scanner.nextLine();
        }
        else {
            return "";
        }
    }

    public Double getDouble() {
        if ( scanner.hasNextDouble() ) {
            Double d = scanner.nextDouble();
            scanner.nextLine();
            return d;
        }
        else {
            return -1.0;
        }
    }
}
