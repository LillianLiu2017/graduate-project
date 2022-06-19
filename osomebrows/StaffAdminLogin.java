package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//staff can login to their pages by username and password
public class StaffAdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_admin_login);
    }

    public void staffReturnHome(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void staffLogin(View view){

        final EditText staffName = (EditText)findViewById(R.id.staffName);
        final EditText staffPassword = (EditText)findViewById(R.id.staffPassword);

        String username = staffName.getText().toString();
        String password = staffPassword.getText().toString();

        //judge the identity of the staff, and login their homepages
        switch (username){
            case "admin":
                if("admin".equals(password)){
                    Intent intent = new Intent();
                    intent.setClass(this,AdminHomepage.class);
                    startActivity(intent);
                    Toast.makeText(this,"success login",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "username or password Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "staff1":
                if("staff1".equals(password)){
                    Intent intent = new Intent();
                    intent.setClass(this,staffHomepage.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("staff1","staff1");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(this,"success login",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "username or password Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "staff2":
                if("staff2".equals(password)){
                    Intent intent = new Intent();
                    intent.setClass(this,staffHomepage.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("staff2","staff2");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(this,"success login",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "username or password Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "staff3":
                if("staff3".equals(password)){
                    Intent intent = new Intent();
                    intent.setClass(this,staffHomepage.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("staff3","staff3");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(this,"success login",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "username or password Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this, "username or password Error!", Toast.LENGTH_SHORT).show();
        }

    }

}
