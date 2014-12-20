/*
 * NYPS 2020
 * 
 * User: joel
 * Date: 2014-12-20
 * Time: 15:11
 */
package se.joelabs.scalacheck;

/**
 *
 */
public class Converter {
    private Moj moj;

    public Converter(Moj moj) {
        this.moj = moj;
    }

    public Manik convert(Pryl pryl) {
        return new Manik(moj.get(pryl.id) + pryl.age);
    }
}
