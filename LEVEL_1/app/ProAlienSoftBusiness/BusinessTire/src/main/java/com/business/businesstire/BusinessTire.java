package com.business.businesstire;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class BusinessTire extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTable table2;
    private JButton refreshMetadataButton;
    private JButton refreshDBCacheButton;
    DefaultTableModel dtm;
    BTCallbacks btCallbacks;

    public void setBtCallbacks(BTCallbacks btCallbacks) {
        this.btCallbacks = btCallbacks;
    }

    public BusinessTire() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        add(panel1);
        setSize(800, 400);
        setTitle("Starting business tire");

    }


    private void createUIComponents() {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        dtm.addColumn("Name");
        dtm.addColumn("Status");
        table1 = new JTable(dtm);
        table1.setAutoCreateRowSorter(true);
    }

    public void AddMetaDataToTable(String[][] data) {
        removeDataIfPresent();
        for (int i = 0; i < data.length; i++) {
            dtm.addRow(data[i]);
        }

    }

    private void removeDataIfPresent() {
        int rows = dtm.getRowCount();
        for (int i = 0; i < rows; i++) {
            dtm.removeRow(0);
        }
    }

    public void StartBT() {
        setTitle("Started");
    }

    public void setupButtons() {
        refreshMetadataButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btCallbacks.RefreshMetadata();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public interface BTCallbacks {
        void RefreshMetadata() throws Exception;
    }


}
