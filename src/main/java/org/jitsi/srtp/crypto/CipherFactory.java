/*
 * Copyright @ 2015 - present 8x8, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.srtp.crypto;

import java.security.*;

import java.util.*;
import javax.crypto.*;

/**
 * Factory which initializes a {@link Cipher} that is implemented by a {@link
 * Provider}.
 *
 * @author Lyubomir Marinov
 */
public class CipherFactory
{
    /**
     * The {@link Provider} which provides the implementations of the {@link
     * Cipher}s to be initialized by this instance.
     */
    private final Provider provider;

    /**
     * The name of the transformation.
     */
    private final String transformation;

    /**
     * Initializes a new {@link CipherFactory} instance which is to
     * initialize {@link Cipher}s that are implemented by a specific
     * {@link Provider}.
     *
     * @param transformation the name of the transformation
     * @param provider the {@link Provider} which provides the
     * implementations of the {@link Cipher} to be initialized.
     */
    public CipherFactory(String transformation, Provider provider)
    {
        this.transformation = Objects.requireNonNull(transformation);
        this.provider = Objects.requireNonNull(provider);
    }

    /**
     * Initializes a new {@link CipherFactory} instance which is to
     * initialize {@link Cipher}s that are implemented by a specific
     * {@link Provider}.
     *
     * @param transformation the name of the transformation
     * @param providerName the name of the {@link Provider} which
     * provides the implementations of the {@link Cipher} to be
     * initialized
     */
    public CipherFactory(String transformation, String providerName)
    {
        this(transformation, Security.getProvider(providerName));
    }

    public Cipher createCipher()
        throws Exception
    {
        return Cipher.getInstance(transformation, provider);
    }
}
