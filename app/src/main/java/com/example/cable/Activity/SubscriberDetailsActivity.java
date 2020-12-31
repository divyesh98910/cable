package com.example.cable.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cable.Model.Common;
import com.example.cable.Model.Subscriber;
import com.example.cable.R;

public class SubscriberDetailsActivity extends AppCompatActivity {
    TextView tvSubscriberName, tvSubscriberAddress, tvSubscriberMobile, tvSetupBox, pkgName, pkgPrice, pkgDescription, tvAreaName;
    Subscriber subscriber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customber_details);
        initView();

        if (subscriber != null) {
            if (subscriber.getName() != null && !subscriber.getName().isEmpty()) {
                tvSubscriberName.setText(subscriber.getName());
            }

            if (subscriber.getAddress() != null && !subscriber.getAddress().isEmpty()) {
                tvSubscriberAddress.setText(subscriber.getAddress());
            }

            if (subscriber.getMobileNo() != null && !subscriber.getMobileNo().isEmpty()) {
                tvSubscriberMobile.setText(subscriber.getMobileNo());
            }

            if (subscriber.getBoxId() != null && !subscriber.getBoxId().isEmpty()) {
                tvSetupBox.setText(subscriber.getBoxId());
            }

            if (subscriber.getPackageName() != null && !subscriber.getPackageName().isEmpty()) {
                pkgName.setText(subscriber.getPackageName());
            }

            if (subscriber.getPackageDesc() != null && !subscriber.getPackageDesc().isEmpty()) {
                pkgDescription.setText(subscriber.getPackageDesc());
            }

            if (subscriber.getPackagePrice() != null && !subscriber.getPackagePrice().isEmpty()) {
                pkgPrice.setText(subscriber.getPackagePrice());
            }

            if (subscriber.getAreaName() != null && !subscriber.getAreaName().isEmpty()) {
                tvAreaName.setText(subscriber.getAreaName());
            }
        }

    }

    private void initView() {
        subscriber = (Subscriber) getIntent().getSerializableExtra(Common.EXTRA_SUBSCRIBER);
        tvSetupBox = findViewById(R.id.tvSetupBox);
        tvSubscriberName = findViewById(R.id.tvSubscriberName);
        tvSubscriberAddress = findViewById(R.id.tvSubscriberAddress);
        tvSubscriberMobile = findViewById(R.id.tvSubscriberMobile);
        pkgDescription = findViewById(R.id.pkgDescription);
        pkgName = findViewById(R.id.pkgName);
        tvAreaName = findViewById(R.id.tvAreaName);
        pkgPrice = findViewById(R.id.pkgPrice);
    }
}