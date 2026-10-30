package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import models.ShippingType;

public class ShippingView extends JFrame {

    private JComboBox cmbShippingType;
    private JTextField txtShippingId, txtClient, txtDistance, txtWeight, txtRemoveShippingId;
    private JButton btnSave, btnRemoveShipping, btnCancelRemove, btnclose;
    private DefaultTableModel dtm;
    private JTable tblShippings1, tblShippings2;
    private JTabbedPane tp;
    private JPanel pnlEditShipping, pnlRemoveByShippingId;
    private final ImageIcon imgAddShipping = new ImageIcon(
            new ImageIcon(getClass().getResource("/icons/add_shipping.png"))
                    .getImage()
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            imgRemoveShipping = new ImageIcon(
                    new ImageIcon(getClass().getResource("/icons/remove_shipping.png"))
                            .getImage()
                            .getScaledInstance(100, 100, Image.SCALE_SMOOTH));

    public ShippingView() {
        setSize(600, 400);
        setTitle("Shippings");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar tbSuperiorButtons = new JToolBar();

        JButton btnAddShippingSuperior = new JButton();
        btnAddShippingSuperior.setIcon(imgAddShipping);
        btnAddShippingSuperior.setToolTipText("Agregar envio");
        btnAddShippingSuperior.addActionListener(evt -> {
            btnAddShippingClick();
        });
        tbSuperiorButtons.add(btnAddShippingSuperior);

        JButton btnRemoveShippingSuperior = new JButton();
        btnRemoveShippingSuperior.setIcon(imgRemoveShipping);
        btnRemoveShippingSuperior.setToolTipText("Remover envio");
        btnRemoveShippingSuperior.addActionListener(evt -> {
            btnRemoveShippingClick();
        });
        tbSuperiorButtons.add(btnRemoveShippingSuperior);

        JPanel pnlAddShipping = new JPanel();
        pnlAddShipping.setLayout(new BoxLayout(pnlAddShipping, BoxLayout.Y_AXIS));

        pnlEditShipping = new JPanel();
        pnlEditShipping.setPreferredSize(new Dimension(pnlEditShipping.getWidth(), 110));
        pnlEditShipping.setLayout(null);
        pnlEditShipping.setVisible(false);

        JLabel lblShippingId = new JLabel("Codigo ID");
        lblShippingId.setBounds(10, 10, 100, 25);
        pnlEditShipping.add(lblShippingId);

        txtShippingId = new JTextField();
        txtShippingId.setBounds(110, 10, 100, 25);
        pnlEditShipping.add(txtShippingId);

        JLabel lblShippingType = new JLabel("Tipo");
        lblShippingType.setBounds(220, 10, 100, 25);
        pnlEditShipping.add(lblShippingType);

        cmbShippingType = new JComboBox();
        cmbShippingType.setBounds(320, 10, 100, 25);

        DefaultComboBoxModel mdlShippingType = new DefaultComboBoxModel(ShippingType.values());
        cmbShippingType.setModel(mdlShippingType);
        pnlEditShipping.add(cmbShippingType);

        JLabel lblClient = new JLabel("Cliente");
        lblClient.setBounds(10, 45, 100, 25);
        pnlEditShipping.add(lblClient);

        txtClient = new JTextField();
        txtClient.setBounds(110, 45, 100, 25);
        pnlEditShipping.add(txtClient);

        JLabel lblDistance = new JLabel("Distancia (Km)");
        lblDistance.setBounds(220, 45, 100, 25);
        pnlEditShipping.add(lblDistance);

        txtDistance = new JTextField();
        txtDistance.setBounds(320, 45, 100, 25);
        pnlEditShipping.add(txtDistance);

        JLabel lblWeight = new JLabel("Peso (Kg)");
        lblWeight.setBounds(10, 80, 100, 25);
        pnlEditShipping.add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setBounds(110, 80, 100, 25);
        pnlEditShipping.add(txtWeight);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(220, 80, 100, 25);
        pnlEditShipping.add(btnSave);

        JButton btnCancelAdd = new JButton("Cancelar");
        btnCancelAdd.setBounds(320, 80, 100, 25);
        btnCancelAdd.addActionListener(evt -> {
            btnCancelEditShippingClick();
        });
        pnlEditShipping.add(btnCancelAdd);

        dtm = new DefaultTableModel();
        tblShippings1 = new JTable(dtm);
        JScrollPane spShippingList1 = new JScrollPane(tblShippings1);

        pnlAddShipping.add(pnlEditShipping);
        pnlAddShipping.add(spShippingList1);

        JScrollPane spAddShipping = new JScrollPane(pnlAddShipping);
        spAddShipping.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel pnlRemoveShipping = new JPanel();
        pnlRemoveShipping.setLayout(new BoxLayout(pnlRemoveShipping, BoxLayout.Y_AXIS));

        pnlRemoveByShippingId = new JPanel();
        pnlRemoveByShippingId.setPreferredSize(new Dimension(pnlEditShipping.getWidth(), 70));
        pnlRemoveByShippingId.setLayout(null);
        pnlRemoveByShippingId.setVisible(false);

        JLabel lblRemoveShippingId = new JLabel("Codigo ID");
        lblRemoveShippingId.setBounds(10, 10, 100, 25);
        pnlRemoveByShippingId.add(lblRemoveShippingId);

        txtRemoveShippingId = new JTextField();
        txtRemoveShippingId.setBounds(110, 10, 100, 25);
        pnlRemoveByShippingId.add(txtRemoveShippingId);

        btnRemoveShipping = new JButton("Eliminar");
        btnRemoveShipping.setBounds(210, 10, 100, 25);
        pnlRemoveByShippingId.add(btnRemoveShipping);

        btnCancelRemove = new JButton("Cancelar");
        btnCancelRemove.setBounds(310, 10, 100, 25);
        pnlRemoveByShippingId.add(btnCancelRemove);
        btnCancelRemove.addActionListener(evt -> {
            btnCancelRemoveShippingClick();
        });
        pnlEditShipping.add(btnCancelAdd);

        tblShippings2 = new JTable(dtm);
        JScrollPane sptblShippings2 = new JScrollPane(tblShippings2);
        
        pnlRemoveShipping.add(pnlRemoveByShippingId);
        pnlRemoveShipping.add(sptblShippings2);

        JScrollPane spRemoveShipping = new JScrollPane(pnlRemoveShipping);
        spRemoveShipping.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        tp = new JTabbedPane();
        tp.addTab("Agregar envio", spAddShipping);
        tp.addTab("Eliminar envio", spRemoveShipping);

        add(tbSuperiorButtons, BorderLayout.NORTH);
        add(tp, BorderLayout.CENTER);
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
        try {
            return Double.parseDouble(txtDistance.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public double getWeight() {
        try {
            return Double.parseDouble(txtWeight.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public int getSelectedShipping() {
        return tblShippings2.getSelectedRow();
    }

    public String getIdNumberForRemoving() {
        return txtRemoveShippingId.getText();
    }

    public void setSaveClick(ActionListener actionListener) {
        btnSave.addActionListener(actionListener);
    }

    public void setTableSelectionListener(ListSelectionListener selectionListener) {
        tblShippings2.getSelectionModel().addListSelectionListener(selectionListener);
    }

    public void showShippings(String[][] data, String[] headers) {
        dtm.setDataVector(data, headers);
    }

    public void setTxtRemoveShippingId(String id) {
        txtRemoveShippingId.setText(id);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public boolean confirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirmar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void setRemoveClick(ActionListener actionListener) {
        btnRemoveShipping.addActionListener(actionListener);
    }

    public void hideAddPnlShipping() {
        pnlEditShipping.setVisible(false);
    }

    private void btnAddShippingClick() {
        pnlEditShipping.setVisible(true);
        tp.setSelectedIndex(0);
    }

    public void hideRemovePnlShipping() {
        pnlRemoveByShippingId.setVisible(false);
    }

    private void btnRemoveShippingClick() {
        pnlRemoveByShippingId.setVisible(true);
        tp.setSelectedIndex(1);
    }

    private void btnCancelEditShippingClick() {
        hideAddPnlShipping();
    }

    private void btnCancelRemoveShippingClick() {
        hideRemovePnlShipping();
    }

}