package com.example.mylibrary;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util(){
        if(allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if(currentlyReadingBooks == null)
            currentlyReadingBooks = new ArrayList<>();

        if(wantToReadBooks == null)
            wantToReadBooks = new ArrayList<>();

        if(alreadyReadBooks == null)
            alreadyReadBooks = new ArrayList<>();
    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook(Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean currentlyReadingBook(Book book){
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBook(Book book){
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBook(Book book){
        return alreadyReadBooks.remove(book);
    }


    private static void initAllBooks(){
        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";

        ++id;
        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl = "https://www.listchallenges.com/f/items/d704516a-f576-45cc-b0a1-e713511b1e3c.jpg";
        description = "Pride and Prejudice, romantic novel by Jane Austen, published anonymously in three volumes in 1813. A classic of English literature, written with incisive wit and superb character delineation, it centres on the turbulent relationship between Elizabeth Bennet, the daughter of a country gentleman, and Fitzwilliam Darcy, a rich aristocratic landowner.";
        allBooks.add(new Book(name, author, pages, imageUrl, description, id));


        ++id;
        name = "To Kill a Mockingbird";
        author = "Harper Lee";
        pages = 281;
        imageUrl = "https://www.listchallenges.com/f/items/81afb861-684c-45fc-a180-130f9245b631.jpg";
        description = "To Kill a Mockingbird is a novel by Harper Lee published in 1960. Instantly successful, widely read in high schools and middle schools in the United States, it has become a classic of modern American literature, winning the Pulitzer Prize. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old";
        allBooks.add(new Book(name, author, pages, imageUrl, description, id));

        ++id;
        name = "The Great Gatsby";
        author = "F. Scott Fitzgerald";
        pages = 218;
        imageUrl = "https://www.listchallenges.com/f/items/ddfd9616-e1c9-496f-8a70-d3530f6f9a2c.jpg";
        description = "The Great Gatsby is a 1925 novel written by American author F. Scott Fitzgerald that follows a cast of characters living in the fictional towns of West Egg and East Egg on prosperous Long Island in the summer of 1922. The story primarily concerns the young and mysterious millionaire Jay Gatsby and his quixotic passion and obsession with the beautiful former debutante Daisy Buchanan. Considered to be Fitzgerald's magnum opus, The Great Gatsby explores themes of decadence, idealism, resistance to change, social upheaval and excess, creating a portrait of the Roaring Twenties that has been described as a cautionary[a] tale regarding the American Dream.";
        allBooks.add(new Book(name, author, pages, imageUrl, description, id));

        ++id;
        name = "Wuthering Heights";
        author = "Emily Bronte";
        pages = 400;
        imageUrl = "https://www.listchallenges.com/f/items/ddfd9616-e1c9-496f-8a70-d3530f6f9a2c.jpg";
        description = "Wuthering Heights, Emily Brontë's only novel, was published in 1847 under the pseudonym \"Ellis Bell\". It was written between October 1845 and June 1846.[1] Wuthering Heights and Anne Brontë's Agnes Grey were accepted by publisher Thomas Newby before the success of their sister Charlotte's novel Jane Eyre. After Emily's death, Charlotte edited the manuscript of Wuthering Heights and arranged for the edited version to be published as a posthumous second edition in 1850.";
        allBooks.add(new Book(name, author, pages, imageUrl, description, id));

    }

}
