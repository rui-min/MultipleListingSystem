package model;

import java.util.Arrays;

public class Date {

    private int year, mon, day;

    private Date(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Builder pattern for Date obj construction, throw IllegalArgumentException against rejected invalid inputs.
     */
    public static class Builder {
        private int year, mon, day;

        public Builder(){}

        public Builder yearIn(int year){
            this.year = year;
            return this;
        }

        public Builder monthIn(int mon){
            if(mon>=1 && mon<=12)
                this.mon = mon;
            else
                throw new IllegalArgumentException(String.format("Invalid month %d input", mon));
            return this;
        }

        public Builder dayOn(int day){
            Integer[] day31 = {1,3,5,7,8,10,12};
            Integer[] day30 = {4,6,9,11};
            if(Arrays.asList(day31).contains(day) && 1<= day && day <=31
                || Arrays.asList(day30).contains(day) && 1<= day && day <=30
                || this.mon == 2 && 1<= day && day <=29)
                this.day = day;
            else
                throw new IllegalArgumentException(String.format("Invalid day %d in month %d", day, this.mon));
            return this;
        }

        public Date build(){
            Date date = new Date();
            date.year = this.year;
            date.mon = this.mon;
            date.day = this.day;
            return date;
        }
    }
}
