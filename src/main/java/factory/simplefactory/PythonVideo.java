package factory.simplefactory;

/**
 * 生产python视频
 */
public class PythonVideo extends Video{
    @Override
    public void produce() {
        System.out.println("生产python视频");
    }
}
