package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import models.ShippingType;

public class ShippingView extends JFrame {

    private JComboBox cmbShippingType;
    private JTextField txtShippingId, txtClient, txtDistance, txtWeight;
    private JButton btnSave, btnRemoveShipping;
    private JTable tblShippings;

    public ShippingView() {
        setSize(600, 400);
        setTitle("Shippings");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JToolBar tbSuperiorButtons = new JToolBar();
        tbSuperiorButtons.setBounds(0, 0, 600, 100);

        JButton btnAddShipping = new JButton();
        btnAddShipping.setIcon(new ImageIcon(getClass().getResource("/icons/add_shipping.png")));
        btnAddShipping.setToolTipText("Add Shipping");
        //btnAddShipping.addActionListener(evt -> {
        //    btnAddShippingClick();
        //});
        tbSuperiorButtons.add(btnAddShipping);

        btnRemoveShipping = new JButton();
        btnRemoveShipping.setIcon(new ImageIcon(getClass().getResource("/icons/remove_shipping.png")));
        btnRemoveShipping.setToolTipText("Remove Shipping");
        tbSuperiorButtons.add(btnRemoveShipping);
        add(tbSuperiorButtons);

        JPanel pnlShippings = new JPanel();
        pnlShippings.setLayout(null);
        pnlShippings.setBounds(0, 110, 600, 290);

        JLabel lblShippingId = new JLabel("Id Number");
        lblShippingId.setBounds(10, 10, 100, 25);
        pnlShippings.add(lblShippingId);

        txtShippingId = new JTextField();
        txtShippingId.setBounds(110, 10, 100, 25);
        pnlShippings.add(txtShippingId);

        JLabel lblShippingType = new JLabel("Type");
        lblShippingType.setBounds(220, 10, 100, 25);
        pnlShippings.add(lblShippingType);

        cmbShippingType = new JComboBox();
        cmbShippingType.setBounds(320, 10, 100, 25);

        DefaultComboBoxModel mdlShippingType = new DefaultComboBoxModel(ShippingType.values());
        cmbShippingType.setModel(mdlShippingType);
        pnlShippings.add(cmbShippingType);

        JLabel lblClient = new JLabel("Client name");
        lblClient.setBounds(10, 45, 100, 25);
        pnlShippings.add(lblClient);

        txtClient = new JTextField();
        txtClient.setBounds(110, 45, 100, 25);
        pnlShippings.add(txtClient);

        JLabel lblDistance = new JLabel("Distance (Km)");
        lblDistance.setBounds(220, 45, 100, 25);
        pnlShippings.add(lblDistance);

        txtDistance = new JTextField();
        txtDistance.setBounds(320, 45, 100, 25);
        pnlShippings.add(txtDistance);

        JLabel lblWeight = new JLabel("Weight (Kg)");
        lblWeight.setBounds(10, 80, 100, 25);
        pnlShippings.add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setBounds(110, 80, 100, 25);
        pnlShippings.add(txtWeight);

        btnSave = new JButton("Save");
        btnSave.setBounds(220, 80, 100, 25);
        pnlShippings.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(220, 80, 100, 25);
        pnlShippings.add(btnCancel);

        tblShippings = new JTable();
        JScrollPane spShippingList = new JScrollPane(tblShippings);
        
        add(pnlShippings);
        add(spShippingList);
    }

    public String getIdNumber() {
        return txtShippingId.getText();
    }

    public ShippingType getShippingTypeSelected() {
        return (ShippingType) cmbShippingType.getSelectedItem();
    }

    public String getClientName() {
        return txtClient.getText();
    }

    public double getDistance() {
        try{
            return Double.parseDouble(txtDistance.getText());
        } catch (Exception ex) {
            return 0;
        }
    } 
    
    public double getWeight() {
        try{
            return Double.parseDouble(txtWeight.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public void setSaveClick(ActionListener actionListener) {
        btnSave.addActionListener(actionListener);
    }

    public void showShippings(String[][] data, String[] headers) {
        DefaultTableModel dtm = new DefaultTableModel(data, headers);
        tblShippings.setModel(dtm);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public boolean confirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    
}