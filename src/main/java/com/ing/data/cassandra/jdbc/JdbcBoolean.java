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

import java.nio.ByteBuffer;
import java.sql.Types;

public class JdbcBoolean extends AbstractJdbcType<Boolean> {
    public static final JdbcBoolean instance = new JdbcBoolean();

    JdbcBoolean() {
    }

    public boolean isCaseSensitive() {
        return false;
    }

    public int getScale(final Boolean obj) {
        return -1;
    }

    public int getPrecision(final Boolean obj) {
        return -1;
    }

    public boolean isCurrency() {
        return false;
    }

    public boolean isSigned() {
        return false;
    }

    public String toString(final Boolean obj) {
        return obj.toString();
    }

    public boolean needsQuotes() {
        return false;
    }

    public String getString(final ByteBuffer bytes) {
        if (bytes.remaining() == 0) {
            return Boolean.FALSE.toString();
        }
        if (bytes.remaining() != 1) {
            throw new MarshalException("A boolean is stored in exactly 1 byte: " + bytes.remaining());
        }
        final byte value = bytes.get(bytes.position());

        return value == 0 ? Boolean.FALSE.toString() : Boolean.TRUE.toString();
    }

    public Class<Boolean> getType() {
        return Boolean.class;
    }

    public int getJdbcType() {
        return Types.BOOLEAN;
    }

    public Boolean compose(final Object value) {
        return (Boolean) value;
    }

    public Object decompose(final Boolean value) {
        return value;
    }
}
