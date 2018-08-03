/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import static java.lang.Thread.sleep;
import java.util.Collections;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 * Generates a collection of child nodes representing a sequence of integers.
 */
public class IntegerSequenceChildren extends Children.Keys<Integer> {

    private static volatile int nodeCount;
    private static volatile int lazyNodeCount;
    private final int sequenceLength;
    private final boolean generateNodesWithChildren;
    private final boolean lazy;

    public static int getCreatedNodesCount() {
        return IntegerSequenceChildren.nodeCount;
    }

    public static int getLazyCreatedNodesCount() {
        return IntegerSequenceChildren.lazyNodeCount;
    }

    public static int resetCreatedNodesCount() {
        resetAllCounts();
        return 0;
    }

    public static int resetLazyCreatedNodesCount() {
        resetAllCounts();
        return 0;
    }
    
    private static void resetAllCounts() {
        lazyNodeCount = 0;
        nodeCount = 0;
    }

    public IntegerSequenceChildren(int sequenceLength, boolean generateNodesWithChildren, boolean lazy) {
        super(lazy);
        this.sequenceLength = sequenceLength;
        this.generateNodesWithChildren = generateNodesWithChildren;
        this.lazy = lazy;
    }

    @Override
    protected void addNotify() {
        Integer[] keys = new Integer[sequenceLength];
        SequentialIntegers.getSequence(sequenceLength, keys);
        this.setKeys(keys);
    }

    @Override
    protected void removeNotify() {
        this.setKeys(new Integer[0]);
        if (this.lazy) {
            lazyNodeCount = 0;
        } else {
            nodeCount = 0;
        }
    }

    @Override
    protected Node[] createNodes(Integer key) {
        if (this.lazy) {
            ++lazyNodeCount;
            //System.out.println("createNodes current lazyNodeCount: " + lazyNodeCount + " (" + key + ")");
        } else {
            ++nodeCount;
            //System.out.println("createNodes current nodeCount: " + nodeCount);
        }
        if (this.generateNodesWithChildren) {
            return new Node[]{new GenericParentNode(Integer.toString(key), new IntegerSequenceChildren(sequenceLength, false, lazy))};
        } else {
            return new Node[]{new GenericLeafNode(Integer.toString(key))};
        }
    }

}
