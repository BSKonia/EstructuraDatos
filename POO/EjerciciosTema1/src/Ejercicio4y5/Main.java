package Ejercicio4y5;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("Pepito", "Perez", "323434234434343", 0);
        account.deposit(1300);
        account.retire(500);
        System.out.println(account.getBalance());
        account.retire(500);
        System.out.println(account.getBalance());
        account.retire(500);
        System.out.println(account.getBalance());

        /**
        boolean okWithdraw;
        for (int i = 0; i < 3; i++) {

            okWithdraw = account.withdraw(500);
            if (okWithdraw)
                System.out.println("La retirada se ha realizado con éxito");
            else
                System.out.println("La retirada no se ha podido realizar");

                        System.out.println("El saldo de la cuenta es: " +
                                account.getBalance());
         **/

        /**
         * for (int i = 0; i < 3; i++) {
         *
         *    okWithdraw = account.withdraw(500);
         *    if (okWithdraw)
         *     System.out.println("La retirada se ha realizado con éxito");
         *    else
         *     System.out.println("La retirada no se ha podido realizar");
         *
         *    System.out.println("El saldo de la cuenta es: " +
         * account.getBalance());
         *   }
         */

    }
}
