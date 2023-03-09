package com.assignment.inherited.internet;

import com.assignment.base.ClientImpl;

import java.util.regex.Pattern;

public class InternetClientImpl extends ClientImpl implements InternetClient {
    private String ip;
    static final Pattern IPV4_PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public InternetClientImpl () {}

    public InternetClientImpl(ClientImpl orig, String ip) {
        super(orig);
        setIp(ip);
    }
    @Override
    public String getIp() {
        return this.ip;
    }

    @Override
    public void setIp(String ip) {
       if (validateIpv4(ip)) {
           this.ip = ip;
        } else {
            this.ip = "IP WAS ENTERED WRONG PLEASE CHANGE ASAP!!!";
        }
    }
    static boolean validateIpv4(final String ip) {
        return IPV4_PATTERN.matcher(ip).matches();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", "
                + " ip:" + ip;
    }

}
