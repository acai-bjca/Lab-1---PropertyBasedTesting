package org.pdsw.pbt.registry;

import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;
import org.pdsw.pbt.registry.RegisterResult;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class RegistryTest {

    @Test
    public void validateRegistryResult() {
    	Registry registro = new Registry();
    	PBTClassifier pbtClassifier = new PBTClassifier("Test Person Valid");
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
            	
            	RegisterResult result = registro.registerVoter(voter);
            	if (!voter.isAlive()) {
            		pbtClassifier.collect("Not a valid person");
					return RegisterResult.INVALID == result;
				} else if (voter.getAge() < 18) {
					pbtClassifier.collect("Not a valid person");
					return RegisterResult.INVALID == result;
				} else {
					pbtClassifier.collect("Valid person");
					return RegisterResult.VALID == result;
				}
            	            
            });
    }

    @Test
    public void validateCertificate() {
    	Registry registro = new Registry();
    	PBTClassifier pbtClassifier = new PBTClassifier("Test Certification");
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
            	
            	RegisterResult result = registro.certificado(voter);
            	
            	if (!voter.isAlive()) {
            		pbtClassifier.collect("Not certificated");
					return RegisterResult.UNCERTIFICATION == result;
				} else if (voter.getAge() < 18) {
					pbtClassifier.collect("Not certificated");
					return RegisterResult.UNCERTIFICATION == result;
				} else {
					pbtClassifier.collect("Certificated");
					return RegisterResult.CERTIFICATION == result;
				}
            	
            });
        }
}
