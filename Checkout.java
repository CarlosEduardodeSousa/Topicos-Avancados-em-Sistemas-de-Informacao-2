interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    public void pay(double amount){
        System.out.println("Pagando R$" + amount + " com cartão de crédito.");
    }
}

class DebitCardPayment implements PaymentStrategy{
    public void pay(double amount){
        System.out.println("Pagando R$" + amount + " com cartão de debito.");
    }
}

class PixPayment implements PaymentStrategy{
    public void pay(double amount){
        System.out.println("Pagando R$" + amount + " via Pix");
    }
}

class Checkout{
    private PaymentStrategy strategy;

    public Checkout(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void processPayment(double amount){
        strategy.pay(amount);
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout(new PixPayment());
        checkout.processPayment(150.0);
        Checkout checkout2 = new Checkout(new DebitCardPayment());
        checkout2.processPayment(400.0);
    }
}
