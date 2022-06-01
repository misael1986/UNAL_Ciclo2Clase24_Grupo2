/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unal.unal_ciclo2clase24_grupo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class NuevoTenedor extends JFrame implements ActionListener {

    JLabel L_nombre;
    JLabel L_direccion;
    JLabel L_telefono;

    JTextField T_nombre;
    JTextField T_telefono;
    JTextField T_direccion;

    JButton guardar;
    JButton limpiar;

    NuevoTenedor() {
        this.setSize(400, 400);
        this.setLayout(null);

        L_nombre = new JLabel("Nombre:");
        L_direccion = new JLabel("Dirección:");
        L_telefono = new JLabel("Telefono:");

        T_nombre = new JTextField();
        T_direccion = new JTextField();
        T_telefono = new JTextField();

        guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);

        L_nombre.setBounds(40, 40, 80, 20);
        this.add(L_nombre);
        T_nombre.setBounds(120, 40, 100, 20);
        this.add(T_nombre);

        L_direccion.setBounds(40, 70, 80, 20);
        this.add(L_direccion);
        T_direccion.setBounds(120, 70, 100, 20);
        this.add(T_direccion);

        L_telefono.setBounds(40, 100, 80, 20);
        this.add(L_telefono);
        T_telefono.setBounds(120, 100, 100, 20);
        this.add(T_telefono);

        guardar.setBounds(230, 40, 90, 25);
        this.add(guardar);
        limpiar.setBounds(230, 80, 90, 25);
        this.add(limpiar);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.guardar) {
            if (!this.T_nombre.getText().equals("")
                    && !this.T_direccion.getText().equals("")
                    && !this.T_telefono.getText().equals("")) {
                GuardarTenedor G = new GuardarTenedor();
                G.conectar();
                Integer res = G.guardarTenedor(this.T_nombre.getText(),
                        this.T_direccion.getText(),
                        this.T_telefono.getText());

                if (res == 1) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Exito al guardar");
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Problema al guardar");
                }
            } else {
                JOptionPane.showConfirmDialog(rootPane,
                        "Datos Vacios, complete por favor");
            }
        } else if (e.getSource() == this.limpiar) {
            this.T_direccion.setText("");
            this.T_nombre.setText("");
            this.T_telefono.setText("");
        }
    }

}
