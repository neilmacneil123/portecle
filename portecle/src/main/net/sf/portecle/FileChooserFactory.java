/*
 * FileChooserFactory.java
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

package net.sf.portecle;

import java.util.ResourceBundle;
import java.text.MessageFormat;
import javax.swing.*;
import net.sf.portecle.gui.FileExtFilter;

/**
 * Simple factory that returns JFileChooser objects for the requested security
 * file types. Basically just supplies a JFileChooser object with the file filter
 * box completed appropriately.
 */
public class FileChooserFactory extends Object
{
    /** Resource bundle */
    private static ResourceBundle m_res = ResourceBundle.getBundle("net/sf/portecle/resources");

    /** File extension for KeyStore files */
    private static final String KEYSTORE_EXT = "ks";

    /** File extension for Java KeyStore files */
    private static final String JAVA_KEYSTORE_EXT = "jks";

    /** File extension for PKCS #12 KeyStore files */
    private static final String PKCS12_KEYSTORE_EXT_1 = "pfx";

    /** File extension for PKCS #12 KeyStore files */
    private static final String PKCS12_KEYSTORE_EXT_2 = "p12";

    /** Description for KeyStore files */
    private static final String KEYSTORE_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.KeyStoreFiles"),
                             new String[]{KEYSTORE_EXT, JAVA_KEYSTORE_EXT, PKCS12_KEYSTORE_EXT_1, PKCS12_KEYSTORE_EXT_2});

    /** File extension for X.509 certificate files */
    private static final String X509_EXT_1 = "cer";

    /** File extension for X.509 certificate files */
    private static final String X509_EXT_2 = "crt";

    /** Description for X.509 certificate files */
    private static final String X509_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.CertificateFiles"),
                             new String[]{X509_EXT_1, X509_EXT_2});

    /** File extension for PKCS #7 certificate files */
    private static final String PKCS7_EXT = "p7b";

    /** Description for PKCS #7 certificate files */
    private static final String PKCS7_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.Pkcs7Files"),
                             new String[]{PKCS7_EXT});

    /** Description for PKCS #12 KeyStore files */
    private static final String PKCS12_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.Pkcs12Files"),
                             new String[]{PKCS12_KEYSTORE_EXT_1, PKCS12_KEYSTORE_EXT_2});

    /** File extension for PKCS #10 CSR files */
    private static final String CSR_EXT = "csr";

    /** Description for PKCS #10 CSR files */
    private static final String CSR_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.CsrFiles"),
                             new String[]{CSR_EXT});

    /** File extension for CRL files */
    private static final String CRL_EXT = "crl";

    /** Description for CRL files */
    private static final String CRL_FILE_DESC =
        MessageFormat.format(m_res.getString("FileChooseFactory.CrlFiles"),
                             new String[]{CRL_EXT});

    /** Private to prevent construction */
    private FileChooserFactory() {};

    /**
     * Get a JFileChooser filtered for KeyStore files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getKeyStoreFileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(new String[]{KEYSTORE_EXT, JAVA_KEYSTORE_EXT, PKCS12_KEYSTORE_EXT_1, PKCS12_KEYSTORE_EXT_2}, KEYSTORE_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for X.509 Certificate files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getX509FileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(new String[]{X509_EXT_1, X509_EXT_2}, X509_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for PKCS #7 Certificate files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getPkcs7FileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(PKCS7_EXT, PKCS7_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for X.509 and PKCS #7 Certificate files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getCertFileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(PKCS7_EXT, PKCS7_FILE_DESC));
        chooser.addChoosableFileFilter(new FileExtFilter(new String[]{X509_EXT_1, X509_EXT_2}, X509_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for PKCS #12 files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getPkcs12FileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(new String[]{PKCS12_KEYSTORE_EXT_1, PKCS12_KEYSTORE_EXT_2}, PKCS12_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for CSR files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getCsrFileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(CSR_EXT, CSR_FILE_DESC));
        return chooser;
    }

    /**
     * Get a JFileChooser filtered for CRL files.
     *
     * @return JFileChooser object
     */
    public static JFileChooser getCrlFileChooser()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileExtFilter(CRL_EXT, CRL_FILE_DESC));
        return chooser;
    }
}