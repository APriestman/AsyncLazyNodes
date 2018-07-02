/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "org.experiments.asynclazynodes.DisplaySyncLazyCreatedNodesCount"
)
@ActionRegistration(
        displayName = "#CTL_DisplaySyncLazyCreatedNodesCount"
)
@ActionReference(path = "Menu/Tools", position = 400)
@Messages("CTL_DisplaySyncLazyCreatedNodesCount=Number of Nodes Created Synchronously and Lazily")
public final class PopupSyncLazyNodesCount implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Nodes created = " + IntegerSequenceChildren.getLazyCreatedNodesCount(), NotifyDescriptor.INFORMATION_MESSAGE));
    }
}
