package com.assignment.inherited.phone;

import com.assignment.base.ClientImpl;

import java.util.regex.Pattern;

public class PhoneClientImpl extends ClientImpl implements PhoneClient {
    private String phoneNumber;
    static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?\\d{9,}$");

    public PhoneClientImpl() {
    }

    public PhoneClientImpl(ClientImpl orig, String phoneNumber) {
        super(orig);
        setNumber(phoneNumber);
    }

    @Override
    public String getNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setNumber(String number) {

        if (validatePhoneNumber(number)) {
            this.phoneNumber = number;
        } else {
            this.phoneNumber = "PHONE NUMBER WAS ENTERED WRONG PLEASE CHANGE ASAP!!!";
        }
    }

    static boolean validatePhoneNumber(final String phoneNumber) {
        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", "
                + " phone number:" + phoneNumber;
    }
}
