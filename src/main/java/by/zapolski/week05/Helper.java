package by.zapolski.week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper extends Thread{

    private Dump dump;
    private MadProfessor madProfessor;
    private List<Parts> pocket = new ArrayList<>();

    public Helper(Dump dump, MadProfessor madProfessor) {
        this.dump = dump;
        this.madProfessor = madProfessor;
    }

    @Override
    public void run() {

        super.run();
    }

    private void stealFromDump(){
        int count = new Random().nextInt(4) + 1;
        for (int i = 0; i < count; i++) {
            Parts part = dump.getAndRemoveRandomPart();
            if (part != null){
                pocket.add(part);
            }
        }

    }

    private void transferPartsToProfessor(){
        for (int i = 0; i < pocket.size(); i++) {
            madProfessor.addParts(pocket.remove(i));
        }
    }


}
