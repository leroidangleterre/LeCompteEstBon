/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

/**
 *
 * @author arthurmanoha
 */
public class MyInteger extends ComputationElement {

    private int val;

    public MyInteger(int value) {
        super(value);
        val = value;
    }

    public String toString() {
        return "(" + val + ")";
    }

    public int getValue() {
        return val;
    }

}
