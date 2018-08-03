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
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "org.experiments.asynclazynodes.DisplaySyncNonLazyNodes"
)
@ActionRegistration(
        displayName = "#CTL_DisplaySyncNonLazyNodes"
)
@ActionReference(path = "Menu/Tools", position = 2)
@Messages("CTL_DisplaySyncNonLazyNodes=Display One Layer Sychronously")
public final class DisplaySyncNonLazyNodes implements ActionListener {

    private static final int SEQUENCE_LENGTH = 1000;

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Display SEQUENCE_LENGTH child nodes of the root node using a Children
         * object with the lazy node creation flag set to FALSE. Both key
         * creation and node creation happen synchronouly in the EDT, freezing
         * the UI until the nodes are all created and displayed.
         */
        Node rootNode = new AbstractNode(new IntegerSequenceChildren(SEQUENCE_LENGTH, false, false));
        TableViewTopComponent tableView = (TableViewTopComponent) WindowManager.getDefault().findTopComponent("TableViewTopComponent");
        tableView.setRootNode(rootNode);
    }

}
