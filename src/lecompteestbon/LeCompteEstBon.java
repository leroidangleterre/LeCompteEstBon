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
public class LeCompteEstBon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tree x = new Tree(4, "+", 5);
        System.out.println("" + x);

        ArrayList<Tree> list = Tree.insert(0, "*", x);
        System.out.println("result:");

        for (Tree t : list) {
            System.out.println("\n--------------");
            System.out.print("" + t);
        }

        System.out.println("\n||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||");

        ArrayList<Tree> metaList = Tree.insert(1, "-", list);

        for (Tree t : metaList) {
            System.out.println("\n--------------");
            System.out.print("" + t);
        }

    }

}
