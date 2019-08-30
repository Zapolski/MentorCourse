package by.zapolski.week05;

public class Main {
    public static void main(String[] args) {
        Dump dump = new Dump();
        Factory factory = new Factory(dump);

        MadProfessor madProfessor1 = new MadProfessor("Prof_1");
        MadProfessor madProfessor2 = new MadProfessor("Prof_2");

        Helper helper1 = new Helper(dump,madProfessor1);
        Helper helper2 = new Helper(dump,madProfessor2);

        factory.start();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        helper1.start();
        helper2.start();
    }
}
