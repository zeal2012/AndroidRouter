package com.zeal.android.router_module_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zeal.android.router_processor.Route;
import com.zeal.android.router_core.RouteConsts;
import com.zeal.android.router_core.Router;

@Route(path = RouteConsts.MODULE_1 + "/Module1ActivityTAG")
public class Module1Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_module_1);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class clazz = Router.getInstance().getClazz(RouteConsts.MODULE_2 + "/Module2Activity");
                startActivity(new Intent(Module1Activity.this, clazz));
            }
        });
    }
}
