package com.zeal.android.router.third;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zeal.android.router.R;
import com.zeal.android.router.core.Route;
import com.zeal.android.router.core.RouteConsts;

@Route(path = RouteConsts.MODULE_APP + "/ThirdActivity_tag")
public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
}
