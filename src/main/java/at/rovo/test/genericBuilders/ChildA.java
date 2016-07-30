package at.rovo.test.genericBuilders;

public class ChildA<D,E,Z> extends Base<Z>
{
    @SuppressWarnings("unchecked")
    public static class Builder<B extends ChildA.Builder<? extends B, D, E, Z>,
                                D,E,Z>
            extends Base.Builder<ChildA.Builder<B,D,E,Z>, Z>
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
        public <T> T build()
        {
            return (T) new ChildA<>("TestParamA", a, b, c, z, d, e);
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

