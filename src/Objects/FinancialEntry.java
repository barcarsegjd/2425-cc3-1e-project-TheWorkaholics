```java
  
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Currency;

abstract class FinancialEntry {
    private int entryId;
    private double amount;
    private LocalDate date;
    private Currency currency;
    private EntryType type;
    private Category category;
    private boolean isArchived;

    public FinancialEntry(int entryId, double amount, LocalDate date, Currency currency, EntryType type, Category category, boolean isArchived) {
        this.entryId = entryId;
        this.amount = amount;
        this.date = date;
        this.currency = currency;
        this.type = type;
        this.category = category;
        this.isArchived = isArchived;
    }

    public String getFormattedAmount() {
        return String.format("%s %.2f", currency.getSymbol(), amount);
    }

    // Getters and Setters
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
}

```
