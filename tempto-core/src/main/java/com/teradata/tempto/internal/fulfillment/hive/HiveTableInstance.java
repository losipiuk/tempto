/*
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
package com.teradata.tempto.internal.fulfillment.hive;

import com.teradata.tempto.fulfillment.hive.HiveTableDefinition;
import com.teradata.tempto.fulfillment.table.TableInstance;

import java.util.Optional;

public class HiveTableInstance
        extends TableInstance
{
    private final Optional<String> mutableDataHdfsDataPath;

    public HiveTableInstance(String name, String nameInDatabase, HiveTableDefinition tableDefinition, Optional<String> mutableDataHdfsDataPath)
    {
        super(name, nameInDatabase, tableDefinition);
        this.mutableDataHdfsDataPath = mutableDataHdfsDataPath;
    }

    public Optional<String> getMutableDataHdfsDataPath()
    {
        return mutableDataHdfsDataPath;
    }
}
