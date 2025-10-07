public class ConfigManager {
    private static ConfigManager instance;
    private static int nroChamadas = 0;

    private ConfigManager (){
        /*Construtor Privado */
    }

    public static ConfigManager getInstance(){
        if (instance == null){
            instance = new ConfigManager();
        }
        nroChamadas++;
        return instance;
    }

    public void printConfig(){
        System.out.println("Configurações carregadas: " + nroChamadas);
    }

    public static void main(String[] args) {
        ConfigManager config = ConfigManager.getInstance();
        config.printConfig();
        ConfigManager config2 = ConfigManager.getInstance();
        config2.printConfig();
    }
}
