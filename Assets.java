import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage background, buttonPlay;
    public static BufferedImage player_idle_front[], player_idle_back[], player_idle_left[], player_idle_right[];
    public static BufferedImage enemy_move_right[], enemy_move_left[], enemy_move_top[], enemy_move_bot[];

    public static void init() {

        // Player's textures
        SpriteSheet idle_front = new SpriteSheet(ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_front.png"));
        SpriteSheet idle_back = new SpriteSheet(ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_back.png"));
        SpriteSheet idle_left = new SpriteSheet(ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_left.png"));
        SpriteSheet idle_right = new SpriteSheet(ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_right.png"));

        SpriteSheet move_right = new SpriteSheet(ImageLoader.loadImage("Images/Creep/jugg.png"));
        SpriteSheet move_left = new SpriteSheet(ImageLoader.loadImage("Images/Creep/jugg.png"));
        SpriteSheet move_top = new SpriteSheet(ImageLoader.loadImage("Images/Creep/jugg.png"));
        SpriteSheet move_bot = new SpriteSheet(ImageLoader.loadImage("Images/Creep/jugg.png"));

        player_idle_front = new BufferedImage[3];
        player_idle_front[0] = idle_front.crop(0, 0, 32, 32);
        player_idle_front[1] = idle_front.crop(32, 0, 32, 32);
        player_idle_front[2] = idle_front.crop(0, 32, 32, 32);

        player_idle_back = new BufferedImage[3];
        player_idle_back[0] = idle_back.crop(0, 0, 32, 32);
        player_idle_back[1] = idle_back.crop(32, 0, 32, 32);
        player_idle_back[2] = idle_back.crop(0, 32, 32, 32);

        player_idle_left = new BufferedImage[3];
        player_idle_left[0] = idle_left.crop(0, 0, 32, 32);
        player_idle_left[1] = idle_left.crop(32, 0, 32, 32);
        player_idle_left[2] = idle_left.crop(0, 32, 32, 32);

        player_idle_right = new BufferedImage[3];
        player_idle_right[0] = idle_right.crop(0, 0, 32, 32);
        player_idle_right[1] = idle_right.crop(32, 0, 32, 32);
        player_idle_right[2] = idle_right.crop(0, 32, 32, 32);

        enemy_move_bot = new BufferedImage[4];
        enemy_move_bot[0] = move_bot.crop(0, 0, 46, 62);
        enemy_move_bot[1] = move_bot.crop(49, 0, 46, 62);
        enemy_move_bot[2] = move_bot.crop(95, 0, 46, 62);
        enemy_move_bot[3] = move_bot.crop(141, 0, 46, 62);

        enemy_move_left = new BufferedImage[4];
        enemy_move_left[0] = move_left.crop(0, 63, 46, 62);
        enemy_move_left[1] = move_left.crop(49, 63, 46, 62);
        enemy_move_left[2] = move_left.crop(95, 63, 46, 62);
        enemy_move_left[3] = move_left.crop(141, 63, 46, 62);

        enemy_move_right = new BufferedImage[4];
        enemy_move_right[0] = move_right.crop(0, 126, 46, 62);
        enemy_move_right[1] = move_right.crop(49, 126, 46, 62);
        enemy_move_right[2] = move_right.crop(95, 126, 46, 62);
        enemy_move_right[3] = move_right.crop(141, 126, 46, 62);

        enemy_move_top = new BufferedImage[4];
        enemy_move_top[0] = move_top.crop(0, 191, 46, 63);
        enemy_move_top[1] = move_top.crop(49, 191, 46, 63);
        enemy_move_top[2] = move_top.crop(95, 191, 46, 63);
        enemy_move_top[3] = move_top.crop(141, 191, 46, 63);

        background = ImageLoader.loadImage("Images/BackGround/bg_level_1.png");
        buttonPlay = ImageLoader.loadImage("Images/buttonplay.png");

    }
}