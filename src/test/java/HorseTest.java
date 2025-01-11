import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import javax.net.ssl.HostnameVerifier;

import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.Assertions.*;

class HorseTest {


    @Test
    public void constructor_NullNameParamPassedThrowsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> new Horse(null,2,2));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t\t", "\t \t"})
    public void constructor_NullNameParamPassedThrowsIllegalArgumentException(String name) {
        String message = "Name cannot be blank.";

        Throwable exception = assertThrows(IllegalArgumentException.class,() -> new Horse(name,2,2));

        assertEquals(message, exception.getMessage());
    }

    @Test
    public void constructor_NegativeSpeedParamPassedThrowsIllegalArgumentException() {
        String message = "Speed cannot be negative.";
        String name = "TestName";
        int speed = 9;
        int distance = 6;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name,speed,distance));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void constructor_NegativeDistanceParamPassedThrowsIllegalArgumentException() {
        String message = "Distance cannot be negative.";
        String name = "TestName";
        int speed = 9;
        int distance = -1;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name,speed,distance));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void getName_GetCurrentName() {
        String name = "TestName";
        int speed = 9;
        int distance = 5;
        Horse horse = new Horse(name, speed, distance);

        String currentName = horse.getName();
        assertEquals(name, currentName);
    }

    @Test
    void getSpeed_GetCurrentSpeed() {
        String name = "TestName";
        int speed = 9;
        int distance = 5;
        Horse horse = new Horse(name, speed, distance);

        double currentSpeed = horse.getSpeed();
        assertEquals(speed, currentSpeed);
    }

    @Test
    void getDistance() {
        String name = "TestName";
        int speed = 9;
        int distance = 5;
        Horse horse = new Horse(name, speed, distance);

        double currentDistance = horse.getDistance();
        assertEquals(distance, currentDistance);
    }

    @Test
    void move_CallsRandomMethod_getRandomDouble() {
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            Horse horse = new Horse("TestName",1,2);

            horse.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2,0.9));

        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2,0.3,0.8,15,8,153})
    void moveCalculates(double faceRandomValue) {
        double min = 0.2;
        double max = 0.9;
        double speed = 2.5;
        double distance = 250;

        Horse horse = new Horse("TestName", speed,distance);
        double expected = distance + speed * faceRandomValue;
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)){
            horseMockedStatic.when(() -> Horse.getRandomDouble(min, max)).thenReturn(faceRandomValue);

            horse.move();

        }
        assertEquals(expected, horse.getDistance());
    }

    @Test
    void getRandomDouble() {
    }
}