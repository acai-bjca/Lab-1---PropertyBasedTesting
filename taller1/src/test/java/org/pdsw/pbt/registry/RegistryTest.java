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
            	if(18 <= voter.getAge() && voter.isAlive()) {
            		pbtClassifier.collect("Valid person");
					return RegisterResult.VALID == result;
            	} else if (!voter.isAlive()) {
            		pbtClassifier.collect("Is Death");
					return RegisterResult.DECEASED == result;
				} else if (voter.getAge() < 18) {
					pbtClassifier.collect("Is younger");
					return RegisterResult.YOUNGER == result;
				} else {
					pbtClassifier.collect("Not a valid person");
					return RegisterResult.INVALID == result;
				}
            	            
            });
    }
}
