/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;


@RequiresApi(api = Build.VERSION_CODES.P)
public class CameraActivity extends AppCompatActivity {
    Camera2BasicFragment camera2BasicFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        camera2BasicFragment = Camera2BasicFragment.newInstance();
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, camera2BasicFragment)
                    .commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(camera2BasicFragment.flag==0) camera2BasicFragment.captureStillPicture();
                camera2BasicFragment.flag = 1;

                return true;

            case KeyEvent.KEYCODE_VOLUME_UP:
                camera2BasicFragment.captureStillPicture();

                return true;
        }
        return true;
        //don't change volume
        //super.onKeyDown (keyCode, event)
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_DOWN:
                camera2BasicFragment.flag = 0;
                return true;

            case KeyEvent.KEYCODE_VOLUME_UP:
                camera2BasicFragment.flag = 0;
                return true;
        }
        return true;
    }


}
