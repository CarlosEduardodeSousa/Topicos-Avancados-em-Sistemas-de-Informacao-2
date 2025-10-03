package Solid;

public class ExemploOCP {
    
    //Interface de desconto
    static interface Desconto{
        double aplicar(double valor);
    }

    //Descontos específicos
    static class DescontoNatal implements Desconto{
        public double aplicar(double valor){
            return valor * 0.9;
        }
    }

    static class DescontoAnoNovo implements Desconto{
        public double aplicar(double valor){
            return valor * 0.85;
        }
    }

    static class DescontoBlackFriday implements Desconto{
        public double aplicar(double valor){
            return valor * 0.5;
        }
    }

    // Calculadora de desconto
    static class CalculadoraDesconto{
        public double calcular(Desconto desconto, double valor){
            return desconto.aplicar(valor);
        }
    }

    public static void main(String[] args) {
        CalculadoraDesconto calc = new CalculadoraDesconto();

        double valor = 100.0;

        System.out.println("Preço no natal: " + calc.calcular(new DescontoNatal(), valor));
        System.out.println("Preço do Ano Novo: " + calc.calcular(new DescontoAnoNovo(), valor));
        System.out.println("Preço na Black Friday: " + calc.calcular(new DescontoBlackFriday(), valor));
    }
}
