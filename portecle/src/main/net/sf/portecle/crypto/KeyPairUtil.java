/*
 * KeyPairUtil.java
 *
 * Copyright (C) 2004 Wayne Grant
 * waynedgrant@hotmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * (This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.sf.portecle.crypto;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.security.*;
import java.security.spec.*;
import java.security.cert.Certificate;
import java.security.cert.*;

import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import org.bouncycastle.jce.*;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.util.encoders.*;
import org.bouncycastle.asn1.*;

/**
 * Provides utility methods for the generation of keys.
 */
public final class KeyPairUtil extends Object
{
    /** Resource bundle */
    private static ResourceBundle m_res = ResourceBundle.getBundle("net/sf/portecle/crypto/resources");

    /**
     * Private to prevent construction.
     */
    private KeyPairUtil() {}

    /**
     * Generate a key pair.
     *
     * @param keyPairType Key pair type to generate
     * @param iKeySize Key size of key pair
     * @return A keypair
     * @throws CryptoException If there was a problem generating the key pair
     */
    public static KeyPair generateKeyPair(KeyPairType keyPairType, int iKeySize)
        throws CryptoException
    {
        try
        {
            // Get a key pair generator
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(keyPairType.toString());

            // Create a SecureRandom
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");

            // Initialise key pair generator with key strength and a randomness
            keyPairGen.initialize(iKeySize, rand);

            // Generate and return the key pair
            KeyPair keyPair = keyPairGen.generateKeyPair();
            return keyPair;
        }
        catch (NoSuchAlgorithmException ex)
        {
            throw new CryptoException(MessageFormat.format(m_res.getString("NoGenerateKeypair.exception.message"), new Object[]{keyPairType}), ex);
        }
    }
}