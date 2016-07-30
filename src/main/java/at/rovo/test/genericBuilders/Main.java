package at.rovo.test.genericBuilders;

public class Main
{
    public static void main(String ... args)
    {
        ChildA<D,E,?> a = new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()).build();
        ChildB<F,G,String> b = new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()).withOptionalZ("z").build();
        Base<String> c = new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()).withOptionalZ("z").build();
        Base d = new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()).build();

        test(a);
        test(b);
        test(c);
        test(d);
        test(new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()));
        test(new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()).withOptionalZ("z"));
        testBase(new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()).withOptionalZ("z"));
        testBase(new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()));
    }

    public static void test(ChildA<?,?,?> testParam)
    {
        System.out.println("Test for ChildA: " + testParam.toString());
    }

    public static void test(ChildB<?,?,?> testParam)
    {
        System.out.println("Test for ChildB: " + testParam.toString());
    }

    public static void test(Base<?> testParam)
    {
        System.out.println("Test for Base: " + testParam.toString());
    }

    public static void test(ChildA.Builder<?,?,?,?> builder)
    {
        System.out.println("Test for BuilderA: " + builder.build().toString());
    }

    public static void test(ChildB.Builder<?,?,?,?> builder)
    {
        System.out.println("Test for BuilderB: " + builder.build().toString());
    }

    public static void testBase(Base.Builder<?,?> builder)
    {
        System.out.println("Test for Base builder: " + builder.build().toString());
    }
}

