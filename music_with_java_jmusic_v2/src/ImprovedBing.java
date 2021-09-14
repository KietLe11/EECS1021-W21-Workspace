import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

//Song - Wormies on https://www.music-for-music-teachers.com/beginner-piano-music.html

public class ImprovedBing {
    public static void main(String[] args) {

        Play.midi(new Note(JMC.G3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.A3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.B3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.C3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.D3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.C3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.D3,JMC.EIGHTH_NOTE));

        Play.midi(new Note(JMC.F3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.G3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.A3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.G3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.F3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.E3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.D3,JMC.EIGHTH_NOTE));

        Play.midi(new Note(JMC.F3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.E3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.D3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.C3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.B3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.C3,JMC.EIGHTH_NOTE));
        Play.midi(new Note(JMC.C3,JMC.QUARTER_NOTE));


    }
}
