import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TemperatureConverterTest {

    public static class TemperatureConverter {
        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 9/5) + 32;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5/9;
        }
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.1);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.1);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.1);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.1);  // Human body temperature
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.1);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.1);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.1);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.1);  // Human body temperature
    }
}
