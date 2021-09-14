
import ca.yorku.eecs1021.TimerScheduleHandler;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Timer;

public class Main {

    public static void main (String [] args){
        long timeStart = System.currentTimeMillis();

        var sp = SerialPort.getCommPort("COM8");

        sp.setComPortParameters(9600,Byte.SIZE,SerialPort.ONE_STOP_BIT,SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING,0,0);

        var hasOpened = sp.openPort();
        if(!hasOpened){
            throw new IllegalStateException("Failed to open serial port");
        }

        Runtime.getRuntime().addShutdownHook(new Thread(()-> {sp.closePort();}));

        var timer = new Timer();
        var timedSchedule = new TimerScheduleHandler(timeStart);

        sp.addDataListener(timedSchedule);

        System.out.println("Listen:" + timedSchedule.getListeningEvents());
        timer.schedule(timedSchedule,0,1000);
    }


}
