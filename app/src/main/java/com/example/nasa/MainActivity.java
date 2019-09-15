package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable bearRenderable, catRenderable, koalaRenderable, lionRenderable;

    ImageView bear, cat, koala, lion;

    View arrayView[];
    ViewRenderable name_animal;

    int selected  = 1; //Default Bear is selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        setUpModel();

        bear = findViewById(R.id.bear);
        cat = findViewById(R.id.cat);
        koala = findViewById(R.id.koala);
        lion = findViewById(R.id.lion);

        setArrayView();

        setClickListener();

                arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
                    @Override
                    public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                        if (selected == 1){
                            Anchor anchor = hitResult.createAnchor();
                            AnchorNode anchorNode =  new AnchorNode(anchor);
                            anchorNode.setParent(arFragment.getArSceneView().getScene());

                            createModel(anchorNode, selected);
                        }
                    }
                });


    }

    private void setUpModel() {
        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this,"Unable to load bear model",Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1){
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();
        }
    }

    private void setClickListener() {
        for (int i=0; i<arrayView.length; i++){
            arrayView[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

    }

    private void setArrayView() {
        arrayView = new View[]{
            bear, cat, koala, lion
        };
    }
}
