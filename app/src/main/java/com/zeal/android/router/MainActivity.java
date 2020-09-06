package com.zeal.android.router;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zeal.android.router.core.RouteConsts;
import com.zeal.android.router.core.Router;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_to_module_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Module1Activity.class));
                Class clazz = Router.getInstance().getClazz(RouteConsts.MODULE_1 + "/Module1ActivityTAG");
                startActivity(new Intent(MainActivity.this, clazz));
            }
        });


    }
}