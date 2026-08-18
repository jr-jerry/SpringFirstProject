package com.Ducat.SpringFirstProject.Entity;

import lombok.Builder;

@Builder
public class Demo_Builder_Annontation {
    private String field1;
    private String field2;
}
class Class2{
    public void method(){
     Demo_Builder_Annontation d1=Demo_Builder_Annontation
                                                        .builder()
                                                        .field1("value1")
                                                        .field2("value2")
                                                        .build();
    }
}
