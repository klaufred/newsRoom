package com.mycompany.newsroom.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Story extends AbstractPersistable<Long>{

    private Long id;
    
    //@NotEmpty
    private LocalDateTime publicationDate;
    
    //@NotEmpty
    //@Size(min = 5, max = 50)
    private String title;
    
    //@NotEmpty
    //@Size(min = 10, max = 150)
    private String intro;
    
    //@NotEmpty
    @Lob 
    @Column(name="content", length=512)
    private String content;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;
    
    private Integer clicks;
    
   private String writer;
    
    //@NotEmpty
    @ManyToMany(mappedBy="stories", fetch=FetchType.EAGER)  
    private List<Category> categories;
    
    public void addCategory(Category c) {
        this.categories.add(c);
    }
}
