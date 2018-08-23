package org.pdsw.pbt.registry;

import java.util.Optional;

public class Registry {
    public RegisterResult registerVoter(Person p) {
        RegisterResult estado;
        if (18 <= p.getAge() && p.isAlive()) {
			estado = RegisterResult.VALID;		
		} else if(!p.isAlive()) {
			estado = RegisterResult.DECEASED;
		} else if(18 > p.getAge()){
			estado = RegisterResult.YOUNGER;
		}
		else {
			estado = RegisterResult.INVALID;
		}
        return estado;
    }
    
    public Optional<String> generateCertificate(Person person) {
    	Optional<String> certificado = Optional.of(person.toString());
        return certificado;
    }
}
