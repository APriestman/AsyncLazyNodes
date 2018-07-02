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
        id = "org.experiments.asynclazynodes.DisplaySyncCreatedNodes"
)
@ActionRegistration(
        displayName = "#CTL_DisplaySyncCreatedNodes"
)
@ActionReference(path = "Menu/Tools", position = 300)
@Messages("CTL_DisplaySyncCreatedNodes=Number of Nodes Created Synchronously")
public final class PopupSyncNonLazyNodesCount implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Nodes created = " + IntegerSequenceChildren.getCreatedNodesCount(), NotifyDescriptor.INFORMATION_MESSAGE));
    }

}
