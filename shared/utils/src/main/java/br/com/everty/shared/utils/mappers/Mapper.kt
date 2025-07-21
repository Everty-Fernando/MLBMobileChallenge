package br.com.everty.shared.utils.mappers

interface Mapper<From, To> {
    fun toObject(fromObject: From): To

    fun toObjectList(fromObjectList: List<From>): List<To> {
        return fromObjectList.map { toObject(it) }
    }
}


