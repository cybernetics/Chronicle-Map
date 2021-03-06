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

package net.openhft.chronicle.hash.impl.stage.iter;

import net.openhft.chronicle.algo.hashing.LongHashFunction;
import net.openhft.chronicle.hash.impl.stage.entry.HashEntryStages;
import net.openhft.chronicle.hash.impl.stage.entry.KeyHashCode;
import net.openhft.chronicle.hash.impl.stage.entry.SegmentStages;
import net.openhft.sg.StageRef;
import net.openhft.sg.Staged;

@Staged
public class IterationKeyHashCode implements KeyHashCode {

    @StageRef SegmentStages s;
    @StageRef HashEntryStages<?> e;

    long keyHash = 0;

    void initKeyHash() {
        long addr = s.tierBaseAddr + e.keyOffset;
        long len = e.keySize;
        keyHash = LongHashFunction.xx_r39().hashMemory(addr, len);
    }

    @Override
    public long keyHashCode() {
        return keyHash;
    }
}
