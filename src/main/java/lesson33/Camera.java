package lesson33;

public class Camera {
    private CameraRoll camRoll;

//    public Camera(CameraRoll camRoll) {
//        this.camRoll = camRoll;
//    }

    public void takePicture() {
        System.out.println("Click!");
        camRoll.processing();
    }

    public void setCamRoll(CameraRoll camRoll) {
        this.camRoll = camRoll;
    }
}
