package at.rovo.test.genericBuilders;

public class ChildA<D,E,Z> extends Base<Z>
{
    @SuppressWarnings("unchecked")
    public static class Builder<T extends ChildA<D,E,Z>,
                                B extends ChildA.Builder<? extends T, ? extends B, D, E, Z>,
                                D,E,Z>
            extends Base.Builder<T,
                                 B,
                                 Z>
    {
        protected D d;
        protected E e;

        public Builder(String a, String b, String c)
        {
            super(a, b, c);
        }

        public B withD(D d)
        {
            this.d = d;
            return (B)this;
        }

        public B withE(E e)
        {
            this.e = e;
            return (B)this;
        }

        @Override
        public T build()
        {
            return (T) new ChildA<>("ChildA", a, b, c, z, d, e);
        }
    }

    protected final D d;
    protected final E e;

    protected ChildA(String name, String a, String b, String c, Z z, D d, E e)
    {
        super(name, a, b, c, z);
        this.d = d;
        this.e = e;
    }

    public D getD()
    {
        return d;
    }

    public E getE()
    {
        return e;
    }

    @Override
    protected String getContent()
    {
        return ", D: " + d + ", E: " + e;
    }
}

