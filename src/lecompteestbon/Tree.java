/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author arthurmanoha
 */
public class Tree {

    // Either the operator (for a non-terminal node) or the value (for a leaf) is defined.
    private String op;
    private int value;

    // The two branches. May be null (i.e. for leaves).
    private Tree left, right;

    /* Default constructor */
    public Tree() {
        op = "";
        value = 0;
        left = null;
        right = null;
    }

    /* Leaf constructor */
    public Tree(int val) {
        value = val;
        left = null;
        right = null;
    }

    /* Node constructor */
    public Tree(int val, String opParam, int val2) {
        left = new Tree(val);
        op = opParam;
        right = new Tree(val2);
        computeValue();
    }

    public Tree(Tree leftParam, String opParam, Tree rightParam) {
        left = leftParam;
        op = opParam;
        right = rightParam;
        computeValue();
    }

    public Tree(int x, String opParam, Tree rightParam) {
        left = new Tree(x);
        op = opParam;
        right = rightParam;
    }

    public Tree(Tree leftParam, String opParam, int x) {
        left = leftParam;
        op = opParam;
        right = new Tree(x);
    }

    /* Copy constructor */
    public Tree(Tree toCopy) {
        this();
    }

    public Tree clone() {
        return new Tree(this);
    }

    public int getValue() {
        return value;
    }

    private void computeValue() {
        int leftVal, rightVal;
        if (left != null) {
            leftVal = left.getValue();
        } else {
            leftVal = 0;
        }
        if (right != null) {
            rightVal = right.getValue();
        } else {
            rightVal = 0;
        }

        switch (op) {
            case "+":
                value = leftVal + rightVal;
            default:
                value = 0;
        }
    }

    public int getWidth() {
        int res = 1; // Root of the current tree.
        if (left != null) {
            res += left.getWidth();
        }
        if (right != null) {
            res += right.getWidth();
        }
        return res;
    }

    public int getDepth() {
        if (left == null && right == null) {
            return 1;
        } else {
            return 1 + Math.max(left.getDepth(), right.getDepth());
        }
    }

    public String toString() {
        if (left == null && right == null) {
            return "" + value;
        } else {
            return op + " " + left + " " + right;
        }
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

//    /**
//     * Print only the given layer of the tree.
//     *
//     * @param depth if 0, print the root; if >0, print the corresponding layer.
//     */
//    private void print(int depth) {
//        // Root
//        if (depth == 0) {
//            for (int i = 0; i < left.getWidth(); i++) {
//                System.out.print(" ");
//            }
//            System.out.print("" + (isLeaf() ? value : op));
//        }
//
//        // Sub-layer
//        
//    }
//
//    /**
//     * Write the elements in a topdown order.
//     */
//    public void print() {
//        for (int depth = 0; depth < this.getDepth(); depth++) {
//            this.print(depth);
//        }
//    }
    /**
     * Compute and return all the trees that we can build by adding the given
     * value and operator to a given set of trees.
     */
    public static ArrayList<Tree> insert(int x, String op, Tree t) {

        ArrayList<Tree> result = new ArrayList<>();
//        result.add(new Tree(x));
        result.add(new Tree(x, op, t));
        result.add(new Tree(t, op, x));

        if (t.left != null) {
            ArrayList<Tree> listOfLeft = insert(x, op, t.left);
            for (Tree modifiedLeftBranch : listOfLeft) {
                result.add(new Tree(modifiedLeftBranch, t.op, t.right));
            }
        }

        if (t.right != null) {
            ArrayList<Tree> listOfRight = insert(x, op, t.right);
            for (Tree modifiedRightBranch : listOfRight) {
                result.add(new Tree(t.left, t.op, modifiedRightBranch));
            }
        }

        return result;
    }

    /**
     * Compute and return all the trees that we can build by adding the given
     * value and operator to a given set of trees.
     *
     * @param val
     * @param op
     * @param treeList
     * @return
     */
    public static ArrayList<Tree> insert(int val, String op, ArrayList<Tree> treeList) {
        ArrayList<Tree> result = new ArrayList<>();
        for (Tree t : treeList) {
            result.addAll(insert(val, op, t));
        }
        return result;
    }

    /**
     * Compute and return all the trees that we can build with the given values
     * and operators.
     *
     * @param values
     * @param ops
     * @return
     */
    public static ArrayList<Tree> getAllTrees(ArrayList<MyInteger> values, ArrayList<ComputationElement> ops) {

        ArrayList<Tree> result = new ArrayList<>();
        for (MyInteger val : values) {
            for (ComputationElement op : ops) {
                result.addAll(insert(val.getValue(), op.toString(), result));
            }
        }
        return result;
    }
}
