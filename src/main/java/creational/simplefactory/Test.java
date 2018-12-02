package creational.simplefactory;

public class Test {
    public static void main(String[] args) {
        VideoFactory factory = new VideoFactory();
        Video video = factory.getVideo(JavaVideo.class);
        video.produce();
//        Video video = factory.getVideo("java");
//        if (video == null) {
//            return;
//        }
//        video.produce();
    }
}
