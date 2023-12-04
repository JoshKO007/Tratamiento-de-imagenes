/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;
/**
 *
 * @author joshtin_mac
 */
public class PanelUmbralizacion extends javax.swing.JPanel {

    /**
     * Creates new form PanelUmbralizacion
     */
    public PanelUmbralizacion() {
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

        Combo1 = new javax.swing.JComboBox<>();
        jUmbral1 = new javax.swing.JLabel();
        jUmbral2 = new javax.swing.JLabel();
        jTexto1 = new javax.swing.JTextField();
        jTexto2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Umbralización"));

        Combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona método...", "Inverso", "Umbral", "Umbral inverso", "Intervalo de umbral", "Intervalo de umbral inverso", "Intervalo de umbral en gris", "Intervalo de umbral en gris inverso" }));
        Combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo1ActionPerformed(evt);
            }
        });

        jUmbral1.setText("Umbral 1:");

        jUmbral2.setText("Umbral 2:");

        jTexto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexto1ActionPerformed(evt);
            }
        });

        jButton1.setText("Aplicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Umbralización");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jUmbral2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jUmbral1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(Combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUmbral1)
                    .addComponent(jTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUmbral2)
                    .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexto1ActionPerformed

    private void Combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo1ActionPerformed
     String seleccion = (String) Combo1.getSelectedItem();
    if (seleccion.equals("Inverso")) {
        jUmbral1.setVisible(false);
        jTexto1.setVisible(false);
        jUmbral2.setVisible(false);
        jTexto2.setVisible(false);
    } else if (seleccion.equals("Umbral")){
        jUmbral1.setVisible(true);
        jTexto1.setVisible(true);
        jUmbral2.setVisible(false);
        jTexto2.setVisible(false);        
    } else if (seleccion.equals("Umbral inverso")){
        jUmbral1.setVisible(true);
        jTexto1.setVisible(true);
        jUmbral2.setVisible(false);
        jTexto2.setVisible(false);  
    } else {
        jUmbral1.setVisible(true);
        jTexto1.setVisible(true);
        jUmbral2.setVisible(true);
        jTexto2.setVisible(true);         
    } 
    }//GEN-LAST:event_Combo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> Combo1;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField jTexto1;
    public javax.swing.JTextField jTexto2;
    public javax.swing.JLabel jUmbral1;
    public javax.swing.JLabel jUmbral2;
    // End of variables declaration//GEN-END:variables
}