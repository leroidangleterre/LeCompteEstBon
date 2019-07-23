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
public class Operator extends ComputationElement {

    private String type;

    public Operator(String newType) {
        type = newType;
    }

    public String toString() {
        return " " + type + " ";
    }
}
