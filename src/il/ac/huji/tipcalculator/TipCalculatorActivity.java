package il.ac.huji.tipcalculator;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		final EditText txtBill = (EditText)findViewById(R.id.edtBillAmount);
		final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		final Button btnCalculate = (Button)findViewById(R.id.btnCalculate);
		final TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);
		btnCalculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {								 
				try{
					double bill = Double.parseDouble(txtBill.getText().toString());
					if(bill<0){
						return;
					}
					double tip = bill*0.12;
					if(chkRound.isChecked()){
						txtTipResult.setText("Tip: $"+Math.round(tip));
					}else{
						txtTipResult.setText("Tip: $"+tip);
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
