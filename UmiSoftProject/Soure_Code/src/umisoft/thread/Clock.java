
package umisoft.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Clock extends Thread{
    private JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }
    
    public void run(){
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss aa");
        while(true){
            Date now=new Date();
            String st = sdf.format(now);
            
            lbl.setText(st);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
