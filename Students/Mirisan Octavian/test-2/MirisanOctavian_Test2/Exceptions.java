public class Exceptions
{
    public static class ProjectNotFoundException extends RuntimeException {
        public ProjectNotFoundException(String message) {
            super(message);
        }
    }

    public static class TaskNotFoundException extends RuntimeException {
        public TaskNotFoundException(String message) {
            super(message);
        }
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class EmailAlreadyTakenException extends RuntimeException {
        public EmailAlreadyTakenException(String message) {
            super(message);
        }
    }

    public static class DuplicateProjectNameException extends RuntimeException{

        public DuplicateProjectNameException(String message) {
            super(message);
        }
    }
}
