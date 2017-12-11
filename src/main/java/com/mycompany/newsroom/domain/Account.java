package com.mycompany.newsroom.domain;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractPersistable<Long> {

    //@ElementCollection(fetch = FetchType.EAGER)
    //private List<String> authorities;
    
    //@NotEmpty
    //@Size(min = 4, max = 15)
    private String username;
    
    //@NotEmpty
    //@Size(min = 4, max = 15)
    private String password;
   
    
//    public List<String> getAuthorities() {
//        return authorities;
//    }
// 
//    public void setAuthorities(List<String> authorities) {
//        this.authorities = authorities;
//    }

}
