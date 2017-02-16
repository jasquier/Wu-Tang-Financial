package team4.johnandhilary.wutang;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by johnsquier on 2/16/17.
 */
public class DoubleConverterTest {

    DoubleConverter doubleConverter;
    Double delta = 0.001;

    @Before
    public void setup() {
        doubleConverter = new DoubleConverter();
    }

    @Test
    public void convertDollarsToEurosTest() {
        Double expected = 94.00;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "USD", "EUR");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertEurosToDollarsTest() {
        Double expected = 106.38;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "EUR", "USD");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertEurosToBritishPoundTest() {
        Double expected = 87.23;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "EUR", "GBP");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertBritishPoundToIndianRupeeTest() {
        Double expected = 8331.70;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "GBP", "INR");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertRupeeToCanadianDollarTest() {
        Double expected = 1.93;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "INR", "CAD");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertCanadianDollarToSingaporeDollarTest() {
        Double expected = 108.33;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "CAD", "SGD");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertSingaporeDollarToSwissFrancTest() {
        Double expected = 70.62;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "SGD", "CHF");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertSwissFranceToMalaysianRinggitTest() {
        Double expected = 442.57;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "CHF", "MYR");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertMalaysianRinggitToJapaneseYenTest() {
        Double expected = 2591.49;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "MYR", "JPY");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void convertJapaneseYenToChineseYuanRenminbiTest() {
        Double expected = 5.97;
        Double actual = null;
        try {
            actual = doubleConverter.convert(100.00, "JPY", "CNY");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        } catch ( InvalidMoneyAmount invalidMoneyAmount ) {
            invalidMoneyAmount.printStackTrace();
        }

        Assert.assertEquals(expected, actual, delta);
    }

    @Test(expected = ConversionRateNotFound.class)
    public void convertNonExistantCurrencyToDollarsTest() throws ConversionRateNotFound {
        try {
            doubleConverter.convert(100.00, "AAA", "USD");
        } catch (InvalidMoneyAmount invalidMoneyAmount) {
            invalidMoneyAmount.printStackTrace();
        }
    }

    @Test(expected = ConversionRateNotFound.class)
    public void convertDollarsToNonExistantCurrency() throws ConversionRateNotFound {
        try {
            doubleConverter.convert(100.00, "USD", "AAA");
        } catch (InvalidMoneyAmount invalidMoneyAmount) {
            invalidMoneyAmount.printStackTrace();
        }
    }

    @Test(expected = InvalidMoneyAmount.class)
    public void convertNegativeMoneyAmount() throws InvalidMoneyAmount {
        try {
            doubleConverter.convert(-1.00, "USD", "GBP");
        } catch (ConversionRateNotFound conversionRateNotFound) {
            conversionRateNotFound.printStackTrace();
        }
    }
}
