package com.uch.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/names")
    public List<Name> getName(){
        Name[] names = new Name[3];

        names[0] = new Name ( "Facundo Calderon", 19);
        names[1] = new Name ( "Ramiro Gogol", 19);
        names[2] = new Name ( "Tomas Serrani", 19);

        List<Name> nameList = Arrays.asList(names);

        return nameList;
    }
}
