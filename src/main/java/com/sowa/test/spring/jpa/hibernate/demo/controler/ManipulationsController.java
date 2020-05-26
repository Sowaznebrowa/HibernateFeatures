package com.sowa.test.spring.jpa.hibernate.demo.controler;

import com.sowa.test.spring.jpa.hibernate.demo.operations.DataManipulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManipulationsController {
    private DataManipulator dataManipulator;

    @Autowired
    public ManipulationsController(DataManipulator dataManipulator) {
        this.dataManipulator = dataManipulator;
    }

    @GetMapping("/manipulate")
    public void manipulatePlanesDescriptions(){
        dataManipulator.makeSomeDBChanges();
    }
}
