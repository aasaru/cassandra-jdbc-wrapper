/*
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.ing.data.cassandra.jdbc;

public abstract class AbstractJdbcType<T> {
    public abstract boolean isCaseSensitive();

    public abstract int getScale(T obj);

    public abstract int getPrecision(T obj);

    public abstract boolean isCurrency();

    public abstract boolean isSigned();

    public abstract String toString(T obj);

    public abstract boolean needsQuotes();

    public abstract Class<T> getType();

    public abstract int getJdbcType();

    public abstract T compose(Object obj);

    public abstract Object decompose(T obj);
}
