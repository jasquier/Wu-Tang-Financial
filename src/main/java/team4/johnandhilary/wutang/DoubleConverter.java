package team4.johnandhilary.wutang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnsquier on 2/16/17.
 */
public class DoubleConverter {

    Map<String, Double> conversionRatesFromUSD;

    public DoubleConverter() {
        conversionRatesFromUSD = new HashMap<>();
        conversionRatesFromUSD.put("USD", 1.00);
        conversionRatesFromUSD.put("EUR", 0.94);
        conversionRatesFromUSD.put("GBP", 0.82);
        conversionRatesFromUSD.put("INR", 68.32);
        conversionRatesFromUSD.put("AUD", 1.35);
        conversionRatesFromUSD.put("CAD", 1.32);
        conversionRatesFromUSD.put("SGD", 1.43);
        conversionRatesFromUSD.put("CHF", 1.01);
        conversionRatesFromUSD.put("MYR", 4.47);
        conversionRatesFromUSD.put("JPY", 115.84);
        conversionRatesFromUSD.put("CNY", 6.92);
    }

    public Double convert(Double amount, String startingCurrency, String targetCurrency) throws ConversionRateNotFound, InvalidMoneyAmount {
        if ( amount < 0.0 ) {
            throw new InvalidMoneyAmount();
        }

        Double startingRate = conversionRatesFromUSD.get(startingCurrency);
        Double endingRate = conversionRatesFromUSD.get(targetCurrency);

        if ( startingRate == null || endingRate == null ) {
            throw new ConversionRateNotFound();
        }

        Double fullAmount = amount * 1/conversionRatesFromUSD.get(startingCurrency) * conversionRatesFromUSD.get(targetCurrency);
        Double truncatedAmount = Math.floor(fullAmount * 100.0) / 100;
        return truncatedAmount;
    }
}
