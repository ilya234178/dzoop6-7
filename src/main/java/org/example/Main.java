
import org.example.Note.controllers.UserController;
import org.example.Note.model.FileOperation;
import org.example.Note.model.FileOperationImpl;
import org.example.Note.model.Repository;
import org.example.Note.model.RepositoryFile;
import org.example.Note.view.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("id.txt");
        Repository repository = new RepositoryFile(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}