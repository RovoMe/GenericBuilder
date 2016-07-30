package at.rovo.test.genericBuilders;

public class Main
{
    public static void main(String ... args)
    {
        // product test
        ChildA<D,E,?> a = new ChildA.Builder<ChildA<D,E,String>, ChildA.Builder<?,?,D,E,String>,D,E,String>("a", "b", "c")
                .withD(new D()).withE(new E()).build();
        ChildB<F,G,String> b = new ChildB.Builder<ChildB<F,G,String>, ChildB.Builder<?,?,F,G,String>,F,G,String>("a", "b", "c")
                .withF(new F()).withG(new G()).withOptionalZ("z").build();
        Base<String> c = new ChildA.Builder<ChildA<D,E,String>, ChildA.Builder<?,?,D,E,String>,D,E,String>("a", "b", "c")
                .withD(new D()).withE(new E()).withOptionalZ("z").build();
        Base d = new ChildB.Builder<ChildB<F,G,String>, ChildB.Builder<?,?,F,G,String>,F,G,String>("a", "b", "c")
                .withF(new F()).withG(new G()).build();

        test(a);
        test(b);
        test(c);
        test(d);

        System.out.println();

        // builder test
        test(new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()));
        test(new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()).withOptionalZ("z")); // IntelliJ reports ambiguous method call error, compiles fine though
        testBase(new ChildA.Builder<>("a", "b", "c").withD(new D()).withE(new E()).withOptionalZ("z")); // IntelliJ reports ambiguous method call error, compiles fine though
        testBase(new ChildB.Builder<>("a", "b", "c").withF(new F()).withG(new G()));

        System.out.println();

        // avoid reported errors (compiled though none the less)
        test(new ChildB.Builder<ChildB<F,G,String>, ChildB.Builder<?,?,F,G,String>,F,G,String>("a", "b", "c").withF(new F()).withG(new G()).withOptionalZ("z"));
        testBase(new ChildA.Builder<ChildA<D,E,String>, ChildA.Builder<?,?,D,E,String>,D,E,String>("a", "b", "c").withD(new D()).withE(new E()).withOptionalZ("z"));
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

    public static void test(ChildA.Builder<? extends ChildA<?,?,?>, ? extends ChildA.Builder<?,?,?,?,?>, ?,?,?> builder)
    {
        System.out.println("Test for BuilderA: " + builder.build().toString());
    }

    public static void test(ChildB.Builder<? extends ChildB<?,?,?>, ? extends ChildB.Builder<?,?,?,?,?>, ?,?,?> builder)
    {
        System.out.println("Test for BuilderB: " + builder.build().toString());
    }

    public static void testBase(Base.Builder<? extends Base<?>, ? extends Base.Builder<?,?,?>, ?> builder)
    {
        System.out.println("Test for Base builder: " + builder.build().toString());
    }
}

