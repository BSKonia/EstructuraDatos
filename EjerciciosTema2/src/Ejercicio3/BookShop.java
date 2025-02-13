package Ejercicio3;

public class BookShop {

    private Book [] books;
    private int numberOfBooks;

    public BookShop(int capacity) {
        books = new Book[capacity];
        numberOfBooks = 0;
    }



    public void addBook(){
        for (Book book: books){
            if (numberOfBooks < books.length){
                books[numberOfBooks] = book;
            } else {
            System.out.println("The library is full.");
        }


        }
    }

    public void displayBooks() {
        if (numberOfBooks == 0) {
            System.out.println("There are no books in the library.");
        } else {
            for (int i = 0; i < numberOfBooks; i++) {
                System.out.println(books[i]);
            }
        }
    }
}
