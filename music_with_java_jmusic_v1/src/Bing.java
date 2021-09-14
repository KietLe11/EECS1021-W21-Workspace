import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

//

public final class Bing implements JMC{
    public static void main (String [] args){
        Play.midi(new Note (G3,QN)); //Not g in octave 3, third of a note
    }
}
