/*
 * noocoinwallet
 *
 * Created by Ed Gamble <ed@noocoinwallet.com> on 2/1/18.
 * Copyright (c) 2018 noocoinwallet LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.noocoinwallet.core;

public class BRCorePaymentProtocolACK extends BRCoreJniReference {
    public BRCorePaymentProtocolACK(byte[] data) {
        this(createPaymentProtocolACK(data));
    }

    protected BRCorePaymentProtocolACK(long jniReferenceAddress) {
        super (jniReferenceAddress);
    }

    public native String getCustomerMemo ();

    public native byte[] getMerchantData ();

    public native BRCoreTransaction[] getTransactions ();

    public native BRCoreTransactionOutput[] getRefundTo ();

    public native String getMerchantMemo ();

    private static native long createPaymentProtocolACK(byte[] data);

    public native byte[] serialize ();

    public native void disposeNative ();

    protected static native void initializeNative ();

    static { initializeNative(); }
}
