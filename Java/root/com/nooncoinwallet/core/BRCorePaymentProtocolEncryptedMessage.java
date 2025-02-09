/*
 * noocoinwallet
 *
 * Created by Ed Gamble <ed@noocoinwallet.com> on 1/22/18.
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


public class BRCorePaymentProtocolEncryptedMessage extends BRCoreJniReference {
    public BRCorePaymentProtocolEncryptedMessage (byte[] data) {
        super (createPaymentProtocolEncryptedMessage (data));
    }

    public native byte[] getMessage ();

    public BRCoreKey getReceiverPublicKey () {
        return new BRCoreKey (getReceiverPublicKeyReference());
    }

    public native long getReceiverPublicKeyReference ();

    public BRCoreKey getSenderPublicKey () {
        return new BRCoreKey (getSenderPublicKeyReference());
    }

    public native long getSenderPublicKeyReference ();

    public native long getNonce ();

    public native byte[] getSignature ();

    public native byte[] getIdentifier ();

    public native long getStatusCode ();

    public native String getStatusMessage ();

    private static native long createPaymentProtocolEncryptedMessage (byte[] data);

    public native byte[] serialize ();

    public native void disposeNative ();
}
