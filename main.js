class Bookstore {
    constructor() {
        this.books = [];
    }

    addBook(bookId, title, author, price, quantity) {
        this.books.push({ bookId, title, author, price, quantity });
    }

    updateBook(bookId, newDetails) {
        const book = this.books.find(book => book.bookId === bookId);
        if (book) {
            Object.assign(book, newDetails);
        } else {
            console.log('الكتاب غير موجود');
        }
    }

    deleteBook(bookId) {
        const bookIndex = this.books.findIndex(book => book.bookId === bookId);
        if (bookIndex > -1) {
            this.books.splice(bookIndex, 1);
        } else {
            console.log('الكتاب غير موجود');
        }
    }

    searchBooks(searchTerm) {
        return this.books.filter(book =>
            book.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
            book.author.toLowerCase().includes(searchTerm.toLowerCase())
        );
    }

    sellBook(title, quantity, currentBalance) {
        const book = this.books.find(book => book.title.toLowerCase() === title.toLowerCase());
        if (book) {
            if (book.quantity >= quantity) {
                const totalCost = book.price * quantity;
                if (currentBalance >= totalCost) {
                    book.quantity -= quantity;
                    console.log(`تم بيع ${quantity} من '${title}'. الكلفة الكلية: ${totalCost}. الكمية المتبقية: ${book.quantity}`);
                } else {
                    console.log('الرصيد غير كافٍ لإكمال الشراء');
                }
            } else {
                console.log('المخزون غير كافٍ');
            }
        } else {
            console.log('الكتاب غير موجود');
        }
    }
}

// استخدام مثال:
const myBookstore = new Bookstore();

// إضافة كتب
myBookstore.addBook(1, 'Start with Why', 'Simon Sinek', 80, 13);
myBookstore.addBook(2, 'But How Do It Know', 'J. Clark Scott', 59.9, 22);

// تحديث كتاب
myBookstore.updateBook(1, { price: 82, quantity: 15 });

// حذف كتاب
myBookstore.deleteBook(2);

// البحث عن كتاب
const searchResults = myBookstore.searchBooks('Start with Why');
console.log(searchResults);

// بيع كتاب
myBookstore.sellBook('Start with Why', 2, 200);
