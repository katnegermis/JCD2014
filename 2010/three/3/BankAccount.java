import java.math.BigDecimal;
import java.io.Serializable;

public class BankAccount implements Serializable // Version2
{
    private static final long serialVersionUID = 1L;
    private String code;
    private transient String lastOperation;
    private BigDecimal balance;

    public BankAccount( String custCode ) {
        setCode(custCode);
        balance = BigDecimal .ONE;
        setLastOperation("creation");
    }

    public BigDecimal getBalance() {
        setLastOperation("view balance");
        return balance;
    }

    public void setCode( String code ) {
        this.code = code;
        setLastOperation("set code");
    }

    public void deposit( BigDecimal amount ) {
        balance = balance.add( amount );
        setLastOperation("deposit");
    }

    public void withdraw( BigDecimal amount ) {
        balance = balance.subtract( amount );
        setLastOperation("withdraw");
    }

    public String toString() {
        return "Account: " + code + " .Balance: " +
            getBalance().toString() +
            ". Last op.: " + lastOperation;
    }

    public void setLastOperation( String lastOperation ) {
        this.lastOperation = lastOperation;
    }
}