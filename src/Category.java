```java

public class Category {
    private int categoryId;
    private String name;
    private String description;
    private EntryType type;

    // Constructor
    public Category(int categoryId, String name, String description, EntryType type) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }
}

```
