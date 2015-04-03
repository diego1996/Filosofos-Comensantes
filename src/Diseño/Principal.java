/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseño;

import Logica.Atender;
import Logica.Repartir;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author root
 */
public class Principal extends JFrame implements ActionListener {
            public Dimension dim;
    
            private static Repartir r;
    
            private JLabel algo;
            private JLabel[] labels;
            private JTextField[] jtfs;
            private JButton Iniciar;
            
            private int cantidad_personas;
    
            public static void main(String[]args) {
                    new Principal();
            }
            
            public Principal() {
                    getContentPane().setLayout(null);
                    iniciarComponentes();
                    getContentPane().repaint();
                    getContentPane().setBounds(0,0,800,600);
                
                    setTitle("Personas Comiendo con Recursos Limitados");
                    //setUndecorated(true);
                    setSize(dim.width-600, dim.height-200);
                    setVisible(true);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            
            private void iniciarComponentes() {
                        dim = super.getToolkit().getScreenSize();
                        algo = new JLabel();
                        //cantidad_personas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas desea agregar"));
                        cantidad_personas = 5;
                        labels = new JLabel[cantidad_personas];
                        for(int i=0;i<labels.length;i++) {
                              labels[i] = new JLabel("Persona " +(i+1));
                        }
                        Iniciar = new JButton("INICIAR");
                        Iniciar.setBounds(630, 470, 100, 30);
                        Iniciar.addActionListener(this);
                        jtfs = new JTextField[cantidad_personas];
                        for(int i=0;i<jtfs.length;i++) {
                              jtfs[i] = new JTextField(5);
                              jtfs[i].setText("Pensando");
                              jtfs[i].setBackground(Color.DARK_GRAY);
                              jtfs[i].setForeground(Color.white);
                        }
                        
                        labels[0].setBounds(600, 200, 70, 70);
                        jtfs[0].setBounds(680, 220, 80, 30);
                        labels[1].setBounds(600, 250, 70, 70);
                        jtfs[1].setBounds(680, 270, 80, 30);
                        labels[2].setBounds(600, 300, 70, 70);
                        jtfs[2].setBounds(680, 320, 80, 30);
                        labels[3].setBounds(600, 350, 70, 70);
                        jtfs[3].setBounds(680, 370, 80, 30);
                        labels[4].setBounds(600, 400, 70, 70);
                        jtfs[4].setBounds(680, 420, 80, 30);
                        
                        r = new Repartir(jtfs);
                         
                        add(labels[0]);
                        add(jtfs[0]);
                        add(labels[1]);
                        add(jtfs[1]);
                        add(labels[2]);
                        add(jtfs[2]);
                        add(labels[3]);
                        add(jtfs[3]);
                        add(labels[4]);
                        add(jtfs[4]);
                        add(Iniciar);
            }
            
            
            public void paint (Graphics g) {
                    super.paint(g);
                    
                    g.setColor(Color.getHSBColor(40, 190, 250));
                    g.fillOval(150, 130, 300, 300);
                    
                    g.setColor(Color.white);
                    g.fillOval(270, 150, 60, 60);
                    g.fillOval(360, 220, 60, 60);
                    g.fillOval(330, 330, 60, 60);
                    g.fillOval(180, 225, 60, 60);
                    g.fillOval(210, 330, 60, 60);
                    
                    g.setColor(Color.getHSBColor(240, 0, 250));
                    g.fill3DRect(240, 170, 10, 60, rootPaneCheckingEnabled);
                    g.fill3DRect(350, 170, 10, 60, rootPaneCheckingEnabled);
                    g.fill3DRect(370, 300, 60, 10, rootPaneCheckingEnabled);
                    g.fill3DRect(170, 305, 60, 10, rootPaneCheckingEnabled);
                    g.fill3DRect(295, 350, 10, 60, rootPaneCheckingEnabled);
                    
                    g.setColor(Color.BLACK);
                    g.drawString("P1", 295, 185);
                    g.drawString("P2", 385, 255);
                    g.drawString("P3", 355, 365);
                    g.drawString("P4", 230, 365);
                    g.drawString("P5", 200, 260);
            }
            
    @Override
            public void actionPerformed(ActionEvent e) {
                     if(Iniciar == e.getSource()) {
                            r.iniciar();
                     }
            }
        
}
