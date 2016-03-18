/*
 * Copyright 2016 rhegde.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mvc.bookstore.controller.vo;

/**
 *
 * @author rhegde
 */
public class BookVO {
    
     private Long id;
    
    private String bookName;
    
    private PublisherVO publisher;
    
    private AuthorVO author;
    
    private Float price;
    
    private int stock;

    public BookVO() {
    }

    public BookVO(Long id, String bookName, Float price) {
        this.id = id;
        this.bookName = bookName;
        this.price=price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    
    
    
    public AuthorVO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorVO author) {
        this.author = author;
    }
    
    
    

    public PublisherVO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherVO publisher) {
        this.publisher = publisher;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    
    

    
}
