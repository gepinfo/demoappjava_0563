package com.geppetto.demoappjava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentmarksDto {

    private String _id;
    
    private Number tamil;
    
    private Number english;
    
    private Number maths;
    
    }
