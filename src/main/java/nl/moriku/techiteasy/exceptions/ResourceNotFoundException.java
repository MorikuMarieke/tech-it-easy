package nl.moriku.techiteasy.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    // De exception zonder message
    public ResourceNotFoundException() {

        super();

    }

    // De exception met message
    public ResourceNotFoundException(String message) {

        super(message);

    }
}
