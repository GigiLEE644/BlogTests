public class DatabaseSearch implements Search {
    @Override
    public void search(String keyword) {
        System.out.println("Searching '" + keyword + "' In Database");
    }
}