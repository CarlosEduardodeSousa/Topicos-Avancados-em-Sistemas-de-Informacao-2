import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String message);
}

class User implements Observer{
    private String name;

    public User(String name){
        this.name = name;
    }

    public void update (String message){
        System.out.println(name + " recebeu: " + message);
    }
}

class NotificationService{
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o){
        observers.add(o);
    }

    public void notifyAllUsers(String message){
        for (Observer o : observers){
            o.update(message);
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.subscribe(new User("Ana"));
        service.subscribe(new User("Carlos"));

        service.notifyAllUsers("Nova promoção disponível!");
    }
}
