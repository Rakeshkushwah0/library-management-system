package com.rakesh.myappvs.services;


// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakesh.myappvs.dao.BookRepository;
import com.rakesh.myappvs.entities.Book;

@Component
public class BookServices {

   @Autowired
   private BookRepository bookRepository;


   public List<Book> getAllBooks() {
      List<Book> list=(List<Book>)this.bookRepository.findAll();
      return list;
  }

      // get single book by id
      public Book getBookById(int id) {
         Book book = null;
         try {
             book=this.bookRepository.findById(id);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return book;
     }
 
     // adding the book
     public Book addBook(Book b) {
         Book result=bookRepository.save(b);
         return result;
     }
 
     // delete book
     public void deleteBook(int bid) {
         
         bookRepository.deleteById(bid);
     }
 
     // update the book
     public void updateBook(Book book, int bookId) {
        
         book.setId(bookId);
         bookRepository.save(book);
     }
 

//  private static List<Book> list = new ArrayList<>();

//  static {
    
//     list.add(new Book(123,"Java Complete reference","abc"));
//     list.add(new Book(345,"Head first to java","abc"));
//     list.add(new Book(675,"Things in java","abc"));


//  }

//  public List<Book> getAllBooks(){
//     return list;
//  }

//  public Book getBookById(int id){
//    Book book = null;
//    try {
//        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//       //  book=this.bookRepository.findById(id);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return book;
//  }

//   public Book addBook(Book b){
//    list.add(b);
//    return b;
//   }
  
//   public void deleteBook(int bid){
//    list =list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
//   }

//   public void updateBook(Book book, int bookId){
//    list = list.stream().map(b ->{
//       if(b.getId()==bookId){
//          b.setTitle(book.getTitle());
//          b.setAuthor(book.getAuthor());
//       }
//       return b;
//    }).collect(Collectors.toList());
//   }
    
}
