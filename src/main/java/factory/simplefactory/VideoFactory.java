package factory.simplefactory;

/**
 * 根据类型返回响应的对象
 */
public class VideoFactory {
    public Video getVideo(String type){
        //比较不区分大小写
        if ("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if ("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;
    }

    public Video getVideo(Class clazz){
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return video;
    }
}
