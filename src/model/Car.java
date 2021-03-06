/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jožko
 */
public class Car {

    private String typ;
    private double rychlost;
    private double pravPoruch;
    private double oprava;
    private double objem;
    private double zacCakania;
    private double endObsluhy;
    private double startObsluhy;
    private String usek;
    private double nalozene;

    public Car(String typ, double rychlost, double pravPoruch, double oprava, int objem) {
        this.typ = typ;
        this.rychlost = rychlost;
        this.pravPoruch = pravPoruch;
        this.oprava = oprava;
        this.objem = objem;
        this.zacCakania = 0;
        this.usek = "";
        this.nalozene = 0;
    }

    public double getNalozene() {
        return nalozene;
    }

    public double getRychlost() {
        return rychlost;
    }

    public void setNalozene(double nalozene) {
        this.nalozene = nalozene;
    }

    public double getCasCesty(double dlzka) {

        return dlzka / rychlost;

    }

    public double getEndObsluhy() {
        return endObsluhy;
    }

    public void setEndObsluhy(double endNakladky) {
        this.endObsluhy = endNakladky;
    }

    public void setZacCakania(double zacCakania) {
        this.zacCakania = zacCakania;
    }

    public void setUsek(String usek) {
        this.usek = usek;
    }

    public String getTyp() {
        return typ;
    }

    public double getPravPoruch() {
        return pravPoruch;
    }

    public double getOprava() {
        return oprava;
    }

    public double getObjem() {
        return objem;
    }

    public double getZacCakania() {
        return zacCakania;
    }

    public String getUsek() {
        return usek;
    }

    public double getAktStav(double aktCas) {
        if (endObsluhy > aktCas) {

            /*if (getNalozene() == 0) {
             //core.mnozMat*100/core.sklad
             double d = ((aktCas - startObsluhy) * getObjem()) / (endObsluhy - startObsluhy);

             int v = (int) d * 100;
             return ((v) / getObjem());
             } else {
             double d = ((aktCas - startObsluhy) * getNalozene()) / (endObsluhy - startObsluhy);
             int v = (int) d * 100;
             return 100 - ((v) / getObjem());
             }
             } else {
             return 100 * getNalozene() / getObjem();
             }*/
            if (getNalozene() == 0) {

                double objem = (endObsluhy /60 - aktCas/60) * 180.0 * 10 ;
                int v = (int) objem * 10 ;
                return 100 - v / getObjem();

            } else {

                double objem = (endObsluhy/60 - aktCas/60) * 200.0 * 10;
                int v = (int) objem * 10;
                return  (v / getObjem());

            }
        } else {

            return 100 * getNalozene() / getObjem();
        }

    }

    public double getStartObsluhy() {
        return startObsluhy;
    }

    public void setStartObsluhy(double startObsluhy) {
        this.startObsluhy = startObsluhy;
    }

}
