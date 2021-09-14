

import ca.yorku.CountdownHandler;
import com.fazecast.jSerialComm.*;

import java . io . IOException ;
import java . util . Timer ;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;

public class Main {

    public static final byte TIMER_DURATION = 10;

    public static void main ( String [] args ) {

        var sp = SerialPort.getCommPort("COM8");

        sp.setComPortParameters(9600, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        var hasOpened = sp . openPort () ;

        if (! hasOpened ) {
             throw new IllegalStateException (" Failed to open port .");
        }

        var outputStream = sp . getOutputStream () ;

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try{
                outputStream.close();
            }
            catch(IOException e){
                System.out.println("Problem shutting down the program");
                e.printStackTrace();
            }
            //closes the serial port connection to the arduino
            sp.closePort();
        }));

        var timer = new Timer();

        //new Timer().schedule(null,0,1000); //create timer class

        var countdown = new CountdownHandler(TIMER_DURATION,timer,outputStream);

        timer.schedule(countdown,0,1000);


    }

}
