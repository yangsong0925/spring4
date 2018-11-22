package example01.bean;

public class SgtPeppers implements CompactDisc {

    private String title;
    private Integer count;
    private CompactDisc compactDisc;

    public SgtPeppers() {
    }

    public SgtPeppers(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public SgtPeppers(String title, Integer count) {
        this.title = title;
        this.count = count;
    }

    public SgtPeppers(String title, Integer count, CompactDisc compactDisc) {
        this.title = title;
        this.count = count;
        this.compactDisc = compactDisc;
    }

    public void play() {
        System.out.println(this.getClass().getSimpleName()+"-------------"+Thread.currentThread().getStackTrace()[2].getMethodName());
    }

}
