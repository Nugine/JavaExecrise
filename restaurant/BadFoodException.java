package restaurant;

// FIXME: The serializable class BadFoodException does not declare a static final serialVersionUID field of type long
public class BadFoodException extends Exception {

    public BadFoodException() {
    }

    public BadFoodException(String msg) {
        super(msg);
    }

}