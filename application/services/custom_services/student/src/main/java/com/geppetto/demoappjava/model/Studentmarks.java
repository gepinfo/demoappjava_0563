package com.geppetto.demoappjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

import jakarta.persistence.*;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studentmarks {

    @Id
    private String _id;
    
    private Number tamil;
    
    private Number english;
    
    private Number maths;
    
    
    }

