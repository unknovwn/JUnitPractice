package com.example.model;

import java.util.Objects;

public class TolkienCharacter {

    // public to test extract on field
    public int age;
    private String name;
    private Race race;
    @SuppressWarnings("unused")
    private long notAccessibleFiled = System.currentTimeMillis();

    public TolkienCharacter(String name, int age, Race race) {
        this.name = name;
        setAge(age);
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age is now allowed to be less than zero");
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TolkienCharacter that = (TolkienCharacter) o;
        return age == that.age && Objects.equals(name, that.name) && race == that.race;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, race);
    }

    @Override
    public String toString() {
        return name + " " + age + " years old " + race.getName();
    }
}
