1
===

1
---
d)

2
---
a)

3
---
c)

4
---
b)

5
---
a), c), e)


6
---
b), d)


3
===

1
---
Account: 001 .Balance: -0.50. Last op.: view balance

2
---
Account: 001 .Balance: -0.50. Last op.: view balance

3
---

Null pointer exception in BankAccount, line 41

4
---

See implementation in `three/4/BankAccount.java`.

5
---
The same as in question 3.1 and 3.2.


5
===

1
---

delegate bool SortingCriterion(CData o1, CData o2);

interface SortingCriterion {
    public bool call(CData o1, CData o2);
}


2
---
The type SortingCriterion can be used to perform any type of comparison wished. In order to do this, SortingCriterion internally calls actual implementations of comparison functions, OrderInAlphName and OrderInDescId, and really is just a wrapper around these implementations.

3
---

C#:
    var list = getList();
    var obj = new OrderInAlphName();
    SortingCriterion sorter = obj.is_less_than;
    quickSortCData(list, sorter);


Java:
    CData[] list = getList();
    final OrderInAlphName obj = new OrderInAlphName();
    SortingCriterion sorter = new SortingCriterion() {
        public bool call(CData o1, CData o2) {
            return obj.is_less_than(o1, o2);
        }
    }
    quickSortCData(list, sorter);