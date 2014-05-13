package cct.mobapp.c7141384app;

import cct.mobapp.c7141384app.database.DataBaseHandler;
import cct.mobapp.c7141384app.model.User;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserActivity extends Activity {
	
	private Button btnSelect, btnCreate, btnDelete, btnUpdate;
	private EditText etName, etEmail, etPassword, etCPassword;
	private DataBaseHandler db;
	public String name;
	public String email;
	public String password;
	public String cPassword;
	public User user;
		
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_layout);
		

		btnSelect = (Button) findViewById(R.id.btnSelect);
		btnCreate = (Button) findViewById(R.id.btnCreate);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etCPassword = (EditText) findViewById(R.id.etCPassword);
		
		db= new DataBaseHandler(this);
		
		
		btnSelect.setOnClickListener(onSelect);
		btnCreate.setOnClickListener(onCreate);
		btnDelete.setOnClickListener(onDelete);
		btnUpdate.setOnClickListener(onUpdate);
				
	
	}
	
		
		private View.OnClickListener onSelect = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
							
					name = etName.getText().toString();
					db.openWritable();
					user = db.getUser(name);
					db.close();
					if(user == null)
					{
						return;
					}
					else
					{
						etName.setText(user.getName());
						etEmail.setText(user.getEmail());
						etPassword.setText(user.getPassword());
						etCPassword.setText(user.getcPassword());
						Log.d("selected", "user selected"+user.getId());
						Toast.makeText(v.getContext(), " User Selected", 1).show();
					}
			}
		};
	
		
		private View.OnClickListener onCreate = new View.OnClickListener() {
			
			public void onClick(View v) {
				name = etName.getText().toString();
				email = etEmail.getText().toString();
				password = etPassword.getText().toString();
				cPassword = etCPassword.getText().toString();
				Log.d("user", "user");
				db.openWritable();
				db.addUser(new User(name, email, password, cPassword));
				db.close();
				Toast.makeText(v.getContext(), " User Inserted", 1).show();
			}
		};
		
		private View.OnClickListener onDelete= new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = etName.getText().toString();
				db.openWritable();
				db.deleteUser(user);
				db.close();
				Log.d("selected", "user selected"+user.getId());
				Toast.makeText(v.getContext(), " User Deleted", 1).show();
			}
		};

		private View.OnClickListener onUpdate = new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = etName.getText().toString();
				email = etEmail.getText().toString();
				password = etPassword.getText().toString();
				cPassword = etCPassword.getText().toString();
				Log.d("user", "user");
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setcPassword(cPassword);
				db.openWritable();
				db.updateUser(user);
				db.close();
				Toast.makeText(v.getContext(), "User Updated", 1).show();
			}
		};
		
}
	

