import java.util.HashMap;

class Address {
    public final String street;
    public final int postalCode;
    public Address(String s, int p) {
        street = s;
        postalCode = p;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Address)) {
            return false;
        }
        Address a = (Address)o;
        return (this.street.equals(a.street) &&
                this.postalCode == a.postalCode);
    }

    public int hashCode() {
        return (this.street + Integer.toString(this.postalCode)).hashCode();
    }
}

class ExtendedAddress extends Address {
    public final String country;

    public ExtendedAddress(String s, int p, String c) {
        super(s, p);
        country = c;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ExtendedAddress)) {
            return false;
        }
        ExtendedAddress a = (ExtendedAddress)o;
        return (this.street.equals(a.street) &&
                this.postalCode == a.postalCode &&
                this.country.equals(a.country));
    }

    public int hashCode() {
        return (this.street + this.country +
                Integer.toString(this.postalCode)).hashCode();
    }
}

class Program {
    public static void main(String[] args) {
        HashMap<Address, Integer> map = new HashMap<Address, Integer>();

        map.put(new ExtendedAddress("kat", 42, "DK"), 1);
        boolean res = map.containsKey(new ExtendedAddress("kat", 42, "DK"));
        System.out.println(res);
        res = map.containsKey(new ExtendedAddress("kat", 41, "DK"));
        System.out.println(res);
    }
}