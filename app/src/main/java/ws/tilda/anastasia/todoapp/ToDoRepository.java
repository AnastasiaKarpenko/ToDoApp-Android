package ws.tilda.anastasia.todoapp;

import java.util.ArrayList;
import java.util.List;

public class ToDoRepository {

    /* This Singleton allows multiple threads to reach the instance. The app is small so Sngleton
    will not cause memory issues.
     */
    private static volatile ToDoRepository INSTANCE = new ToDoRepository();

    private List<ToDoModel> items = new ArrayList<>();

    // Only one thread at a time can get the repository
    public synchronized static ToDoRepository get() {
        return INSTANCE;
    }


    // A constructor that generates the initial data while we don't have a DB
    private ToDoRepository() {
        items.add(ToDoModel.builder()
                .description("Buy a copy of _Exploring Android_")
                .notes("See https://wares.commonsware.com")
                .isCompleted(true)
                .build());
        items.add(ToDoModel.builder()
                .description("Complete all of the tutorials")
                .build());
        items.add(ToDoModel.builder()
                .description("Write an app for somebody in my community")
                .notes("Talk to some people at non-profit organizations to see what they need!")
                .build());
    }

    /* This method allows others to get the copy of ArrayList,
     so that only Repository itself could change the original list with data.
     */
    public List<ToDoModel> all() {
        return new ArrayList<>(items);
    }
}