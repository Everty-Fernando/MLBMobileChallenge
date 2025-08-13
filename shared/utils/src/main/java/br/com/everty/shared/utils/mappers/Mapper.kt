package br.com.everty.shared.utils.mappers

interface Mapper<From, To> {
    fun toObject(fromObject: From): To
}


