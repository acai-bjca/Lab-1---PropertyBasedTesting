package org.pdsw.pbt.registry;

public class Registry {
    public RegisterResult registerVoter(Person p) {

        return RegisterResult.VALID;
    }

    public Optional<String> generateCertificate(Person person) {

        return Optional.empty();
    }
}
