package com.mycompany.newsroom.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Category extends AbstractPersistable<Long>{
    private Long id;
    
    //@NotEmpty
    private String name;
    
    //@NotEmpty
    private String description;
    
    @ManyToMany  
    private List<Story> stories;
    
    public void addStory(Story s) {
        this.stories.add(s);
    }
}
