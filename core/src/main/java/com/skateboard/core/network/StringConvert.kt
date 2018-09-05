package com.skateboard.core.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class StringConvertFactory : Converter.Factory()
{

    companion object
    {
        fun create(): StringConvertFactory
        {
            return StringConvertFactory()
        }
    }


    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>?
    {
        annotations?.let {
            for (anno in annotations)
            {
                if (anno.annotationClass == STRING::class)
                {
                    return StringConvert()
                }
            }
        }

        return super.responseBodyConverter(type, annotations, retrofit)
    }

}


class StringConvert : Converter<ResponseBody, String>
{
    override fun convert(value: ResponseBody?): String
    {
        return value?.string() ?: ""
    }
}