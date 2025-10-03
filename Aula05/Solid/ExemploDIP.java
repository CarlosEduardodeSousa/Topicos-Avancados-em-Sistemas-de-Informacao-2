package Solid;

public class ExemploDIP {
    
    //Abstração do Banco
    static interface Banco{
        void salvar(String dado);
    }

    //Implementações concretas
    static class MySQLBanco implements Banco{
        public void salvar(String dado){
            System.out.println("Salvando no MySQL: " + dado);
        }
    }

    static class PostgresBanco implements Banco{
        public void salvar(String dado){
            System.out.println("Salvando no PostgreSQL: " + dado);
        }
    }

    //Classe de cadastro que depende da abstração Banco
    static class CadastroCliente{
        private Banco banco;

        public CadastroCliente(Banco banco){
            this.banco = banco;
        }

        public void cadastrar(String nome){
            banco.salvar("Cliente: " + nome);
        }
    }

    public static void main(String[] args) {
        CadastroCliente cadastromySQL = new CadastroCliente(new MySQLBanco());
        cadastromySQL.cadastrar("João");

        CadastroCliente cadastroPostgres = new CadastroCliente(new PostgresBanco());
        cadastroPostgres.cadastrar("Maria");
    }
}
