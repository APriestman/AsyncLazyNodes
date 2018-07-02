/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        id = "org.experiments.asynclazynodes.PopupAsyncNodesCount"
)
@ActionRegistration(
        displayName = "#CTL_PopupAsyncNodesCount"
)
@ActionReference(path = "Menu/Tools", position = 200)
@Messages("CTL_PopupAsyncNodesCount=Number of Nodes Created Asynchronously")
public final class PopupAsyncNodesCount implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Nodes created = " + IntegerSequenceChildFactory.getCreatedNodesCount(), NotifyDescriptor.INFORMATION_MESSAGE));
    }
}
