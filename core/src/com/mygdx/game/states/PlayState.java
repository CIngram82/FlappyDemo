package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyDemo;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

/**
 * Created by cingr on 10/12/2017.
 */

public class PlayState extends State {
    private Bird bird;
    private Texture bg;
    private Tube tube;


    @Override
    protected void handleInput() {
    if(Gdx.input.justTouched()){
        bird.jump();
    }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2),0);
        sb.draw(bird.getTexture(), bird.getPosition().x,bird.getPosition().y);
        sb.draw(tube.getTopTube(),tube.getPosTopTube().x, tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);
        sb.end();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    public void dispose() {

    }

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 100);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
        bg = new Texture("bg.png");
        tube = new Tube(100);
    }
}
