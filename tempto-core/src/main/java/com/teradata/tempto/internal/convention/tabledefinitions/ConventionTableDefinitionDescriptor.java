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

package com.teradata.tempto.internal.convention.tabledefinitions;

import java.nio.file.Path;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkArgument;
import static com.teradata.tempto.internal.convention.SqlTestsFileUtils.getFilenameWithoutExtension;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

class ConventionTableDefinitionDescriptor
{
    private final String name;
    private final Path ddlFile;
    private final Path dataFile;
    private final Path revisionFile;

    public ConventionTableDefinitionDescriptor(Path ddlFile, Path dataFile, Path revisionFile)
    {
        checkArgument(exists(ddlFile) && isRegularFile(ddlFile), "Invalid file: %s", ddlFile);
        checkArgument(exists(dataFile) && isRegularFile(dataFile), "Invalid file: %s", dataFile);
        checkArgument(exists(revisionFile) && isRegularFile(revisionFile), "Invalid file: %s", revisionFile);

        this.name = getFilenameWithoutExtension(ddlFile);
        this.ddlFile = ddlFile;
        this.dataFile = dataFile;
        this.revisionFile = revisionFile;
    }

    public String getName()
    {
        return name;
    }

    public Path getDdlFile()
    {
        return ddlFile;
    }

    public Path getDataFile()
    {
        return dataFile;
    }

    public Path getRevisionFile()
    {
        return revisionFile;
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("name", name)
                .add("ddlFile", ddlFile)
                .add("dataFile", dataFile)
                .add("revisionFile", revisionFile)
                .toString();
    }
}
