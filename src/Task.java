public class Task {
    private String title;
    private String description;
    private boolean completed;
    public Task(String initialTitle, String initialDescription ){
        this.title = initialTitle;
        this.description = initialDescription;
        this.completed = false;
    }
    public String toString(){
        return "Task Name: " + this.title + "\nDescription: " + this.description + "\nCompleted?: " + this.completed; 
    }
    public void markAsComplete(){
        this.completed = true;
    }
    public void changeDescription(String changedDescription){
        this.description = changedDescription;
    }
    public void changeTitle(String changedTitle){
        this.title = changedTitle;
    }
}
