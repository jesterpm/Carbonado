/*
 * Copyright 2006 Amazon Technologies, Inc. or its affiliates.
 * Amazon, Amazon.com and Carbonado are trademarks or registered trademarks
 * of Amazon Technologies, Inc. or its affiliates.  All rights reserved.
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

package com.amazon.carbonado.spi;

import com.amazon.carbonado.FetchException;
import com.amazon.carbonado.PersistException;
import com.amazon.carbonado.Storable;

/**
 *
 *
 * @author Brian S O'Neill
 */
@Deprecated
public interface WrappedSupport<S extends Storable> extends TriggerSupport<S> {
    /**
     * @see Storable#load
     */
    void load() throws FetchException;

    /**
     * @see Storable#tryLoad
     */
    boolean tryLoad() throws FetchException;

    /**
     * @see Storable#insert
     */
    void insert() throws PersistException;

    /**
     * @see Storable#tryInsert
     */
    boolean tryInsert() throws PersistException;

    /**
     * @see Storable#update
     */
    void update() throws PersistException;

    /**
     * @see Storable#tryUpdate
     */
    boolean tryUpdate() throws PersistException;

    /**
     * @see Storable#delete
     */
    void delete() throws PersistException;

    /**
     * @see Storable#tryDelete
     */
    boolean tryDelete() throws PersistException;

    /**
     * Return another Support instance for the given Storable.
     */
    WrappedSupport<S> createSupport(S storable);
}
