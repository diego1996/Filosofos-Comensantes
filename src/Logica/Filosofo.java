/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Random;

/**
 *
 * @author root
 */
public class Filosofo extends Thread {
        private Random rnd;
        private int tiempo_comiendo, tiempo_pensando;
        private Mesa mesa;
        private int n;
        
        
        public Filosofo(Random r, int tc, int tp, Mesa m, int n) {
                  rnd =r;
                  tiempo_comiendo = tc;
                  tiempo_pensando = tp;
                  mesa = m;
                  this.n = n;
        }
        
        private void esperar(int t) throws InterruptedException {
                    int ti = rnd.nextInt(t);
                    sleep(ti);
        }
        
        private void filosofo_piensa(int i, int tiempo) throws InterruptedException {
                    mesa.jtfFilosofos[i].setText("Pensando");
                    esperar(tiempo);
        }
        
        private void filosofo_come(int i, int tiempo) throws InterruptedException {
                    mesa.jtfFilosofos[i].setText("Comiendo");
                    esperar(tiempo);
                    mesa.jtfFilosofos[i].setText("Terminado");
        }
        
        private void rutina_de_comida() throws InterruptedException {
                    filosofo_piensa(n, tiempo_pensando);
                    mesa.puedeComer(n);
                    try {
                        filosofo_come(n, tiempo_comiendo);
                    }catch(InterruptedException e) {
                            mesa.terminaComida(n);
                            throw e;
                    }
                    mesa.terminaComida(n);
        }
        
        public void run() {
                boolean detener = false;
                while(!detener) {
                        try {
                                rutina_de_comida();
                        }catch(InterruptedException e) {
                                detener = true;
                        }
                }
        }
        
}
