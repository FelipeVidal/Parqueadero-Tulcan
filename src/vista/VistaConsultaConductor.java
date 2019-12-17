/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestorConductor;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class VistaConsultaConductor extends javax.swing.JFrame {

    /**
     * Creates new form VistaConsultarConductor
     */
    public VistaConsultaConductor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnGOpcion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rBSelectCodi = new javax.swing.JRadioButton();
        rBSelectId = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdentificacion = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 200));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnGOpcion.add(rBSelectCodi);
        rBSelectCodi.setSelected(true);
        rBSelectCodi.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(rBSelectCodi, gridBagConstraints);

        btnGOpcion.add(rBSelectId);
        rBSelectId.setText("Documento de Identificación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(rBSelectId, gridBagConstraints);

        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnBuscar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new java.awt.GridBagConstraints());

        jLabel1.setText("Ingrese número del documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1, gridBagConstraints);

        txtIdentificacion.setMinimumSize(new java.awt.Dimension(20, 60));
        txtIdentificacion.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(txtIdentificacion, new java.awt.GridBagConstraints());

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new java.awt.GridBagConstraints());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Universidad del cauca ");
        jPanel2.add(jLabel3, new java.awt.GridBagConstraints());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Consultar conductor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jLabel4, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String id;
        GestorConductor consulConductor;
        id = txtIdentificacion.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(null,"Debe ingresar el docuento para continuar");
        }else{
            if(rBSelectCodi.isSelected() == true ){
                consulConductor = new GestorConductor();
                consulConductor.consultarConductorCodigo(id);
            }else{
                consulConductor = new GestorConductor();
                consulConductor.consultarConductorCedula(id);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup btnGOpcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rBSelectCodi;
    private javax.swing.JRadioButton rBSelectId;
    private java.awt.TextField txtIdentificacion;
    // End of variables declaration//GEN-END:variables
}
