package Assets.Codes;

import java.awt.image.BufferedImage;

public class Assets {

        public static BufferedImage background1, background2, background3, background4, background5, buttonPlay,
                        buttonPause, buttonResume, name[], background[];
        public static BufferedImage player_idle_front[], player_idle_back[], player_idle_left[], player_idle_right[];
        public static BufferedImage enemy_move_right[], enemy_move_left[], enemy_move_top[], enemy_move_bot[];
        public static BufferedImage player_attack_front[], player_attack_back[], player_attack_left[],
                        player_attack_right[];

        public static void init() {

                // Player's textures
                SpriteSheet idle_front = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_idle_front.png"));
                SpriteSheet idle_back = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_idle_back.png"));
                SpriteSheet idle_left = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_idle_left.png"));
                SpriteSheet idle_right = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_idle_right.png"));

                SpriteSheet attack_front = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_front.png"));
                SpriteSheet attack_back = new SpriteSheet(
                                ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_back.png"));
                // SpriteSheet attack_left = new
                // SpriteSheet(ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left.png"));
                // SpriteSheet attack_right = new
                // SpriteSheet(ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right.png"));

                // Enemy's textures
                SpriteSheet move_right = new SpriteSheet(ImageLoader.loadImage("../Images/Creep/jugg.png"));
                SpriteSheet move_left = new SpriteSheet(ImageLoader.loadImage("../Images/Creep/jugg.png"));
                SpriteSheet move_top = new SpriteSheet(ImageLoader.loadImage("../Images/Creep/jugg.png"));
                SpriteSheet move_bot = new SpriteSheet(ImageLoader.loadImage("../Images/Creep/jugg.png"));

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

                player_attack_front = new BufferedImage[9];
                player_attack_front[0] = attack_front.crop(15, 1, 32, 32);
                player_attack_front[1] = attack_front.crop(79, 1, 32, 32);
                player_attack_front[2] = attack_front.crop(143, 1, 32, 32);
                player_attack_front[3] = attack_front.crop(15, 63, 32, 64);
                player_attack_front[4] = attack_front.crop(79, 63, 36, 64);
                player_attack_front[5] = attack_front.crop(143, 63, 36, 64);
                player_attack_front[6] = attack_front.crop(15, 125, 36, 64);
                player_attack_front[7] = attack_front.crop(79, 125, 36, 64);
                player_attack_front[8] = attack_front.crop(143, 125, 36, 64);

                player_attack_back = new BufferedImage[9];
                player_attack_back[0] = attack_back.crop(15, 29, 32, 32);
                player_attack_back[1] = attack_back.crop(80, 29, 32, 32);
                player_attack_back[2] = attack_back.crop(143, 29, 32, 32);
                player_attack_back[3] = attack_back.crop(15, 63, 32, 64);
                player_attack_back[4] = attack_back.crop(80, 63, 36, 64);
                player_attack_back[5] = attack_back.crop(143, 63, 36, 64);
                player_attack_back[6] = attack_back.crop(15, 125, 36, 64);
                player_attack_back[7] = attack_back.crop(80, 125, 36, 64);
                player_attack_back[8] = attack_back.crop(143, 125, 36, 64);

                player_attack_left = new BufferedImage[12];
                player_attack_left[0] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_1.png");
                player_attack_left[1] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_2.png");
                player_attack_left[2] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_3.png");
                player_attack_left[3] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_4.png");
                player_attack_left[4] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_5.png");
                player_attack_left[5] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_6.png");
                player_attack_left[6] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_7.png");
                player_attack_left[7] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_8.png");
                player_attack_left[8] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_9.png");
                player_attack_left[9] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_10.png");
                player_attack_left[10] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_11.png");
                player_attack_left[11] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_left_12.png");
                // player_attack_left[0] = attack_left.crop(40, 1, 33, 64);
                // player_attack_left[1] = attack_left.crop(120, 1, 32, 64);
                // player_attack_left[2] = attack_left.crop(196, 1, 32, 64);
                // player_attack_left[3] = attack_left.crop(40, 79, 34, 64);
                // player_attack_left[4] = attack_left.crop(120, 79, 32, 64);
                // player_attack_left[5] = attack_left.crop(192, 79, 35, 64);
                // player_attack_left[6] = attack_left.crop(0, 157, 84, 64);
                // player_attack_left[7] = attack_left.crop(60, 157, 84, 64);
                // player_attack_left[8] = attack_left.crop(120, 157, 84, 64);
                // player_attack_left[9] = attack_left.crop(0, 236, 84, 64);
                // player_attack_left[10] = attack_left.crop(60, 236, 84, 64);
                // player_attack_left[11] = attack_left.crop(120, 236, 84, 64);

                player_attack_right = new BufferedImage[12];
                player_attack_right[0] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_1.png");
                player_attack_right[1] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_2.png");
                player_attack_right[2] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_3.png");
                player_attack_right[3] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_4.png");
                player_attack_right[4] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_5.png");
                player_attack_right[5] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_6.png");
                player_attack_right[6] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_7.png");
                player_attack_right[7] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_8.png");
                player_attack_right[8] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_9.png");
                player_attack_right[9] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_10.png");
                player_attack_right[10] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_11.png");
                player_attack_right[11] = ImageLoader.loadImage("../Images/Player/Zeus/zeus_attack_right_12.png");
                // player_attack_right[0] = attack_right.crop(15, 1, 32, 32);
                // player_attack_right[1] = attack_right.crop(79, 1, 32, 32);
                // player_attack_right[2] = attack_right.crop(143, 1, 32, 32);
                // player_attack_right[3] = attack_right.crop(15, 63, 32, 64);
                // player_attack_right[4] = attack_right.crop(79, 63, 36, 64);
                // player_attack_right[5] = attack_right.crop(143, 63, 36, 64);
                // player_attack_right[6] = attack_right.crop(15, 125, 36, 64);
                // player_attack_right[7] = attack_right.crop(79, 125, 36, 64);
                // player_attack_right[8] = attack_right.crop(143, 125, 36, 64);
                // player_attack_right[9] = attack_right.crop(15, 125, 36, 64);
                // player_attack_right[10] = attack_right.crop(79, 125, 36, 64);
                // player_attack_right[11] = attack_right.crop(143, 125, 36, 64);

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

                background = new BufferedImage[5];
                background[0] = ImageLoader.loadImage("../Images/BackGround/bg_level_1.png");

                background1 = ImageLoader.loadImage("../Images/BackGround/bg_level_1.png");
                background2 = ImageLoader.loadImage("../Images/BackGround/bg_level_2.png");
                background3 = ImageLoader.loadImage("../Images/BackGround/bg_level_3.png");
                background4 = ImageLoader.loadImage("../Images/BackGround/bg_level_4.png");
                background5 = ImageLoader.loadImage("../Images/BackGround/bg_level_5.png");

                buttonPlay = ImageLoader.loadImage("../Images/Other/buttonplay.png");

                buttonPause = ImageLoader.loadImage("../Images/Other/pause.png");

                buttonResume = ImageLoader.loadImage("../Images/Other/resume.png");

                name = new BufferedImage[5];
                name[0] = ImageLoader.loadImage("../Images/Other/DOTA/dota1.png");
                name[1] = ImageLoader.loadImage("../Images/Other/DOTA/dota2.png");
                name[2] = ImageLoader.loadImage("../Images/Other/DOTA/dota3.png");
                name[3] = ImageLoader.loadImage("../Images/Other/DOTA/dota4.png");
                name[4] = ImageLoader.loadImage("../Images/Other/DOTA/dota5.png");

        }
}