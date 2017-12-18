package ro.msg.learning.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product_category_table")
public class ProductCategory {

    @Id
    @SequenceGenerator(name = "cat_seq", sequenceName = "seq_category")
    @GeneratedValue(generator = "cat_seq")
    private long id;
    
    @JsonProperty("Category")
    @Column(name = "category", unique = true)
    private String category;

    @JsonProperty("NumberOfProducts")
    private Short numberOfProducts;

    @Column(unique = true)
    @JsonProperty("CategoryName")
    private String categoryName;

    @OneToOne(fetch=FetchType.LAZY)
    private ProductCategory parent;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productsList = new ArrayList<>();
 
    public void addProduct(Product product) {
        productsList.add(product);
        product.setProductCategory(this);
    }
 
    public void removeProduct(Product product) {
        productsList.remove(product);
        product.setProductCategory(null);
    }

}
