import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class HippodromeTest {

    @Test
    void constructorNameThrowIllegalArgumentException() {
        Throwable hippodrome = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(null));
        assertEquals(IllegalArgumentException.class, hippodrome.getClass());
    }

    @Test
    void constructorNameGetMessageException() {
        Throwable hippodrome = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", hippodrome.getMessage());
    }

    @Test
    void constructorEmptyArrayThrowIllegalArgumentException() {

        List<Horse> horse = new ArrayList<>();
        Throwable hippodrome = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(horse));
        assertEquals(IllegalArgumentException.class, hippodrome.getClass());
    }
    @Test
    void constructorEmptyArrayThrowIllegalArgumentExceptionText() {
        String message = "Horses cannot be empty.";
        List<Horse> horse = new ArrayList<>();
        Throwable hippodrome = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(horse));
        assertEquals(message, hippodrome.getMessage());
    }

    @Test
    void getHorsesQuestions() {
        List<Horse> immutableHorses = List.of(
                new Horse("Thunder", 60, 500),
                new Horse("Blaze", 55, 480),
                new Horse("Shadow", 62, 520),
                new Horse("Storm", 58, 450),
                new Horse("Spirit", 65, 600)
        );
        Hippodrome hippodrome1 = new Hippodrome(immutableHorses);

        List<Horse> horses = hippodrome1.getHorses();
        assertEquals(immutableHorses.size(), horses.size());
        assertArrayEquals(immutableHorses.toArray(), horses.toArray());

    }

    @Test
    void move() {
        List<Horse> array = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            array.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(array);
        hippodrome.move();
        for (Horse horse : array) {
            Mockito.verify(horse, Mockito.times(1)).move();
        }

    }

    @Test
    void getWinner() {
        Horse spirit = new Horse("Spirit", 65, 600);
        List<Horse> immutableHorses = List.of(
                new Horse("Thunder", 60, 500),
                new Horse("Blaze", 55, 480),
                new Horse("Shadow", 62, 520),
                new Horse("Storm", 58, 450),
                spirit
        );

        Hippodrome hippodrome = new Hippodrome(immutableHorses);


        assertEquals(spirit.getName(), hippodrome.getWinner().getName());
    }
}