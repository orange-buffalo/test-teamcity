import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"

project {

    vcsRoot(AppVcs)

    buildType {
        id("build-new")
        name = "Build New"

        vcs {
            root(AppVcs)
        }

        triggers {
            vcs {
                branchFilter = "+:*"
            }
        }

        requirements {
            contains("teamcity.agent.jvm.os.name", "Linux")
            matches("teamcity.agent.hardware.cpuCount", "1,2,4")
        }

        steps {
            script {
                name = "Install SDKMAN and Initialize JDK"
                scriptContent = """
                    #!/usr/bin/env bash
                    set -e

                    # Install SDKMAN if not already installed
                    if [ ! -d "${'$'}HOME/.sdkman" ]; then
                        curl -s "https://get.sdkman.io" | bash
                    fi

                    # Initialize SDKMAN
                    source "${'$'}HOME/.sdkman/bin/sdkman-init.sh"

                    # Install and use Java 17
                    sdk install java 17.0.11-tem || true
                    sdk use java 17.0.11-tem

                    java -version
                """.trimIndent()
            }

            script {
                name = "Run mvn install"
                scriptContent = """
                    #!/usr/bin/env bash
                    set -e

                    # Initialize SDKMAN and activate the installed JDK
                    source "${'$'}HOME/.sdkman/bin/sdkman-init.sh"
                    sdk use java 17.0.11-tem

                    mvn install
                """.trimIndent()
            }
        }
    }
}

object AppVcs : GitVcsRoot({
    id("AppVcs")
    name = "Application VCS Root"
    url = "https://github.com/%vcsRootUrl%"
    branch = "refs/heads/main"
    branchSpec = "+:refs/heads/*"
})

