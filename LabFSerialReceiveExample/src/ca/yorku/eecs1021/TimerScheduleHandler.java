package ca.yorku.eecs1021;

import java.sql.Time;
import java.util.TimerTask;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class TimerScheduleHandler extends TimerTask implements SerialPortDataListener {

    private final long timeStart;

    //constructor
    public TimerScheduleHandler(long timeStart) {
        this.timeStart = timeStart;
    }

    //overide run method in timer task
    @Override
    public void run(){
        System.out.println("Time Elapsed: "+(System.currentTimeMillis()-this.timeStart)+" milliseconds");
    }

    @Override
    public int getListeningEvents(){
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent){
        if(serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED){
            System.out.println("Moisture Sensor is wet!");
        }
    }
}
