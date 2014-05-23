import java.math.BigDecimal;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

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

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = ois.readFields();
        this.code = (String)fields.get("code", "");
        BigDecimal deposits = (BigDecimal)fields.get("total_deposits", BigDecimal.ONE);
        BigDecimal withdrawals = (BigDecimal)fields.get("total_withdrawals", BigDecimal.ZERO);
        this.balance = deposits.subtract(withdrawals);
    }
}