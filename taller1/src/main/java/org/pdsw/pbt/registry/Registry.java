package org.pdsw.pbt.registry;

import java.util.Optional;

public class Registry {
    public RegisterResult registerVoter(Person p) {
         RegisterResult estado;
        if(p.getAge()<18 || p.getAge()>100 && p.isAlive()){
                
          
        }
        estado = RegisterResult.VALID;
        return estado;
    }

    public Optional<String> generateCertificate(Person person) {

        return Optional.empty();
    }
}
