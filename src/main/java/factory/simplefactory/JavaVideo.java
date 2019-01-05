package factory.simplefactory;

/**
 * 生产Java视频
 */
public class JavaVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制Java视频");
    }
}
