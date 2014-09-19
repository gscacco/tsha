/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author mpanagrosso
 */
public class UniqueGenerator {

    private static int _value = 0;

    public static int getInt() {
        return ++_value;
    }

    public static String getString() {
        return "sequence" + (++_value);
    }
}
