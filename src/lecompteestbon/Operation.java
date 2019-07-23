/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

import java.util.ArrayList;

/**
 *
 * @author arthurmanoha
 */
public class Operation extends ComputationElement {

    private ArrayList<ComputationElement> list;

    public Operation() {
        list = new ArrayList<>();
    }

    /**
     * Constructor with one parameter (valid result if number, discarder later
     * if lone operator).
     *
     * @param e
     */
    public Operation(ComputationElement e) {
        this();
        this.list.add(e);
    }

    public Operation(ComputationElement op, ComputationElement n) {
        this();
        list.add(op);
        list.add(n);
    }

    public String toString() {
        String result = "Operation{";
        for (ComputationElement element : list) {
            result += element;
        }
        result += " }";
        return result;
    }

    public void add(ComputationElement newE) {
        list.add(newE);
    }
}
