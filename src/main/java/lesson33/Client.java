package lesson33;

public class Client {
    public static void main(String[] args) {
        CameraRoll colorCamRoll = new ColorCameraRoll();
        CameraRoll bwCamRoll = new BlackWhiteCameroRoll();
        Camera cam = new Camera();
        
        cam.setCamRoll(colorCamRoll);
        cam.takePicture();

        cam.setCamRoll(bwCamRoll);
        cam.takePicture();

    }
}
