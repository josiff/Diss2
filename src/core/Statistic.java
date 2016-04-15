/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.text.SimpleDateFormat;

/**
 *
 * @author Jožko
 */
public class Statistic {

    private double casTrvania;
    private double aktReplikacia;
    private double cakanieNakladac;
    private double nakladacCount;
    private double cakanieVykladac;
    private double vykladacCount;
    private double radNakladac;
    // private double radVykladac;
    private double radNakPocet;
    //private double radVykPocet;
    private double squareSum;
    private double test = 0;

    private final double hodnotaZAproxRozd = 1.654;

    public Statistic() {
        casTrvania = 0.0;
        aktReplikacia = 0;
        cakanieNakladac = 0.0;
        cakanieVykladac = 0;
        nakladacCount = 0;
        vykladacCount = 0;
        radNakladac = 0;
        // radVykladac = 0;
        radNakPocet = 0;
        // radVykPocet = 0;*/
        squareSum = 0;
        test = 0;
    }

    public double getCasTrvania() {
        return casTrvania;
    }

    public void addCasTrvania(double casTrvania) {
        this.casTrvania += casTrvania;
        squareSum += Math.pow(casTrvania / 60, 2);
        aktReplikacia++;
    }

    public double getAktReplikacia() {
        return aktReplikacia;
    }

    public double getAvgTrvania() {
        return (getCasTrvania() / getAktReplikacia()) / 60.0;
    }

    public void addCakanieNakladac(double time) {
        cakanieNakladac += time;
        nakladacCount++;
    }

    public double getAvgTimeNakladac() {
        return getCakanieNakladac() / getNakladacCount();
    }

    public double getAvgTimeVykladac() {
        return getCakanieVykladac() / getVykladacCount();
    }

    public void addCakanieVykladac(double time) {
        cakanieVykladac += time;
        vykladacCount++;
    }

    public void addRadNakl(double count, double vaha) {
        radNakladac += count * vaha;
        test += count;

    }

    public double getTest() {
        return test;
    }

    public void setTest(double d) {
        test = d;
    }

    public void addRadNakPocet(double d) {
        radNakPocet += d;

    }

    /*public void addRadVykPocet(double d) {
     radVykPocet += d;
     }

     public void addRadVykl(double count) {
     radVykladac += count;

     }*/
    public double getCakanieNakladac() {
        return cakanieNakladac;
    }

    public void setCakanieNakladac(double cakanieNakladac) {
        this.cakanieNakladac = cakanieNakladac;
    }

    public double getNakladacCount() {
        return nakladacCount;
    }

    public void setNakladacCount(double nakladacCount) {
        this.nakladacCount = nakladacCount;
    }

    public double getCakanieVykladac() {
        return cakanieVykladac;
    }

    public void setCakanieVykladac(double cakanieVykladac) {
        this.cakanieVykladac = cakanieVykladac;
    }

    public double getVykladacCount() {
        return vykladacCount;
    }

    public void setVykladacCount(double vykladacCount) {
        this.vykladacCount = vykladacCount;
    }

    public double getRadNakladac() {
        return radNakladac;
    }

    public void setRadNakladac(double radNakladac) {
        this.radNakladac = radNakladac;
    }

    /* public double getRadVykladac() {
     return radVykladac;
     }

     public void setRadVykladac(double radVykladac) {
     this.radVykladac = radVykladac;
     }*/
    public double getRadNakPocet() {
        return radNakPocet;
    }

    public void setRadNakPocet(double radNakPocet) {
        this.radNakPocet = radNakPocet;
    }
    
    public double getAvgRadNakPocet(){
        return radNakPocet / getAktReplikacia();
    }
    

    /* public double getRadVykPocet() {
     return radVykPocet;
     }

     public void setRadVykPocet(double radVykPocet) {
     this.radVykPocet = radVykPocet;
     }*/
    private double stDev() {
        return Math.sqrt(squareSum / getAktReplikacia() - Math.pow(getAvgTrvania(), 2));
    }

    public double getSpodny90PercIS() {
        return getAvgTrvania() - ((hodnotaZAproxRozd * stDev()) / Math.sqrt(getAktReplikacia() - 1));
    }

    public double getHorny90PercIS() {
        return getAvgTrvania() + ((hodnotaZAproxRozd * stDev()) / Math.sqrt(getAktReplikacia() - 1));
    }

    public void resetStatistic() {
        casTrvania = 0.0;
        aktReplikacia = 0;
        cakanieNakladac = 0.0;
        cakanieVykladac = 0;
        nakladacCount = 0;
        vykladacCount = 0;
        radNakladac = 0;
        //radVykladac = 0;
        radNakPocet = 0;
        // radVykPocet = 0;*/
        squareSum = 0;
    }

}
