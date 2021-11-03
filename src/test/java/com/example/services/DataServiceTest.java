package com.example.services;

import com.example.model.Movie;
import com.example.model.Race;
import com.example.model.Ring;
import com.example.model.TolkienCharacter;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {

    DataService dataService;

    @BeforeEach
    void setUp() {
        dataService = new DataService();
    }

    @Test
    void ensureThatInitializationOfTolkienCharactersWorks() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
        assertEquals(33, frodo.age);
        assertEquals("Frodo", frodo.getName());
        assertNotEquals("Frodon", frodo.getName());
    }

    @Test
    void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
        assertNull(dataService.getFellowshipCharacter("Lars"));
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
        TolkienCharacter fellow = dataService.getFellowshipCharacter("Frodo");
        assertNotNull(fellow);
    }

    @Test
    void ensureThatEqualsWorksForCharacters() {
        Object jake = new TolkienCharacter("Jake", 43, Race.HOBBIT);
        Object sameJake = jake;
        Object jakeClone = new TolkienCharacter("Jake", 12, Race.HOBBIT);

        assertEquals(sameJake, jake);
        assertNotEquals(jakeClone, jake);
    }

    @Test
    void checkInheritance() {
        TolkienCharacter tolkienCharacter = dataService.getFellowship().get(0);
        assertFalse(Movie.class.isAssignableFrom(tolkienCharacter.getClass()));
        assertTrue(TolkienCharacter.class.isAssignableFrom(tolkienCharacter.getClass()));
    }

    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowsip() {
        assertNotNull(dataService.getFellowshipCharacter("Frodo"));
        assertNotNull(dataService.getFellowshipCharacter("Gandalf"));
    }

    @Test
    void ensureThatOneRingBearerIsPartOfTheFellowship() {
        Map<Ring, TolkienCharacter> ringBearers = dataService.getRingBearers();
        assertNotNull(dataService.getFellowshipCharacter(ringBearers.get(Ring.oneRing).getName()));
    }

    @RepeatedTest(1000)
    @Tag("slow")
    @DisplayName("minimal stress testing: run this test 1000 times to ")
    void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
        assertNotNull(dataService.getFellowship());
    }

    @Test
    void ensureOrdering() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        assertEquals(dataService.getFellowshipCharacter("Frodo"), fellowship.get(0));
        assertEquals(dataService.getFellowshipCharacter("Sam"), fellowship.get(1));
        assertEquals(dataService.getFellowshipCharacter("Merry"), fellowship.get(2));
        assertEquals(dataService.getFellowshipCharacter("Pippin"), fellowship.get(3));
        assertEquals(dataService.getFellowshipCharacter("Gandalf"), fellowship.get(4));
        assertEquals(dataService.getFellowshipCharacter("Legolas"), fellowship.get(5));
        assertEquals(dataService.getFellowshipCharacter("Gimli"), fellowship.get(6));
        assertEquals(dataService.getFellowshipCharacter("Aragorn"), fellowship.get(7));
        assertEquals(dataService.getFellowshipCharacter("Boromir"), fellowship.get(8));

    }

    @Test
    void ensureAge() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        assertTrue(fellowship.stream()
                .filter((fellow) -> fellow.getRace() == Race.HOBBIT || fellow.getRace() == Race.MAN)
                .allMatch((fellow) -> fellow.age < 100)
        );
        assertTrue(fellowship.stream()
                .filter((fellow) -> fellow.getRace() == Race.ELF
                        || fellow.getRace() == Race.DWARF
                        || fellow.getRace() == Race.MAIA)
                .allMatch((fellow) -> fellow.age > 100)
        );
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
    }

    @Test
    void ensureServiceDoesNotUpdateTooLong() {
        assertTimeout(Duration.ofSeconds(3), () -> dataService.update());
    }
}