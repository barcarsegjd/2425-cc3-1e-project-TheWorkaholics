public class Income {
    private String source;
    private boolean recurring;

    public Income(String source, boolean recurring) {
        this.source = source;
        this.recurring = recurring;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }
}
