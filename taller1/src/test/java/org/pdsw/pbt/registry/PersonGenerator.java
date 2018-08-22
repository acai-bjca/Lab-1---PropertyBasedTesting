package org.pdsw.pbt.registry;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

public class PersonGenerator {

    public static Gen<Person> persons() {
        return name().zip(id(), age(), genero(), alive(), 
        		(name, id, age, gender, alive) -> new Person(name, id, age, gender, alive));
    }
    
    private static Gen<Integer> age() {
    	return integers().from(18).upToAndIncluding(100);
    }
    
    private static Gen<Integer> id() {
    	return integers().from(10000000).upToAndIncluding(1000000000);
    }
    
    private static Gen<String> name() {
    	return strings().basicLatinAlphabet().ofLengthBetween(3, 20);
    }
    
    private static Gen<Gender> genero() {
        Class e;
        e = Gender.class;
    	return Generate.enumValues(e);    
    }
    
    private static Gen<Boolean> alive() {
    	return booleans().all();
    }
    
}