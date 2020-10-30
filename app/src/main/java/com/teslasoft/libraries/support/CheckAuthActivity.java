package com.teslasoft.libraries.support;

import android.os.*;
import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.util.*;
import android.net.*;
import android.graphics.*;
import android.webkit.*;
import android.annotation.*;
import android.content.pm.*;
import java.text.*;

public class CheckAuthActivity extends Activity
{
	private LinearLayout next;
	private LinearLayout prev;
	private ProgressBar status;
	private TextView title;

	private View.OnClickListener prev_listener = new View.OnClickListener() {
		public void onClick(View v) {
			Prev(prev);
		}
	};

	private View.OnClickListener next_listener = new View.OnClickListener() {
		public void onClick(View v) {
			Next(next);
		}
	};

	public void onPointerCaptureChanged(boolean hasCapture)
	{

	}

	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        setContentView(R.layout.auth);
		
		next = (LinearLayout) findViewById(R.id.next);
		prev = (LinearLayout) findViewById(R.id.prev);
		status = (ProgressBar) findViewById(R.id.status);
		title = (TextView) findViewById(R.id.title);

		next.setOnClickListener(next_listener);
		prev.setOnClickListener(prev_listener);

		disable_prev();
		hide_prev();
		disable_next();
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				Intent i = new Intent(CheckAuthActivity.this, AuthActivity.class);
				startActivity(i);
				finish();
				overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
			}
		}, 2000);
    }

	@Override
	public void onBackPressed()
	{
		finish();
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
	}

	public void Next(View v)
	{

	}

	public void Prev(View v)
	{

	}

	public void hide_next()
	{
		next = (LinearLayout) findViewById(R.id.next);
		next.setVisibility(View.GONE);
	}

	public void hide_prev()
	{
		prev = (LinearLayout) findViewById(R.id.prev);
		prev.setVisibility(View.GONE);
	}

	public void show_next()
	{
		next = (LinearLayout) findViewById(R.id.next);
		next.setVisibility(View.VISIBLE);
	}

	public void show_prev()
	{
		prev = (LinearLayout) findViewById(R.id.prev);
		prev.setVisibility(View.VISIBLE);
	}

	public void disable_next()
	{
		next = (LinearLayout) findViewById(R.id.next);
		next.setEnabled(false);
		next.setAlpha(0.4f);
	}

	public void disable_prev()
	{
		prev = (LinearLayout) findViewById(R.id.prev);
		prev.setEnabled(false);
		prev.setAlpha(0.4f);
	}

	public void enable_next()
	{
		next = (LinearLayout) findViewById(R.id.next);
		next.setEnabled(true);
		next.setAlpha(1.f);
	}

	public void enable_prev()
	{
		prev = (LinearLayout) findViewById(R.id.prev);
		prev.setEnabled(true);
		prev.setAlpha(1.f);
	}
}
