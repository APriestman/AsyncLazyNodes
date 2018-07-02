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
        id = "org.experiments.asynclazynodes.ResetSyncCreatedNodesCount"
)
@ActionRegistration(
        displayName = "#CTL_ResetSyncCreatedNodesCount"
)
@ActionReference(path = "Menu/Tools", position = 600)
@Messages("CTL_ResetSyncCreatedNodesCount=Reset Synchronous Node Count")
public final class ResetSyncCreatedNodesCount implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        IntegerSequenceChildren.resetCreatedNodesCount();
    }
}
