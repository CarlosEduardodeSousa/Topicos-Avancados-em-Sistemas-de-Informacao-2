package Solid;

public class ExemploLSP2 {
    //Interface para aves

    static interface Ave {}

    static interface AveQueVoa extends Ave{
        void voar();
    }

    static class Pato implements Ave, AveQueVoa {
        public void voar(){
            System.out.println("Pato voando...");
        }
    }

    static class Pinguim implements Ave{
        public void nadar(){
            System.out.println("Pinguim nadando...");
        }
    }

    public static void main(String[] args) {
        Pato pato = new Pato();
        pato.voar();

        Pinguim pinguim = new Pinguim();
        pinguim.nadar();
    }
}
