/*
 * AsyncLazyNodes Prototype
 * Copyright 2018 Basis Technology Corp.
 */
package org.experiments.asynclazynodes;

import java.awt.BorderLayout;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.explorer.view.ListView;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import org.openide.explorer.view.OutlineView;
import org.openide.explorer.view.TableView;
import org.openide.explorer.view.TreeTableView;
import org.openide.explorer.view.*;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import java.awt.event.*;
import java.util.Objects;
import java.util.Comparator;
import java.util.List;
import javax.swing.event.*;
import javax.swing.table.*;
import org.netbeans.swing.etable.*;
import org.openide.nodes.Node;
import javax.swing.event.TableColumnModelListener;
import org.openide.nodes.ChildFactory;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Editor mode top component with an OutlineView to provide a tabular display of
 * some nodes.
 */
@ConvertAsProperties(
        dtd = "-//org.experiments.asynclazynodes//TableView//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "TableViewTopComponent",
        iconBase = "org/experiments/asynclazynodes/renzix.gif",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.experiments.asynclazynodes.TableViewTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_TableViewAction",
        preferredID = "TableViewTopComponent"
)
@Messages({
    "CTL_TableViewAction=TableView",
    "CTL_TableViewTopComponent=TableView Window",
    "HINT_TableViewTopComponent=This is a TableView window"
})
public final class TableViewTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static final long serialVersionUID = 1L;
    private final ExplorerManager explorerManager;
    public TableView tableView;
    List<String> originalKeys = new ArrayList<>();

    public TableViewTopComponent() {
        this.explorerManager = new ExplorerManager();
        initComponents();
        setName(Bundle.CTL_TableViewTopComponent());
        setToolTipText(Bundle.HINT_TableViewTopComponent());
        setLayout(new BorderLayout());
        
        for(int i = 0;i < 100;i++){
            originalKeys.add(String.valueOf(i));
            originalKeys.add(String.valueOf(i + 100));
        }
 
        final OutlineView view = new OutlineView();
        //ListView view = new ListView();
        //TreeTableView view = new TreeTableView();
        //BeanTreeView view = new BeanTreeView();
        //ContextTreeView view = new ContextTreeView();
        //TableView view = new TableView();
        //tableView = view;
        //Node tempNode = new AbstractNode(new IntegerSequenceChildren(1, false, true));
        //Node.Property[] props = tempNode.getPropertySets()[0].getProperties();
        //((NodeTableModel) view.getTable().setModel(dataModel)
        
        view.getOutline().getTableHeader().addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3 || e.getClickCount() != 1) {
                  // The other buttons are used for sorting; we are not interested.
                  return;
                }

                int column = view.getOutline().columnAtPoint(e.getPoint());

                if (column < 0) {
                  return;
                }

                TableColumnModel tcm = view.getOutline().getColumnModel();
                if (tcm instanceof ETableColumnModel) {
                  TableColumn tc = tcm.getColumn(column);

                  if (tc instanceof ETableColumn) {
                    ETableColumn etc = (ETableColumn) tc;

                    if(originalKeys.size() > 0) {
                        
                        // Make a copy of the original keys
                        // I think we need this to restore the original view
                        ArrayList<String> sortedNames = new ArrayList<>();
                        for(int i = 0;i < originalKeys.size();i++) {
                            sortedNames.add(originalKeys.get(i));
                        }
                        
                        // If we're sorting the column, sort the list appropriately
                        if(etc.isSorted() && etc.isAscending()) {
                            Collections.sort(sortedNames);
                        } else if(etc.isSorted()) {
                            Collections.sort(sortedNames, Collections.reverseOrder());
                        }
                        
                        // Make and set a new root node using the sorted list
                        Node newRoot = new AbstractNode(Children.create(new TestingChildren(sortedNames), false));
                        setRootNode(newRoot);
                    }

                    view.getOutline().clearSelection();
                  }
                }
              }
            });    
        
        //view.setRootVisible(false);
        add(view, BorderLayout.CENTER);
        associateLookup(ExplorerUtils.createLookup(this.explorerManager, getActionMap())); 
    }
    
    static class DisplayNameComparator implements Comparator<Node>
    {        
        @Override
         public int compare(Node c1, Node c2)
         {
             // Needs some null checking really
             return c1.getDisplayName().compareTo(c2.getDisplayName());
         }
     }

    @Override
    public ExplorerManager getExplorerManager() {
        return this.explorerManager;
    }
    
    public void setRootNode(Node rootNode) {
        
        //Node newRoot = new AbstractNode(Children.create(new TestingChildren(rootNode), true));
        Node newRoot = new AbstractNode(Children.create(new TestingChildren(this.originalKeys), false));
        
        this.explorerManager.setRootContext(newRoot);
    }
    
    private static class TestingChildren extends ChildFactory<String> {

        private List<String> nodeList = null;

        private TestingChildren(List<String> nodeList) {
            this.nodeList = nodeList;
        }

        @Override
        synchronized protected boolean createKeys(List<String> list) {

            int max = nodeList.size();
            if(max > 10) {
                max = 10;
            }
            for(int i = 0;i < max;i++){
                list.add(nodeList.get(i));
            }
            
            return true;
        }

        @Override
        protected Node createNodeForKey(String index) {
            return new GenericLeafNode(index);
        }
    }    
    
    void writeProperties(java.util.Properties p) {
    }

    void readProperties(java.util.Properties p) {
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
