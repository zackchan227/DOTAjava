import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player_idle_front[], enemy[], background,buttonPlay;

    public static void init() {
        SpriteSheet idle_front = new SpriteSheet(ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_front.png"));
       
        player_idle_front = new BufferedImage[3];
        player_idle_front[0] = idle_front.crop(0, 0, 32, 32);
        player_idle_front[1] = idle_front.crop(32, 0, 32, 32);
        player_idle_front[2] = idle_front.crop(0, 32, 32, 32);

        background = ImageLoader.loadImage("Images/BackGround/bg_level_1.png");
        buttonPlay = ImageLoader.loadImage("Images/buttonplay.png");

    }
}