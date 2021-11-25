package com.netcracker.theater.rtickets.parser;

import java.time.Instant;

public class Dates {
    long start;
    long end;


    public long getStart() {
        return start;
    }
    public void setStart(long start) {
        this.start = start;
    }
    public long getEnd() {
        return end;
    }
    public void setEnd(long end) {
        this.end = end;
    }


    @Override
    public String toString() {
        return "{" +
                "start date='" + Instant.ofEpochSecond(start) + '\'' +
                ", end date='" + Instant.ofEpochSecond(end) + '\'' +
                '}';
    }


}
