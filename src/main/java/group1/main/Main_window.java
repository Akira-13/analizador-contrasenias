package group1.main;

import java.awt.Color;

public class Main_window extends javax.swing.JFrame {
    static Asistente ai = new Asistente();
    public Main_window() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bckgrnd = new javax.swing.JPanel();
        another_bckground = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        enter_pass = new javax.swing.JTextField();
        vertical_spt = new javax.swing.JSeparator();
        continue_btn = new javax.swing.JButton();
        results_lbl = new javax.swing.JLabel();
        show_results = new javax.swing.JScrollPane();
        text_area_results = new javax.swing.JTextArea();
        suggest_lbl = new javax.swing.JLabel();
        gen_new_lbl = new javax.swing.JLabel();
        main_spt = new javax.swing.JPanel();
        hasLower_btn = new javax.swing.JRadioButton();
        newLength_lbl = new javax.swing.JLabel();
        newLenght_field = new javax.swing.JTextField();
        hasNum_btn = new javax.swing.JRadioButton();
        hasUpper_btn = new javax.swing.JRadioButton();
        hasSpec_btn = new javax.swing.JRadioButton();
        gen_new_pass_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador de contraseñas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bckgrnd.setBackground(new java.awt.Color(51, 0, 51));

        another_bckground.setBackground(new java.awt.Color(255, 255, 204));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Bienvenido al analizador de contraseñas");

