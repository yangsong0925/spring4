package example01.bean;

public interface CompactDisc {

    default void play() {
        System.out.println(this.getClass().getSimpleName()+"-------------"+Thread.currentThread().getStackTrace()[2].getMethodName());
    }

}
