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
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "org.experiments.asynclazynodes.DisplayAsyncNodes"
)
@ActionRegistration(
        displayName = "#CTL_DisplayAsyncNodes"
)
@ActionReference(path = "Menu/Tools", position = 1)
@Messages("CTL_DisplayAsyncNodes=Display One Layer Asynchronously")
public final class DisplayAsyncNodes implements ActionListener {

    private static final int SEQUENCE_LENGTH = 100;

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Display SEQUENCE_LENGTH child nodes of the root node using a Children
         * object implemented in terms of a ChildFactory. Both key creation and
         * node creation happen in background threads while a wait node is
         * displayed. The created nodes are of couse rendered in the EDT, but
         * the nodes are not rendered all at once, they fill in above the wait
         * node, allowing the user to continue to use the UI and to get
         * feedback. However, this incremental node rendering takes longer than
         * when everything is done on the EDT and rendered in one big bang.
         */
        Node rootNode = new AbstractNode(Children.create(new IntegerSequenceChildFactory(SEQUENCE_LENGTH), true));
        TableViewTopComponent tableView = (TableViewTopComponent) WindowManager.getDefault().findTopComponent("TableViewTopComponent");
        tableView.setRootNode(rootNode);
    }

}
