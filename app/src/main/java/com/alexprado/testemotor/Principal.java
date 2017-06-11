package com.alexprado.testemotor;

import com.alexprado.testemotor.AndGraph.AGActivityGame;
import android.os.Bundle;

public class Principal extends AGActivityGame
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Inicia o motor com acelerometro off
        init(this, false);

        PrimeiraCena cena1 = new PrimeiraCena(this.vrManager);
        SegundaCena cena2 = new SegundaCena(this.vrManager);

        vrManager.addScene(cena1);
        vrManager.addScene(cena2);
    }
}
