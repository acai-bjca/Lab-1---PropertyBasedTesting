package org.pdsw.pbt.registry;

public class PersonGenerator {
    public static Gen<Person> persons() {
        return name().zip(id(), age(), genero(), alive(), 
        		(name, id, age, gender, alive) -> Person(name, id, age, gender, alive));
    }
    
    private Gen<Integer> age() {
    	return integers().from(18).upToAndIncluding(100);
    }
    
    private Gen<Integer> id() {
    	return integers().from(10000000).upToAndIncluding(1000000000);
    }
    
    private Gen<String> name() {
    	String [] nombres = {"Andrea", "David", "Carlos","Nicolas","Andres","Jairo","Miguel","Mauricio","Luis","Ruben","Martin","Angel","Andrea","Monica","Bernarda","Carmen","Laura","Lisbeth","Stefanie","Tatiana","Alejandra","Diana"};
    	String [] apellidos = {"Gomez", "Lozada", "Cardenas","Alfonso","Vega","Torres","Ospina","Quintana","Vargas","Moreno","Ruiz","Castro"};
    	
    	String nombre = nombres[(int) (Math.random() * (nombres.lenght-1)) + 1] + apellidos[(int) (Math.random() * (apellidos.lenght -1)) + 1];
    	
    	return nombre;
    }
    
    private Gen<Gender> genero() {
    	
    	int option = (int) (Math.random() * 3) + 1;
    	Gender genero;
    	
    	switch (option) {
    	
    		case 1:
    			genero = Gender.MALE;
    			break;
    		case 2:
    			genero = Gender.FEMALE;
    			break;
    		case 3:
    			genero = Gender.UNIDENTIFIED;
    			break;
    	}
    	
    	return genero;
    }
    
    private Gen<Boolean> alive() {
    	
    	int option = (int) (Math.random() * 2) + 1;
    	boolean alive;
    	switch (option) {
    		case 1:
    			alive = true;
    			break
    		case 2:
    			alive = false;
    			break
    	}
    	
    	return alive;
    }
    
}