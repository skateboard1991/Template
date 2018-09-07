package com.skateboard.moduleb

import com.skateboard.core.service.moduleb.ModuleBService

class ModuleBServiceImp : ModuleBService
{
    override fun getModuleBName(): String
    {
        return "moduleb"
    }
}