public class SomeApiImpl implements SomeApi {
    private final Integer b;

    public SomeApiImpl(Integer b) {
        this.b = b;
    }

    @Override
    public void a() {
        System.out.println(b);
    }
}
