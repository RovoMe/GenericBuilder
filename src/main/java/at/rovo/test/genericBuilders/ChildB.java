package at.rovo.test.genericBuilders;

@SuppressWarnings({"hiding", "unchecked"})
public class ChildB<F,G,Z> extends Base<Z>
{
    public static class Builder<B extends ChildB.Builder<? extends B, F,G,Z>,
                                F,G,Z>
            extends Base.Builder<ChildB.Builder<B,F,G,Z>, Z>
    {
        protected F f;
        protected G g;

        public Builder(String a, String b, String c)
        {
            super(a, b, c);
        }

        public B withF(F f)
        {
            this.f = f;
            return (B)this;
        }

        public B withG(G g)
        {
            this.g = g;
            return (B)this;
        }

        @Override
        public <T> T build()
        {
            return (T) new ChildB<>("TestParamB", a, b, c, z, f, g);
        }
    }

    protected final F f;
    protected final G g;

    protected ChildB(String name, String a, String b, String c, Z z, F f, G g)
    {
        super(name, a, b, c, z);
        this.f = f;
        this.g = g;
    }

    public F getF()
    {
        return f;
    }

    public G getG()
    {
        return g;
    }

    @Override
    protected String getContent()
    {
        return ", F: " + f + ", G: " + g;
    }
}
