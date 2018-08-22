package org.pdsw.pbt.registry;

import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;
import org.pdsw.pbt.triangle.TriangleType;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class RegistryTest {

    @Test
    public void validateRegistryResult() {
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
                RegisterResult result;
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
