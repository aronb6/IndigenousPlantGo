package com.bcit.indigenousplantgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeActivity extends AppCompatActivity {
    private IntentIntegrator qrScan;

    public static final String EXTRA_MESSAGE = "com.bcit.indigenousplantgo.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        // new IntentIntegrator(this).initiateScan();

        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default is vertical, automatically change vertical or horizontal.
        qrScan.setPrompt("Find QR Code");
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(result.getContents()));
                try {
                    QRCodeActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
