/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 * Generates a collection of child nodes representing a sequence of integers.
 */
public class IntegerSequenceChildFactory extends ChildFactory<Integer> {

    private static volatile int nodeCount;
    private final int sequenceLength;

    public static int getCreatedNodesCount() {
        return IntegerSequenceChildFactory.nodeCount;
    }    
    
    public static int resetCreatedNodesCount() {
        return IntegerSequenceChildFactory.nodeCount = 0;
    }    
    
    public IntegerSequenceChildFactory(int sequenceLength) {
        super();
        this.sequenceLength = sequenceLength;
    }

    @Override
    protected boolean createKeys(List<Integer> keys) {
        SequentialIntegers.getSequence(this.sequenceLength, keys);
        return true;
    }

    @Override
    protected Node[] createNodesForKey(Integer key) {
        ++IntegerSequenceChildFactory.nodeCount;
        System.out.println("createNodesForKey current nodeCount: " + IntegerSequenceChildFactory.nodeCount);
        return new Node[]{new GenericLeafNode(Integer.toString(key))};
    }

}
