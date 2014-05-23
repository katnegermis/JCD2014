import java.math.BigDecimal;
import java.io.Serializable;

public class BankAccount implements Serializable // Version1
{
    private static final long serialVersionUID = 1L;
    private String code;
    private BigDecimal totalwithdrawals;
    private BigDecimal totaldeposits;
    private transient String lastOperation;

    public BankAccount(String custCode) {
        setCode(custCode);
        totaldeposits = BigDecimal.ONE;
        totalwithdrawals = BigDecimal.ZERO;
        setLastOperation("creation");
    }

    public void setCode(String code) {
        this.code = code;
        setLastOperation("setcode");
    }

    public BigDecimal getBalance() {
        setLastOperation("view balance");
        return new BigDecimal(
            totaldeposits.subtract(totalwithdrawals)
            .toString());
    }

    public void deposit(BigDecimal amount) {
        totaldeposits = totaldeposits.add(amount);
        setLastOperation("deposit");
    }

    public void withdraw(BigDecimal amount) {
        totalwithdrawals = totalwithdrawals.add(amount);
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