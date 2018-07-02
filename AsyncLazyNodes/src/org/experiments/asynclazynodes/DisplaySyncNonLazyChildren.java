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
        id = "org.experiments.asynclazynodes.DisplaySyncNonLazyChildren"
)
@ActionRegistration(
        displayName = "#CTL_DisplaySyncNonLazyChildren"
)
@ActionReference(path = "Menu/Tools", position = 4)
@Messages("CTL_DisplaySyncNonLazyChildren=Display Two Layers Synchronously")
public final class DisplaySyncNonLazyChildren implements ActionListener {

    private static final int SEQUENCE_LENGTH = 100;

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Display SEQUENCE_LENGTH child nodes of the root node using a Children
         * object with the lazy node creation flag set to FALSE. Both key
         * creation and node creation happen synchronouly in the EDT, freezing
         * the UI until the nodes are all created and displayed.
         *
         * Each node has a set of child nodes that are created in the same way
         * when the parent node is expanded.
         */
        Node rootNode = new AbstractNode(new IntegerSequenceChildren(SEQUENCE_LENGTH, true, false));
        TableViewTopComponent tableView = (TableViewTopComponent) WindowManager.getDefault().findTopComponent("TableViewTopComponent");
        tableView.setRootNode(rootNode);
    }

}
