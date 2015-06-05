/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robertwaters
 */
public class Temp {

    private Double day;
    private Double min;
    private Double max;
    private Double night;
    private Double eve;
    private Double morn;

    public String getDay() {
        return day.toString();
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public String getMin() {
        return min.toString();
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

}
