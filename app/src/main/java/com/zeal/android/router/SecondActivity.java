package com.zeal.android.router;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zeal.android.router.core.Route;
import com.zeal.android.router.core.RouteConsts;

@Route(path = RouteConsts.MODULE_APP + "/SecondActivity_tag")
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}