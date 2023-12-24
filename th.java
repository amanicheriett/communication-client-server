
package m1tp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class th extends Thread{
    BufferedReader in;
    Vector< OutputStreamWriter> l;

    public void run() {

        while (true) {
            try {
                String s = in.readLine();
                for (int i = 0; i < l.size(); i++) {
                    OutputStreamWriter o = l.get(i);
                    o.write(s + "\n");
                    o.flush();
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(th.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

