<<<<<<< HEAD
package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Catalog")
public class Catalog {

    @Id
    @SequenceGenerator(name = "catalog_seq", sequenceName = "catalog_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq")
    @Column(name = "catalogId")
    private Long catalogId;
    private @NonNull String catalogname;
    private @NonNull String price;

   
    private Catalog() {
    }

    public Catalog(String catalogname,String price) {
        this.catalogname = catalogname;
        this.price = price;

    }

=======
package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Catalog")
public class Catalog {

    @Id
    @SequenceGenerator(name = "catalog_seq", sequenceName = "catalog_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq")
    @Column(name = "catalogId")
    private Long catalogId;
    private @NonNull String catalogname;
    private @NonNull String price;

    @ManyToOne //เป็น foreign key ที่ชี้ไปที่ primary key ของ table POST_FORUM ซึ่งก็คือ POST_FORUM_ID
    private Partners partners;
    

    private Catalog() {
    }

    public Catalog(String catalogname,String price) {
        this.catalogname = catalogname;
        this.price = price;

    }

>>>>>>> issue-62
}