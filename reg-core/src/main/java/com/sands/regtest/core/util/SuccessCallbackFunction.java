package com.sands.regtest.core.util;

import javax.ws.rs.core.Response;

/**
 * Created by mass on 12.08.2016.
 */
public interface SuccessCallbackFunction<T> {

    Response call(T request);
}
