/*
 * NYPS 2020
 * 
 * User: joebin
 * Date: 14-12-19
 * Time: 12:27
 */
package se.joelabs.scalacheck;

/**
 *
 */
public class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
