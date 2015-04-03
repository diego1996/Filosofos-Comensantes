/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author root
 */
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Repartir {
            private Random rnd;
            private JTextField[] jtfs;
            private int estadoP[];
            private int pensando, comiendo, bloqueado, terminado;
                        
            public Repartir(JTextField[] jtfs) {
                    rnd = new Random();
                    this.jtfs=jtfs;
                    
            }
                        
            public int acomodar(int n) {
                if(n==-1) return 4;
                if(n==5) return 0;
                return n;
            }
            
            public boolean hayHambrientos() {
                boolean c=false;
                    for(int i=0;i<jtfs.length;i++) {
                        if(jtfs[i].getText().equals("Pensando")) {
                             c=true;
                             return c;
                        }
                    }
                    
                 return c;
            }
            //static int aux=0;
            

            public void iniciar() {
                    Atender a;
                    do{
                            int aux = rnd.nextInt(5);
                            if(jtfs[aux].getText().equals("Pensando")) {
                                    if(((jtfs[acomodar(aux-1)].getText().equals("Pensando")))) {
                                            jtfs[aux].setText("Comiendo");  
                                            jtfs[acomodar(aux-1)].setText("Bloqueado");
                                            a = new Atender(jtfs[aux], jtfs[acomodar(aux-1)],1);
                                            a.start();
                                    }else  if(((jtfs[acomodar(aux-1)].getText().equals("Terminado")))) { 
                                            jtfs[aux].setText("Comiendo");  
                                            jtfs[acomodar(aux-1)].setText("Bloqueado");
                                            a = new Atender(jtfs[aux], jtfs[acomodar(aux-1)],2);
                                            a.start();
                                    }
                            }
                          //  JOptionPane.showMessageDialog(null, " ");
                   }while(hayHambrientos());
           }
    
}
