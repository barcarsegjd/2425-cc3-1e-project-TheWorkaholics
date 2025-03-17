public class Expense {
    private String paymentMethod;
    private String receipt;

    public Expense(String paymentMethod, String receipt) {
        this.paymentMethod = paymentMethod;
        this.receipt = receipt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
