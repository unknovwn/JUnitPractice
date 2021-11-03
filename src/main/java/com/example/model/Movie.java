package com.example.model;

import java.util.Date;
import java.util.Objects;

public class Movie {

    private String title;
    private Date releaseDate;
    @SuppressWarnings("unused")
    private String duration;

    public Movie(String title, Date releaseDate, String duration) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate);
    }
}
