package Solid;

public class ExemploISP {
    
    //interface menores e especificas
    static interface Impressora{
        void imprimir();
    }

    static interface Scanner{
        void escanear();
    }

    static interface Fax{
        void enviarFax();
    }

    // Classes que implementam apenas o necessário
    static class ImpressoraSimples implements Impressora{
        public void imprimir(){
            System.out.println("Impressora simples: imprimindo documento...");
        }
    }

    static class Multifuncional implements Impressora, Scanner, Fax{
        public void imprimir(){
            System.out.println("Multifuncional: imprimindo documento...");
        }
        
        public void escanear(){
            System.out.println("Multifuncional: escaneando documento...");
        }

        public void enviarFax(){
            System.out.println("Multifuncional: enviando fax...");
        }
    }

    public static void main(String[] args) {
        ImpressoraSimples simples = new ImpressoraSimples();
        simples.imprimir();

        Multifuncional multi = new Multifuncional();
        multi.imprimir();
        multi.escanear();
        multi.enviarFax();
    }
}
