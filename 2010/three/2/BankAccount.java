import java.math.BigDecimal;
import java.io.Serializable;

public class BankAccount implements Serializable // Version1
{
    private static final long serialVersionUID = 1L;
    private String code;
    private BigDecimal total_withdrawals;
    private BigDecimal total_deposits;
    private transient String lastOperation;

    public BankAccount(String custCode) {
        setCode(custCode);
        total_deposits = BigDecimal.ONE;
        total_withdrawals = BigDecimal.ZERO;
        setLastOperation("creation");
    }

    public void setCode(String code) {
        this.code = code;
        setLastOperation("setcode");
    }

    public BigDecimal getBalance() {
        setLastOperation("view balance");
        return new BigDecimal(
            total_deposits.subtract(total_withdrawals)
            .toString());
    }

    public void deposit(BigDecimal amount) {
        total_deposits = total_deposits.add(amount);
        setLastOperation("deposit");
    }

    public void withdraw(BigDecimal amount) {
        total_withdrawals = total_withdrawals.add(amount);
        setLastOperation("withdraw");
    }

    public String toString() {
        return "Account: " + code + " .Balance: " +
            getBalance().toString() +
            ". Last op.: " + lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }
}