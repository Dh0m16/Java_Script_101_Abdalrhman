import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private List<Book> books;

    public Bookstore() {
        books = new ArrayList<>();
    }

    public void addBook(int bookId, String title, String author, double price, int quantity) {
        books.add(new Book(bookId, title, author, price, quantity));
    }

    public boolean updateBook(int bookId, String title, String author, Double price, Integer quantity) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (title != null)
                    book.setTitle(title);
                if (author != null)
                    book.setAuthor(author);
                if (price != null)
                    book.setPrice(price);
                if (quantity != null)
                    book.setQuantity(quantity);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(int bookId) {
        return books.removeIf(book -> book.getBookId() == bookId);
    }

    public Book getBookInfo(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooks(String searchQuery) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(searchQuery) || book.getAuthor().contains(searchQuery)) {
                results.add(book);
            }
        }
        return results;
    }

    public SaleResult sellBook(String title, int quantity, double customerBalance) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getQuantity() >= quantity) {
                double totalCost = book.getPrice() * quantity;
                if (customerBalance >= totalCost) {
                    book.setQuantity(book.getQuantity() - quantity);
                    return new SaleResult(true, customerBalance - totalCost, totalCost);
                }
            }
        }
        return new SaleResult(false, customerBalance, 0);
    }

    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        bookstore.addBook(1, "Start with why", "Simon Sinek", 80.0, 13);
        bookstore.addBook(2, "But how do it know", "J. Clark Scott", 59.9, 22);
        bookstore.addBook(3, "Clean Code", "Robert Cecil Martin", 50.0, 5);
        bookstore.addBook(4, "Zero to One", "Peter Thiel", 45.0, 12);
        bookstore.addBook(5, "You don't know JS", "Kyle Simpson", 39.9, 9);

        bookstore.updateBook(1, null, null, null, 10);

        SaleResult result = bookstore.sellBook("Start with why", 2, 50);
        System.out.println("Sale status: " + result.isSuccessful());
        System.out.println("Remaining balance: " + result.getCustomerBalance());
        System.out.println("Total price: " + result.getTotalCost());
    }
}

class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(int bookId, String title, String author, double price, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class SaleResult {
    private boolean successful;
    private double customerBalance;
    private double totalCost;

    public SaleResult(boolean successful, double customerBalance, double totalCost) {
        this.successful = successful;
        this.customerBalance = customerBalance;
        this.totalCost = totalCost;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
