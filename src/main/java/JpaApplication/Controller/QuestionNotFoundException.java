package JpaApplication.Controller;

class QuestionNotFoundException extends RuntimeException {

    QuestionNotFoundException (Long id) {
        super("Could not find employee " + id);
    }
}