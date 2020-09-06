package com.zeal.android.router_module_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zeal.android.router.core.Route;
import com.zeal.android.router.core.Router;

@Route(path = "/module2/Module2Activity")
public class Module2Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_2);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class clazzByAnnotation = Router.getInstance().getClazz("/app/SecondActivity_tag");
                startActivity(new Intent(Module2Activity.this, clazzByAnnotation));
            }
        });
    }
}
