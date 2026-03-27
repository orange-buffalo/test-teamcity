import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2024.12"

project {
    buildType(Build)
}

object Build : BuildType({
    name = "Build"
    description = "Clean install using Maven wrapper"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "Install SDKMAN and init Java"
            scriptContent = """
                #!/usr/bin/env bash
                set -e

                # Install SDKMAN if not already present
                if [ ! -d "${'$'}HOME/.sdkman" ]; then
                    curl -s "https://get.sdkman.io" | bash
                fi

                # Load SDKMAN
                export SDKMAN_DIR="${'$'}HOME/.sdkman"
                source "${'$'}HOME/.sdkman/bin/sdkman-init.sh"

                # Install and use Java version from .sdkmanrc
                sdk env install
                sdk env
            """.trimIndent()
        }
        script {
            name = "Maven clean install"
            scriptContent = """
                #!/usr/bin/env bash
                set -e

                export SDKMAN_DIR="${'$'}HOME/.sdkman"
                source "${'$'}HOME/.sdkman/bin/sdkman-init.sh"
                sdk env

                ./mvnw clean install
            """.trimIndent()
        }
    }

    requirements {
        exists("env.HOME")
    }
})
