package com.assignment.inherited.heating;

import com.assignment.base.ClientImpl;

public class HeatingClientImpl extends ClientImpl implements HeatingClient {
    private int mwh;

    public HeatingClientImpl () {}

    public HeatingClientImpl (ClientImpl orig, int mwh) {
        super(orig);
        setMwh(mwh);
    }
    @Override
    public int getMwh() {
        return this.mwh;
    }

    @Override
    public void setMwh(int mwh) {
        this.mwh = mwh > 0 ? mwh : 0;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", "
                + " mwh:" + mwh;
    }
}
