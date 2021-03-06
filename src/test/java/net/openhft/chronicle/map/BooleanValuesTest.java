/*
 *      Copyright (C) 2015  higherfrequencytrading.com
 *
 *      This program is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU Lesser General Public License as published by
 *      the Free Software Foundation, either version 3 of the License.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU Lesser General Public License for more details.
 *
 *      You should have received a copy of the GNU Lesser General Public License
 *      along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.openhft.chronicle.map;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Rob Austin.
 */
public class BooleanValuesTest {

    /**
     * see issue http://stackoverflow.com/questions/26219313/strange-npe-from-chronicle-map-toy-code
     */
    @Test
    public void testTestBooleanValues() throws IOException, InterruptedException {
        try (ChronicleMap<Integer, Boolean> map = ChronicleMap.of(Integer.class, Boolean.class)
                .entries(1).create()) {
            map.put(7, true);
            Assert.assertEquals(true, map.get(7));
        }
    }
}

