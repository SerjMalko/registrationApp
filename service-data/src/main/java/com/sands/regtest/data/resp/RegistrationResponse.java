package com.sands.regtest.data.resp;

import com.sands.regtest.data.DefaultResponse;

/**
 * Created by mass on 11.08.2016.
 */
public class RegistrationResponse extends DefaultResponse{
    private boolean flag;

    public RegistrationResponse() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
