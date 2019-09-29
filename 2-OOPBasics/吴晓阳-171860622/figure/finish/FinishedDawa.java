package figure.finish;

import creator.BasicCreator;
import figure.Calabash;
import figure.DrawableFigure;
import figure.feature.Emittable;
import figure.feature.Lifable;
import imgs.ImageRepository;
import item.BasicBullet;
import sync.SyncGenerator;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class FinishedDawa extends Calabash.Dawa implements DrawableFigure, Emittable<BasicBullet>, Lifable {

    private SyncGenerator<BasicBullet> generator =
            new SyncGenerator<>(
                    new BasicCreator<>(BasicBullet.class),
                    1000,
                    TimeUnit.MILLISECONDS
            );

    private Image image = ImageRepository.getImage("Dawa", new Dimension(100, 100));

    private int life = 100;

    public FinishedDawa(){
        this.generator.startGenerating();
    }

    @Override
    public boolean isEmittable() {
        return generator.isReady();
    }

    @Override
    public BasicBullet emit() {
        return generator.fetch();
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public int addLife(int life) {
        return this.life += life;
    }

    @Override
    public int diminishLife(int life) {
        this.life -= life;
        if(this.life <= 0){
            this.life = 0;
        }
        return this.life;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
