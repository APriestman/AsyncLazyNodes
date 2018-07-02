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
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "org.experiments.asynclazynodes.ResetSyncLazyNodesCount"
)
@ActionRegistration(
        displayName = "#CTL_ResetSyncLazyNodesCount"
)
@ActionReference(path = "Menu/Tools", position = 700)
@Messages("CTL_ResetSyncLazyNodesCount=Reset Synchronous Lazy Nodes Count")
public final class ResetSyncLazyNodesCount implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        IntegerSequenceChildren.resetLazyCreatedNodesCount();
    }
}
