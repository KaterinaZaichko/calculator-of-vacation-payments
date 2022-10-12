import junit.framework.TestCase;
import models.Calculator;

import java.time.LocalDate;

public class CalculatorTest extends TestCase {
    public void testWithValidateParameters() {
        Calculator calculator = new Calculator(120000.00, LocalDate.of(2022, 10, 13), LocalDate.of(2022, 10, 26));
        String actual = calculator.getVacationPayments();
        String expected = "40955,63";
        assertEquals(expected, actual);
    }

    public void testWithNotValidateParameters() {
        Calculator calculator = new Calculator(120000.00, LocalDate.of(2022, 10, 26), LocalDate.of(2022, 10, 13));
        String actual = calculator.getVacationPayments();
        String expected = "0,00";
        assertEquals(expected, actual);
    }
}