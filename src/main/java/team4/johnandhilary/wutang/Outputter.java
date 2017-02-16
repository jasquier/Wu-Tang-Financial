package team4.johnandhilary.wutang;

import java.io.PrintStream;

/**
 * Created by johnsquier on 2/16/17.
 */
public class Outputter {

    public Outputter() { }

    public void promptUserForCurrenyAmount() {
        System.out.print("Enter the amount of money you have: ");
    }

    public void promptUserForStartingCurrency() {
        System.out.print("What currency do you have now? ");
    }

    public void promptUserForTargetCurrency() {
        System.out.print("What currency are you converting to? ");
    }

    public void displayResult(Double amount, Double result, String startingCurrency, String endingCurrency) {
        System.out.println(amount + " in " + startingCurrency + " = " + result + " in " + endingCurrency);
    }
}
