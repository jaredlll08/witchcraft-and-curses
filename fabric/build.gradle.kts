import com.blamejared.Properties
import com.blamejared.Versions
import com.blamejared.gradle.mod.utils.GMUtils
import net.darkhax.curseforgegradle.TaskPublishCurseForge
import net.darkhax.curseforgegradle.Constants as CFG_Constants

plugins {
    id("blamejared-modloader-conventions")
    id("fabric-loom") version "1.7-SNAPSHOT"
    id("com.modrinth.minotaur")
}

dependencies {
    minecraft("com.mojang:minecraft:${Versions.MINECRAFT}")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:${Versions.FABRIC_LOADER}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${Versions.FABRIC}")
    modCompileOnly("mezz.jei:jei-${Versions.MINECRAFT}-fabric-api:${Versions.JEI}")
    modRuntimeOnly("mezz.jei:jei-${Versions.MINECRAFT}-fabric:${Versions.JEI}")
    modImplementation("com.github.glitchfiend:TerraBlender-fabric:${Versions.MINECRAFT}-${Versions.TERRABLENDER}")
}

loom {
    accessWidenerPath.set(project(":common").file("src/main/resources/${Properties.MODID}.accesswidener"))
    mixin {
        defaultRefmapName.set("${Properties.MODID}.refmap.json")
    }
    runs {
        named("client") {
            client()
            configName = "Fabric Client"
            ideConfigGenerated(true)
            runDir("run")
        }
    }
}

tasks.create<TaskPublishCurseForge>("publishCurseForge") {
    dependsOn(tasks.remapJar)
    apiToken = GMUtils.locateProperty(project, "curseforgeApiToken")

    val mainFile = upload(Properties.CURSE_PROJECT_ID, tasks.remapJar.get().archiveFile)
    mainFile.changelogType = "markdown"
    mainFile.changelog = GMUtils.smallChangelog(project, Properties.GIT_REPO)
    mainFile.releaseType = CFG_Constants.RELEASE_TYPE_RELEASE
    mainFile.addJavaVersion("Java ${Versions.JAVA}")
    mainFile.addGameVersion(Versions.MINECRAFT)
    mainFile.addRequirement("fabric-api")
    mainFile.addRequirement("terrablender-fabric")

    doLast {
        project.ext.set("curse_file_url", "${Properties.CURSE_HOMEPAGE}/files/${mainFile.curseFileId}")
    }
}

modrinth {
    token.set(GMUtils.locateProperty(project, "modrinth_token"))
    projectId.set(Properties.MODRINTH_PROJECT_ID)
    changelog.set(GMUtils.smallChangelog(project, Properties.GIT_REPO))
    versionName.set("Fabric-${Versions.MINECRAFT}-$version")
    versionType.set("release")
    uploadFile.set(tasks.remapJar.get())
    dependencies {
        required.project("fabric-api")
        required.project("terrablender")
    }
}
tasks.modrinth.get().dependsOn(tasks.remapJar)
