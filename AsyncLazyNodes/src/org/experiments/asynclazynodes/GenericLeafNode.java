/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 * A generic leaf node.
 */
public class GenericLeafNode extends AbstractNode {
    
    public GenericLeafNode(String displayName) {
        super(Children.LEAF);
        this.setDisplayName(displayName);        
    }
    
}
