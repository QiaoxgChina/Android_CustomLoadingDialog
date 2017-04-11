package com.qiaoxg.customdialog;

import com.qiaoxg.customdialog.custom.CustomLoadingDialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private CustomLoadingDialog mDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.showBtn).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mDialog == null) {
					mDialog = new CustomLoadingDialog(MainActivity.this);
					mDialog.setCancelOnClickOutSide(true);
					mDialog.setMessage("This is Message");
				} else {
					mDialog.setMessage("This is Message2");
				}
				mDialog.showDialog();
			}
		});

	}
}
