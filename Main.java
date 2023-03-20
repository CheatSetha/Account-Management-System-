package hwArraylist;

import java.util.*;

class Account {
    int id;
    String ownerName;
    double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}


public class Main {

    public static void main(String[] args) {


        int option;


        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("--------------| Account management |----------");
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account info");
            System.out.println("5. Exit ");
            System.out.println("Choose option ( 1 - 5 ) : ");
            System.out.println("--------------| Thank you |----------");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter your account info");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Balance:");
                    acc.balance = input.nextDouble();

                    accountList.add(acc);


                    break;
                case 2:

                    System.out.println("----------------| Remove element by id |------------");
                    System.out.print("    Enter the id : ");
                    int rmId = input.nextInt();
                    accountList.removeIf(account -> account.id == rmId);
                    System.out.println("You have removed an element!");
                    break;
                case 3:
                    System.out.println("----------------| Update element by id |------------");
                    System.out.println("Enter the id : ");
                    int editId = input.nextInt();

                    for (int i = 0; i < accountList.size(); i++) {


                        if (accountList.get(i).id == editId) {

                            Account account = new Account();
                            account.id = accountList.get(i).id;

                            System.out.println("enter name :");
                            input.nextLine();
                            account.ownerName = input.nextLine();

                            System.out.println("Enter balance : ");
                            account.balance = input.nextDouble();

                            accountList.set(i, account);

                        }
                    }

                    break;
                case 4:
                    int showOption;
                    System.out.println("Show account information");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descendig order by balance ");

                    System.out.println("Choose show option : ");
                    showOption = input.nextInt();

                    switch (showOption) {
                        case 1: {
                            System.out.println("----------sort order asc--------");
                            Collections.sort(accountList, new Comparator<Account>() {
                                @Override
                                public int compare(Account account1, Account account2) {
                                    return Integer.valueOf(account1.id).compareTo(account2.id);
                                }
                            });
                            // System.out.println(accountList);
                            for (int i = 0; i < accountList.size(); i++) {
                                System.out.println("Id : " + accountList.get(i).id + " Name : " + accountList.get(i).ownerName + " balance : " + accountList.get(i).balance);
                            }
                            break;

                        }
                        case 2: {
                            System.out.println("----------Descending order (by id)----------");
                            Collections.sort(accountList, new Comparator<Account>() {
                                @Override
                                public int compare(Account account1, Account account2) {
                                    return Integer.valueOf(account2.id).compareTo(account1.id);
                                }
                            });
                            for (int i = 0; i < accountList.size(); i++) {
                                System.out.println("Id : " + accountList.get(i).id + " Name : " + accountList.get(i).ownerName + " balance : " + accountList.get(i).balance);
                            }
                            // System.out.println(accountList);
                            break;

                        }
                        case 3: {
                            System.out.println("----------Descending order by balance----------");
                            Collections.sort(accountList, new Comparator<Account>() {
                                @Override
                                public int compare(Account account1, Account account2) {
                                    return Double.valueOf(account2.balance).compareTo(account1.balance);
                                }
                            });
                            for (int i = 0; i < accountList.size(); i++) {
                                System.out.println("Id : " + accountList.get(i).id + " Name : " + accountList.get(i).ownerName + " balance : " + accountList.get(i).balance);

                            }
                            break;

                        }
                        default: {
                            System.out.println("Exiting....");
                            break;
                        }
                    }

                    break;
                case 5:
                    System.out.println("Exit the program....!");
                    break;
            }
        } while (option != 5);

    }
}