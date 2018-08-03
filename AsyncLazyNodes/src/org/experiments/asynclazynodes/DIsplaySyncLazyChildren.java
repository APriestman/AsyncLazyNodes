/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.experiments.asynclazynodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "org.experiments.asynclazynodes.DisplayLazyChildren"
)
@ActionRegistration(
        displayName = "#CTL_DisplayLazyChildren"
)
@ActionReference(path = "Menu/Tools", position = 5)
@Messages("CTL_DisplayLazyChildren=Display Two Layers Synchronously and Lazily")
public final class DIsplaySyncLazyChildren implements ActionListener {
    
    private static final int SEQUENCE_LENGTH = 1000;        

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Display SEQUENCE_LENGTH child nodes of the root node using a Children
         * object with the lazy node creation flag set to TRUE. Both key
         * creation and node creation happen synchronouly in the EDT, freezing
         * the UI until the nodes are all created and displayed. However, the
         * nodes are only created as needed, i.e., as the user scrolls them into
         * view.
         * 
         * Each node has a set of child nodes that are created in the same way
         * when the parent node is expanded.
         * 
         * RC: WHY IS THIS NOT WORKING AS DOCUMENTED?
         */        
        Node rootNode = new AbstractNode(new IntegerSequenceChildren(SEQUENCE_LENGTH, true, true));
        TableViewTopComponent tableView = (TableViewTopComponent)WindowManager.getDefault().findTopComponent("TableViewTopComponent");
        tableView.setRootNode(rootNode);    }
}
