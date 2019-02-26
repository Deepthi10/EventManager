package edu.ecu.cs.eventapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.Loader;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    private final String TAG = "LoginActivity";
    private static final int REQ_CODE = 9001;
    ImageView pirateimg;
 TextView mLoginText;
 EditText mEmailView;
 ImageView mEmailicon;
 ImageView mPwdicon;
 EditText mPasswordView;
 Button mEmailSignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pirateimg=(ImageView)findViewById(R.id.piratelogo);
        mLoginText=(TextView)findViewById(R.id.textlogin);
        mEmailView = (EditText)findViewById(R.id.email);;
        mEmailicon=(ImageView)findViewById(R.id.emailimg);
        mPwdicon=(ImageView)findViewById(R.id.pwdimg) ;
        mPasswordView = (EditText) findViewById(R.id.password);;
        mEmailSignInButton = (Button) findViewById(R.id.login);

        mEmailView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String s1=mEmailView.getText().toString();
                if (s1.length()>=1){
                    mEmailicon.setImageDrawable(getResources().getDrawable(R.drawable.mailactive));
                    mEmailSignInButton.setEnabled(true);
                }
                else {
                    mEmailicon.setImageDrawable(getResources().getDrawable(R.drawable.iconmail));
                    mEmailSignInButton.setEnabled(false);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        mPasswordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s2=mPasswordView.getText().toString();

                if(s2.length()>=1){
                    mPwdicon.setImageDrawable(getResources().getDrawable(R.drawable.pwdactive));
                    mEmailSignInButton.setEnabled(true);
                }
                else{
                    mPwdicon.setImageDrawable(getResources().getDrawable(R.drawable.iconpassword));
                    mEmailSignInButton.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEmailView.getText().toString().equals("abc")&& mPasswordView.getText().toString().equals("abc")){
                    Intent intent = new Intent(LoginActivity.this, EventActivity.class);
                    startActivity(intent);
                }
            }
        });


       /* mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEmailView.getText().toString().isEmpty()&&mPasswordView.getText().toString().isEmpty()){
                    AlertDialog.Builder alert=new AlertDialog.Builder(LoginActivity.this);
                    alert.setTitle("Alert!");
                    alert.setMessage("Enter valid Credentials.");
                    alert.setPositiveButton("Ok",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if(mEmailView.getText().toString().equals("abc")&&mPasswordView.getText().toString().equals("abc")){
                    Intent intent = new Intent(view.getContext(), EventActivity.class);
                    startActivity(intent);

                }

            }
        });*/




    }


}

