/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class Mesa {
        private int nFilosofos;
        public JTextField[] jtfFilosofos;
        
        public Mesa(int n, JTextField[] jtf) {
            nFilosofos = n;
            jtfFilosofos = jtf;
            for(int i=0;i<jtfFilosofos.length;i++) {
                  jtfFilosofos[i].setText("Pensando");
            }
        }
        
        public int a_la_derecha(int n) {
                    return (n-1+nFilosofos)%nFilosofos;
        }
        
        public int a_la_izquierda(int n) {
                    return (n+1)%nFilosofos;
        }
        
        public synchronized void puedeComer(int n) throws InterruptedException {
                    while( (jtfFilosofos[a_la_derecha(n)].getText().equals("Comiendo"))||(jtfFilosofos[a_la_izquierda(n)].getText().equals("Comiendo")) ) {
                        wait();
                    }
                    jtfFilosofos[n].setText("Comiendo");
        }
        
        public synchronized void  terminaComida(int n) {
                   jtfFilosofos[n].setText("Terminado");
                   notifyAll();
        }
        
}
