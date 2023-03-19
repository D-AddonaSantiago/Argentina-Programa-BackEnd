package com.portfolio.sd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud")
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 65000, message = "no cumple con la longitud")
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 2000, message = "no cumplee con la longitud")
    private String img;
    
    @NotNull
    @Size(max = 2000, message = "no cumplee con la longitud")
    private String img2;
    
    @NotNull
    @Size(max = 2000, message = "no cumplee con la longitud")
    private String img3;
}
