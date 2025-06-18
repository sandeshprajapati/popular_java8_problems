package com.org.tougher;

import java.time.LocalDate;

public class Review {
    private int rating;
    private LocalDate timestamp;

    public Review(int rating, LocalDate timestamp) {
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", timestamp=" + timestamp +
                '}';
    }
}
