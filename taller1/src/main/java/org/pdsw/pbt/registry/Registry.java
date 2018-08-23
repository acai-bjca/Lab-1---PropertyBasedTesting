package org.pdsw.pbt.registry;

import java.util.Optional;

public class Registry {
    public RegisterResult registerVoter(Person p) {
        RegisterResult estado;
        if (18 <= p.getAge() && p.isAlive()) {
			estado = RegisterResult.VALID;
		} else {
			estado = RegisterResult.INVALID;
		}
        return estado;
    }
    
    public RegisterResult certificado(Person p) {
    	RegisterResult estado = registerVoter(p); 	
    	RegisterResult certificacion;
    	if (estado == RegisterResult.VALID) {
    		certificacion = RegisterResult.CERTIFICATION;
    		generateCertificate(p);
		} else {
			certificacion = RegisterResult.UNCERTIFICATION;
		}
    	return certificacion;
	}
    
    public Optional<String> generateCertificate(Person person) {
    	Optional.of(person.toString());
        return Optional.empty();
    }
}
