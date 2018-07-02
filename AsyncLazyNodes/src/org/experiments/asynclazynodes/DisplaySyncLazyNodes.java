/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
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
        id = "org.experiments.asynclazynodes.DisplaySyncLazyNodes"
)
@ActionRegistration(
        displayName = "#CTL_DisplaySyncLazyNodes"
)
@ActionReference(path = "Menu/Tools", position = 3)
@Messages("CTL_DisplaySyncLazyNodes=Display One Layer Synchronously and Lazily")
public final class DisplaySyncLazyNodes implements ActionListener {

    private static final int SEQUENCE_LENGTH = 100;

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
         * RC: WHY IS THIS NOT WORKING AS DOCUMENTED?
         */
        Node rootNode = new AbstractNode(new IntegerSequenceChildren(SEQUENCE_LENGTH, false, true));
        TableViewTopComponent tableView = (TableViewTopComponent) WindowManager.getDefault().findTopComponent("TableViewTopComponent");
        tableView.setRootNode(rootNode);
    }

}
