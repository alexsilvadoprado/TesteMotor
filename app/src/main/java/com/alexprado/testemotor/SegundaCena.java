package com.alexprado.testemotor;

import com.alexprado.testemotor.AndGraph.AGGameManager;
import com.alexprado.testemotor.AndGraph.AGInputManager;
import com.alexprado.testemotor.AndGraph.AGScene;
import com.alexprado.testemotor.AndGraph.AGScreenManager;
import com.alexprado.testemotor.AndGraph.AGSprite;
import com.alexprado.testemotor.AndGraph.AGTimer;

/**
 * Created by catolica2017 on 10/06/17.
 */
public class SegundaCena extends AGScene
{
    AGSprite bulldog = null;
    AGSprite briga = null;
    AGSprite gato = null;
    boolean pausa = false;

    // Construtor da cena recebe o gerente de jogo
    SegundaCena(AGGameManager gerenteJogo)
    {
        super(gerenteJogo);
    }

    @Override
    public void init()
    {
        this.setSceneBackgroundColor(0.0f, 0.0f, 0.0f);

        gato = createSprite(R.drawable.gato, 8, 8);
        gato.setScreenPercent(20, 40);
        gato.vrPosition.setX(gato.getSpriteWidth() / 2);
        gato.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        gato.addAnimation(10, true, 0, 15); // PULO
        gato.addAnimation(10, true, 16, 28); // EPERA
        gato.addAnimation(10, true, 29, 40); // CAMINHA
        gato.setCurrentAnimation(2);

        briga = createSprite(R.drawable.briga, 8, 4);
        briga.setScreenPercent(40, 40);
        briga.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        briga.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        briga.addAnimation(15, false, 0, 27);
        briga.bVisible = false;

        bulldog = createSprite(R.drawable.buldogue, 4, 4);
        bulldog.setScreenPercent(20, 40);
        bulldog.vrPosition.setX(AGScreenManager.iScreenWidth - bulldog.getSpriteWidth() / 2);
        bulldog.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        bulldog.addAnimation(10, true, 0, 11);
        bulldog.iMirror = AGSprite.HORIZONTAL;
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop()
    {
        if(AGInputManager.vrTouchEvents.screenClicked())
        {
            pausa = !pausa;
        }
        if(!pausa)
        {
            logicaJogo();
        }
    }

    private void logicaJogo()
    {
        gato.vrPosition.fX += 5;
        bulldog.vrPosition.fX -= 5;
        if(gato.collide(bulldog))
        {
            gato.bVisible = false;
            bulldog.bVisible = false;
            briga.bVisible = true;
        }
    }
}
