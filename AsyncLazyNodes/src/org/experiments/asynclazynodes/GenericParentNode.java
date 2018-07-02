/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 * A generic parent node.
 */
public class GenericParentNode extends AbstractNode {
   
    public GenericParentNode(String displayName, Children children) {
        super(children);
        this.setDisplayName(displayName);        
    }    
    
}
