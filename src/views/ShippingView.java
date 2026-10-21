package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import models.ShippingType;

public class ShippingView extends JFrame {
    
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

        JButton btnRemoveShipping = new JButton();
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

        JTextField txtShippingId = new JTextField();
        txtShippingId.setBounds(110, 10, 100, 25);
        pnlShippings.add(txtShippingId);

        JLabel lblShippingType = new JLabel("Type");
        lblShippingType.setBounds(220, 10, 100, 25);
        pnlShippings.add(lblShippingType);

        JComboBox cmbShippingType = new JComboBox();
        cmbShippingType.setBounds(320, 10, 100, 25);

        DefaultComboBoxModel mdlShippingType = new DefaultComboBoxModel(ShippingType.values());
        cmbShippingType.setModel(mdlShippingType);
        pnlShippings.add(cmbShippingType);

        JLabel lblClient = new JLabel("Client name");
        lblClient.setBounds(10, 45, 100, 25);
        pnlShippings.add(lblClient);

        JTextField txtClient = new JTextField();
        txtClient.setBounds(110, 45, 100, 25);
        pnlShippings.add(txtClient);

        JLabel lblDistance = new JLabel("Distance (Km)");
        lblDistance.setBounds(220, 45, 100, 25);
        pnlShippings.add(lblDistance);

        JTextField txtDistance = new JTextField();
        txtDistance.setBounds(320, 45, 100, 25);
        pnlShippings.add(txtDistance);

        JLabel lblWeight = new JLabel("Weight (Kg)");
        lblWeight.setBounds(10, 80, 100, 25);
        pnlShippings.add(lblWeight);

        JTextField txtWeight = new JTextField();
        txtWeight.setBounds(110, 80, 100, 25);
        pnlShippings.add(txtWeight);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(220, 80, 100, 25);
        pnlShippings.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(220, 80, 100, 25);
        pnlShippings.add(btnCancel);

        JTable tblShippings = new JTable();
        JScrollPane spShippingList = new JScrollPane(tblShippings);
        

        add(pnlShippings);
        
    }
}