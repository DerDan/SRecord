package com.github.derdan.explorerextension.services

import com.github.derdan.explorerextension.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
