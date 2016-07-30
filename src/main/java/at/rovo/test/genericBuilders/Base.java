package at.rovo.test.genericBuilders;

public abstract class Base<Z>
{
    public static abstract class Builder<B extends Builder<? extends B, Z>, Z>
    {
        protected final String a;
        protected final String b;
        protected final String c;
        protected Z z = null;

        public Builder(String a, String b, String c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @SuppressWarnings("unchecked")
        public B withOptionalZ(Z z)
        {
            this.z = z;
            return (B)this;
        }

        public abstract <T> T build();
    }

    protected final String name;
    protected final String a;
    protected final String b;
    protected final String c;
    protected Z z = null;

    protected Base(String name, String a, String b, String c)
    {
        this(name, a, b, c, null);
    }

    protected Base(String name, String a, String b, String c, Z z)
    {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = z;
    }

    public String getA()
    {
        return a;
    }

    public String getB()
    {
        return b;
    }

    public String getC()
    {
        return c;
    }

    protected abstract String getContent();

    @Override
    public String toString()
    {
        return name+"[A: " + a + ", B: " + b + ", C: " + c + (z != null ? ", Z: " + z.toString() : "") + getContent() +"]";
    }
}