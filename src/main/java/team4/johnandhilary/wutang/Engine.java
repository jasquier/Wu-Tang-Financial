package team4.johnandhilary.wutang;

/**
 * Created by johnsquier on 2/16/17.
 */
public class Engine {

    Inputter input;
    Outputter output;
    DoubleConverter converter;

    public Engine() {
        input = new Inputter(System.in);
        output = new Outputter();
        converter = new DoubleConverter();
    }

    public void run() {
        output.promptUserForCurrenyAmount();
        Double amount = input.getDouble();

        output.promptUserForStartingCurrency();
        String startingCurrency = input.getString();


        output.promptUserForTargetCurrency();
        String targetCurrency = input.getString();

        Double result = null;
        try {
            result = converter.convert(amount, startingCurrency, targetCurrency);
            output.displayResult(amount, result, startingCurrency, targetCurrency);
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch (InvalidMoneyAmount invalidMoneyAmount) {
            invalidMoneyAmount.printStackTrace();
        }
    }
}
