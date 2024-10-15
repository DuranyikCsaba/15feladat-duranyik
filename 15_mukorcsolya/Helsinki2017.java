package org.example;

public class Helsinki2017 {
    public static class Versenyzo {
        String nev;
        String orszag;
        double technikaiPont;
        double komponensPont;
        double hibaPont;
        double osszPontszam;

        public Versenyzo(String nev, String orszag, double technikaiPont, double komponensPont, double hibaPont) {
            this.nev = nev;
            this.orszag = orszag;
            this.technikaiPont = technikaiPont;
            this.komponensPont = komponensPont;
            this.hibaPont = hibaPont;
            this.osszPontszam = technikaiPont + komponensPont - hibaPont;
        }
    }
}
