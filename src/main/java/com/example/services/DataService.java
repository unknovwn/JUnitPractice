package com.example.services;

import com.example.model.Movie;
import com.example.model.Ring;
import com.example.model.TolkienCharacter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.model.Race.*;

public class DataService {

    static final String ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION = "{} assertion: {}\n";

    final TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);

    final TolkienCharacter sam = new TolkienCharacter("Sam", 38, HOBBIT);

    final TolkienCharacter merry = new TolkienCharacter("Merry", 36, HOBBIT);

    final TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, HOBBIT);

    final TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, MAIA);

    final TolkienCharacter gimli = new TolkienCharacter("Gimli", 139, DWARF);

    final TolkienCharacter legolas = new TolkienCharacter("Legolas", 1000, ELF);

    final TolkienCharacter aragorn = new TolkienCharacter("Aragorn", 87, MAN);

    final TolkienCharacter boromir = new TolkienCharacter("Boromir", 37, MAN);

    final TolkienCharacter sauron = new TolkienCharacter("Sauron", 50000, MAIA);

    final TolkienCharacter galadriel = new TolkienCharacter("Galadriel", 3000, ELF);

    final TolkienCharacter elrond = new TolkienCharacter("Elrond", 3000, ELF);

    final TolkienCharacter guruk = new TolkienCharacter("Guruk", 20, ORC);


    final Movie theFellowshipOfTheRing = new Movie("the fellowship of the Ring", new Date(), "178 min");

    final Movie theTwoTowers = new Movie("the two Towers", new Date(), "179 min");

    final Movie theReturnOfTheKing = new Movie("the Return of the King", new Date(), "201 min");


    public List<TolkienCharacter> getFellowship() {
        return List.of(frodo, sam, merry, pippin, gandalf, legolas, gimli, aragorn, boromir);
    }

    public List<TolkienCharacter> getOrcsWithHobbitPrisoners() {
        return List.of(guruk, merry, pippin);
    }

    public TolkienCharacter getFellowshipCharacter(String name) {
        return getFellowship().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public Map<Ring, TolkienCharacter> getRingBearers() {
        return Map.of(
                Ring.nenya, galadriel,
                Ring.narya, gandalf,
                Ring.vilya, elrond,
                Ring.oneRing, frodo
        );
    }

    public boolean update() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