        enter_pass.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        enter_pass.setForeground(new java.awt.Color(204, 204, 204));
        enter_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enter_pass.setText("Ingrese su contraseña");
        enter_pass.setActionCommand("<Not Set>");
        enter_pass.setBorder(null);
        enter_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enter_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                enter_passMousePressed(evt);
            }
        });
        enter_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_passActionPerformed(evt);
            }
        });

        vertical_spt.setForeground(new java.awt.Color(0, 0, 0));
        vertical_spt.setOrientation(javax.swing.SwingConstants.VERTICAL);

        continue_btn.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        continue_btn.setText("Continuar");
        continue_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continue_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continue_btnActionPerformed(evt);
            }
        });

        results_lbl.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        results_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        results_lbl.setText("Resultados");

        text_area_results.setEditable(false);
        text_area_results.setColumns(20);
        text_area_results.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        text_area_results.setRows(5);
        show_results.setViewportView(text_area_results);

        suggest_lbl.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        suggest_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suggest_lbl.setText("Dar sugerencia");

        gen_new_lbl.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        gen_new_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gen_new_lbl.setText("Generar contraseña");

        main_spt.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout main_sptLayout = new javax.swing.GroupLayout(main_spt);
        main_spt.setLayout(main_sptLayout);
        main_sptLayout.setHorizontalGroup(
            main_sptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        main_sptLayout.setVerticalGroup(
            main_sptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        hasLower_btn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        hasLower_btn.setText("Poseerá minúsculas");
        hasLower_btn.setActionCommand("Poseerá minúsculas");

        newLength_lbl.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        newLength_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newLength_lbl.setText("Nuevo tamaño:");

        newLenght_field.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        newLenght_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        hasNum_btn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        hasNum_btn.setText("Poseerá números");
        hasNum_btn.setToolTipText("");

        hasUpper_btn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        hasUpper_btn.setText("Poseerá mayúsculas");

        hasSpec_btn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        hasSpec_btn.setText("Poseerá caractéres especiales");

        gen_new_pass_btn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        gen_new_pass_btn.setText("Generar");
        gen_new_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gen_new_pass_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout another_bckgroundLayout = new javax.swing.GroupLayout(another_bckground);
        another_bckground.setLayout(another_bckgroundLayout);
        another_bckgroundLayout.setHorizontalGroup(
            another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, another_bckgroundLayout.createSequentialGroup()
                .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, another_bckgroundLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enter_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(another_bckgroundLayout.createSequentialGroup()
                        .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(another_bckgroundLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(suggest_lbl)
                                .addGap(112, 112, 112)
                                .addComponent(vertical_spt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(another_bckgroundLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(another_bckgroundLayout.createSequentialGroup()
                                                .addComponent(newLength_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(newLenght_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(another_bckgroundLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(hasNum_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(hasLower_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(hasUpper_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(hasSpec_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(another_bckgroundLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, another_bckgroundLayout.createSequentialGroup()
                                                .addComponent(gen_new_lbl)
                                                .addGap(48, 48, 48))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, another_bckgroundLayout.createSequentialGroup()
                                                .addComponent(gen_new_pass_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55))))))
                            .addGroup(another_bckgroundLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(show_results, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                                    .addComponent(main_spt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, another_bckgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(continue_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(270, 270, 270))
                                    .addGroup(another_bckgroundLayout.createSequentialGroup()
                                        .addGap(272, 272, 272)
                                        .addComponent(results_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 272, Short.MAX_VALUE)))))
                        .addGap(12, 12, 12)))
                .addGap(11, 11, 11))
        );
        another_bckgroundLayout.setVerticalGroup(
            another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(another_bckgroundLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enter_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(continue_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(main_spt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(results_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(show_results, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suggest_lbl)
                    .addGroup(another_bckgroundLayout.createSequentialGroup()
                        .addComponent(gen_new_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(another_bckgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newLength_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newLenght_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasNum_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasLower_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasUpper_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasSpec_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gen_new_pass_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vertical_spt))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout bckgrndLayout = new javax.swing.GroupLayout(bckgrnd);
        bckgrnd.setLayout(bckgrndLayout);
        bckgrndLayout.setHorizontalGroup(
            bckgrndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bckgrndLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(another_bckground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bckgrndLayout.setVerticalGroup(
            bckgrndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bckgrndLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(another_bckground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(bckgrnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enter_passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enter_passMousePressed
        enter_pass.setText("");
        enter_pass.setForeground(Color.black);
    }//GEN-LAST:event_enter_passMousePressed

    private void enter_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_passActionPerformed
        String pass = enter_pass.getText();
        if( pass.isBlank() || pass.isEmpty() || pass.equals("Ingrese su contraseña") ){
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese una contraseña válida");
        }else{
            text_area_results.setText("");
            ai.inp = pass;
            ai.text_area_results = text_area_results;
            ai.pedir_password();
        }
    }//GEN-LAST:event_enter_passActionPerformed

    private void continue_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continue_btnActionPerformed
        String pass = enter_pass.getText();
        if( pass.isBlank() || pass.isEmpty() || pass.equals("Ingrese su contraseña") ){
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese una contraseña válida");
        }else{
            text_area_results.setText("");
            ai.inp = pass;
            ai.text_area_results = text_area_results;
            ai.pedir_password();
        }
    }//GEN-LAST:event_continue_btnActionPerformed

    private void gen_new_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gen_new_pass_btnActionPerformed
        if(ai.inp != null){
            if(newLenght_field.getText().isBlank() || newLenght_field.getText().isEmpty() ){
                javax.swing.JOptionPane.showMessageDialog(null, "Ingrese tamaño válido");
            }else{
                try {
                    int newlength = Integer.parseInt(newLenght_field.getText());
                    if(newlength <= ai.inp.length()){
                        javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un tamaño mayor al del original.");
                    }else{
                        if(hasNum_btn.isSelected() == false && hasLower_btn.isSelected() == false && hasUpper_btn.isSelected() == false && hasSpec_btn.isSelected() == false){
                            javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un tipo de caracter");
                        }else{
                            ai.Generate_new_pass(hasNum_btn.isSelected(), hasLower_btn.isSelected(), hasUpper_btn.isSelected(), hasSpec_btn.isSelected(), newlength);
                        }
                    }     
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error: No ingresaste un número entero válido.");
                }
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Primero ingrese una contraseña inicial");
        } 
    }//GEN-LAST:event_gen_new_pass_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel another_bckground;
    private javax.swing.JPanel bckgrnd;
    private javax.swing.JButton continue_btn;
    private javax.swing.JTextField enter_pass;
    private javax.swing.JLabel gen_new_lbl;
    private javax.swing.JButton gen_new_pass_btn;
    private javax.swing.JRadioButton hasLower_btn;
    private javax.swing.JRadioButton hasNum_btn;
    private javax.swing.JRadioButton hasSpec_btn;
    private javax.swing.JRadioButton hasUpper_btn;
    private javax.swing.JPanel main_spt;
    private javax.swing.JTextField newLenght_field;
    private javax.swing.JLabel newLength_lbl;
    private javax.swing.JLabel results_lbl;
    private javax.swing.JScrollPane show_results;
    private javax.swing.JLabel suggest_lbl;
    private javax.swing.JTextArea text_area_results;
    private javax.swing.JLabel title;
    private javax.swing.JSeparator vertical_spt;
    // End of variables declaration//GEN-END:variables
}
