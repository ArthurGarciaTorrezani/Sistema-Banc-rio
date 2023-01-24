import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank santander = new Bank("0001");

        while (true){
            System.out.println("O que deseja fazer? Criar conta(C), Sair(E)");
            String op = scanner.nextLine();

            if(op.equals("C")){
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            }else {
                System.out.println("Comando inválido!");
            }
        }
        List<Account> accountList = santander.getAccounts(); // Account é o tipo, accountlist o nome e santander é de onde vme os valores

        for(Account cc : accountList){ // foreach
            System.out.println(cc);
        }
        santander.outputTotal();
    }
    static void operateAccount(Account account){

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("O que deseja fazer? Depósito(D), Saque(S), Sair(E) ");
            String op = scanner.nextLine();

            if(op.equals("D")){
                System.out.println("Valor a ser depositado: ");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Valor a ser sacado: ");
                double value = scanner.nextDouble();
                if(!account.whitDraw(value)){
                    System.out.println("Saldo insuficiente! ");
                }
            } else if (op.equals("E")) { // equals lê o conteudo da variavel e o hashcode de objetos
                break;
            }else {
                System.out.println("Comando inválido, tente novamente!");
            }
            scanner = new Scanner(System.in);
        }
    }
}