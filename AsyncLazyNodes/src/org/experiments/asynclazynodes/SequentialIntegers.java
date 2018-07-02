/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import java.util.List;

/**
 * Generates a sequence of integers.
 */
public class SequentialIntegers {

    public static void getSequence(int sequenceLength, Integer[] sequence) {
        for (int i = 0; i < sequenceLength; ++i) {
            sequence[i] = i;
        }
    }

    public static void getSequence(int sequenceLength, List<Integer> sequence) {
        for (int i = 0; i < sequenceLength; ++i) {
            sequence.add(i);
        }
    }    
    
    private SequentialIntegers() {
    }

}
