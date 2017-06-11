package com.alexprado.testemotor;

import com.alexprado.testemotor.AndGraph.AGGameManager;
import com.alexprado.testemotor.AndGraph.AGInputManager;
import com.alexprado.testemotor.AndGraph.AGScene;
import com.alexprado.testemotor.AndGraph.AGScreenManager;
import com.alexprado.testemotor.AndGraph.AGSoundManager;
import com.alexprado.testemotor.AndGraph.AGSprite;

/**
 * Created by catolica2017 on 10/06/17.
 */
public class PrimeiraCena extends AGScene
{
    AGSprite botao;
    int codigoTiro = 0;

    // Construtor da cena recebe o gerente de jogo
    PrimeiraCena(AGGameManager gerenteJogo)
    {
        super(gerenteJogo);
    }

    @Override
    public void init()
    {
        codigoTiro = AGSoundManager.vrSoundEffects.loadSoundEffect("slimeball.wav");
        botao = this.createSprite(R.drawable.botao, 1, 1);
        botao.setScreenPercent(60, 10);
        botao.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        botao.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        this.setSceneBackgroundColor(1.0f, 0.0f, 0.0f);

        AGSoundManager.vrMusic.loadMusic("bells.ogg", true);
        AGSoundManager.vrMusic.play();
    }

    @Override
    public void restart()
    {}

    @Override
    public void stop()
    {}

    @Override
    public void loop()
    {
        if(AGInputManager.vrTouchEvents.screenClicked())
        {
            AGSoundManager.vrSoundEffects.play(codigoTiro);
            if(botao.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                vrGameManager.setCurrentScene(1);
            }
        }
    }
}
