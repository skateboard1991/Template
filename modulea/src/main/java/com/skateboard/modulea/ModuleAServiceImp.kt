package com.skateboard.modulea

import com.skateboard.core.service.modulea.ModuleAService

class ModuleAServiceImp : ModuleAService
{
    override fun getModuleAName(): String
    {
        return "modulea"
    }
}