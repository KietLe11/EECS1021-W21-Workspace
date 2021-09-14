package ca.yorku;


import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortDataListener;

public class CountdownHandler extends TimerTask implements SerialPortDataListener {

    private byte n;
    private final OutputStream outputStream;
    private final Timer timer;

    //constructor
    public CountdownHandler(byte timerDuration, Timer timer, OutputStream outputStream) {
        this.n = timerDuration;
        this.timer = timer;
        this.outputStream = outputStream;

    }

    @Override
    public void run(){

        try{

            if(this.n >0){
                this.outputStream.write(this.n);
                this.n = (byte)(this.n-1);
            }else{
                this.outputStream.write(-1);
                this.timer.cancel();
            }

        }catch(IOException e){
            System.out.println("Problem Inside the countdown run method");
            e.printStackTrace();
        }
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {

        if(serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED){
            System.out.println("Sensor is wet!");
            this.n=9;




        }
    }
}
