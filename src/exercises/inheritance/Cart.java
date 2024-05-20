package exercises.inheritance;

import java.util.Scanner;

public class Cart {
    //supermercato
    public static void main(String[] args) {

        //prodotto generico
        Product pane = new Product(22, "bread", "casereccio", 2.50);
        //smartphone
        Smartphone iphone = new Smartphone(22, "Iphone 16 Pro", "", 1300, "350123451234560", 8);
        //tv
        Television tv = new Television(22, "Samsung Crystal", "", 450.50, true, 55);
        //cuffie
        Headphones cuffie = new Headphones(22, "Cuffie Logitech", "", 100.5, "black", true);


//        System.out.println(pane.toString());
//        System.out.println(iphone.toString());
//        System.out.println(tv.toString());
//        System.out.println(cuffie.toString());


        Scanner scanner = new Scanner(System.in);
        //chiedo all'utente quanti elementi vuole inserire
        System.out.println("Quanti prodotti vuoi inserire?");
        int quantity = Integer.parseInt(scanner.nextLine());

        //inizializzo un array di tanti elementi quanto quello che mi ha risposto l'utente
        Product[] cart = new Product[quantity];

        for (int i = 0; i < cart.length; i++) {
            System.out.println("Cosa vuoi inserire? Smartphone(s), Televisore(t) o Cuffie(c)?");
            char option = scanner.nextLine().charAt(0);
            System.out.println("Inserisci l'iva");
            int vat = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci il nome del prodotto");
            String name = scanner.nextLine();
            System.out.println("Inserisci la descrizione");
            String description = scanner.nextLine();
            System.out.println("Inserisci il prezzo");
            double price = Double.parseDouble(scanner.nextLine());


            switch (option) {
                case 's':
                    System.out.println("Inserisci il codice imei");
                    String imeiCode = scanner.nextLine();
                    System.out.println("Inserisci la quantità di memoria");
                    int ram = Integer.parseInt(scanner.nextLine());
                    cart[i] = new Smartphone(vat, name, description, price, imeiCode, ram);
                    break;
                case 't':
                    System.out.println("E' una smart tv? (y/n)");
                    char replySmart = scanner.nextLine().charAt(0);
                    boolean isItSmart;
                    isItSmart = replySmart == 'y';
                    System.out.println("Inserisci le dimensioni");
                    int dimensions = Integer.parseInt(scanner.nextLine());
                    cart[i] = new Television(vat, name, description, price, isItSmart, dimensions);
                    break;
                case 'c':
                    System.out.println("Inserisci il colore");
                    String color = scanner.nextLine();
                    System.out.println("Sono cuffie wireless? (y/n)");
                    char replyWireless = scanner.nextLine().charAt(0);
                    boolean isItWireless;
                    isItWireless = replyWireless == 'y';
                    cart[i] = new Headphones(vat, name, description, price, color, isItWireless);
                    break;
                default:
                    cart[i] = new Product(vat, name, description, price);
                    break;
            }

            System.out.println("Hai inserito: " + cart[i].toString());

        }

        System.out.println("Il tuo carrello: ");
        for (Product product : cart) {
            System.out.println(product.toString());
        }



        scanner.close();












    }
}