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
public class Atender extends Thread {
            private JTextField pers, pblock;
            private int x;
            public Atender() {
                
            }
    
            public Atender(JTextField pers, JTextField pblock, int x) {
                this.x=x;
                this.pers=pers;
                this.pblock=pblock;
            }
            
            public void esperar(int s) {
                try {
                     Atender.sleep(s*1000);
                }catch(Exception e) {}
            }
            
            
    @Override
            public void run() {
                           if(x==1) {
                                   esperar(20);
                                   System.out.println("termina de comer y desbloquea el comensante");
                                   pers.setText("Terminado");  
                                   pblock.setText("Pensando");
                           }else if(x==2) {
                                   esperar(20);
                                   System.out.println("termina de comer y desbloquea el comensante");
                                   pers.setText("Terminado");  
                                   pblock.setText("Terminado");
                           }
            }
            

    
}
