package Solid;

public class ExemploSRP {
     //GeradorRelatorio.java
    static class GeradorRelatorio{
        public String gerar(){
            return "Relatório gerado com sucesso!";
        }
    }

    //RepositorioRelatorio.java
    static class RepositorioRelatorio{
        public void salvar(String relatorio){
            System.out.println("Salvando no banco: " + relatorio);
        }
    }

    public static void main(String[] args) {
        GeradorRelatorio gerador = new GeradorRelatorio();
        String relatorio = gerador.gerar();

        RepositorioRelatorio repositorio = new RepositorioRelatorio();
        repositorio.salvar(relatorio);
    }
}
