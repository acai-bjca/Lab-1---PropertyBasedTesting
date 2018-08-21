package org.pdsw.pbt.registry;

public class RegistryTest {

    @Test
    public void validateRegistryResult() {
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
                // TODO: Add property tests
                return false;
            });
    }

@Test
public void validateCertificate() {
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
                // TODO: Add property tests
                return false;
            });
    }
}
