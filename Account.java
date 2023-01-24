public class    Account {
    // limitar o numero de caracteres do nome
    private static final int MAX_LENGTH = 12; // final deixa a variavel constante, o que significa que ela não pode ser alterada
    private String ag;
    private String cc;
    private String name;
    private double balance;
    private Log logger;
    public Account(String ag, String cc, String name){
        this.ag = ag;
        this.cc = cc;
        setName(name); // quando crio o usuario é chamada a função para validar o tamanho do nome
        logger = new Log();
    }

    public void setName(String name) { // função void pois não tem retorno
        if(name.length()>MAX_LENGTH){ // se o nome ficar maior do que o permitido, esse codigo corta uma parte do nome
            this.name = name.substring(0,MAX_LENGTH); // substring retorna só uma parte da string
        }else {
            this.name = name;
        }
    }

    public void deposit(double value){
        balance += value;
        logger.out("Saldo da conta: " + balance);
    }
    public boolean whitDraw(double value){
        if(value > balance){
            logger.out("Saldo atual de: " + balance);
            return false;
        }else{
            balance -= value;
            logger.out("Saldo da conta após o saque: " + balance);
            return true;
        }
    }
    public double getBalance(){
        return balance;
    }
    @Override
    public String toString() {
        String result = "A conta " + this.name + " " + this.ag + " / " +
                this.cc + " possui: R$ " + balance;
        return result;
    }
}
