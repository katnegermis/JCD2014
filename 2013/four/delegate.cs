using System.Collections.Generic;
using System.Linq;
using System;

namespace myname {
    class Program {
        static void Main(string[] args) {
            PrimitiveCriterion<int> p1 = new PrimitiveCriterion<int>(
                value => { return value % 3 == 0; }
            );
            PrimitiveCriterion<int> p2 = new PrimitiveCriterion<int>(
                value => { return value % 4 == 0; }
            );

            // NegCriterion not implemented.
            // Results will be all numbers evenly divisible by BOTH 3 and 4.
            AndCriterion<int> a1 = new AndCriterion<int>(p1, p2);

            int[] values = Enumerable.Range(1, 20).ToArray();

            foreach (int i in Selector<int>.LazySelected(values, a1)) {
                Console.Write(i);
                Console.Write(",");
            }
            Console.WriteLine();

            foreach (int i in Selector<int>.EagerSelected(values, a1)) {
                Console.Write(i);
                Console.Write(",");
            }
        }
    }

    public delegate bool criFunc<T>(T t);

    interface Criterion<T> {
        void accept(CriterionVisitor<T> v);
    }

    interface CriterionVisitor<T> {
        void visit(Criterion<T> c);
    }

    class PrimitiveCriterion<T> : Criterion<T> {
        private criFunc<T> criterionFunc;

        public criFunc<T> CriterionFunc {
            get { return criterionFunc; }
            protected set { criterionFunc = value; }
        }

        public PrimitiveCriterion(criFunc<T> cf) {
            CriterionFunc = cf;
        }

        public void accept(CriterionVisitor<T> v) {
            v.visit(this);
        }
    }

    class AndCriterion<T> : Criterion<T> {
        private Criterion<T> leftCriterion;
        private Criterion<T> rightCriterion;

        public Criterion<T> LeftCriterion {
            get { return leftCriterion; }
            private set { leftCriterion = value; }
        }

        public Criterion<T> RightCriterion {
            get { return rightCriterion; }
            private set { rightCriterion = value; }
        }

        public AndCriterion(Criterion<T> lc, Criterion<T> rc) {
            LeftCriterion = lc;
            RightCriterion = rc;
        }

        public void accept(CriterionVisitor<T> v) {
            v.visit(this);
        }
    }

    class CriterionChecker<T> : CriterionVisitor<T> {
        private bool satisfies;
        private T subject;

        public bool check(T subject, Criterion<T> criterion) {
            this.subject = subject;
            // Reset satisfies between calls.
            this.satisfies = true;
            criterion.accept(this);
            return this.satisfies;
        }

        // Only creating one visit method here, since LazySelected
        // and EagerSelected only calls with Criterion<T> types.
        // This method is very ugly and has been made as short
        // as I could. The exam paper only has 12 lines for a
        // solution. This solution, even when not using brackets
        // ideomatically, just fits.
        public void visit(Criterion<T> c) {
            if (!this.satisfies) // We know result is false if previous argument wasn't satisfied.
                return;
            if (c is AndCriterion<T>) {
                (c as AndCriterion<T>).LeftCriterion.accept(this);
                if (!this.satisfies) // We know result is false if first argument isn't satisfied.
                    return;
                (c as AndCriterion<T>).RightCriterion.accept(this);
            }
            else if (c is PrimitiveCriterion<T>)
                this.satisfies = (c as PrimitiveCriterion<T>).CriterionFunc(this.subject);
        }
    }

    class Selector<T> {
        public static CriterionChecker<T> checker = new CriterionChecker<T>();

        public static IEnumerable<T> LazySelected(IEnumerable<T> source, Criterion<T> cri) {
            return source.Where(i => {
                return checker.check(i, cri);
            });
        }

        public static IEnumerable<T> EagerSelected(IEnumerable<T> source, Criterion<T> cri) {
            List<T> result = new List<T>(10);
            foreach (var i in source) {
                if (checker.check(i, cri)) {
                    result.Add(i);
                }
            }
            return result;
        }
    }
}