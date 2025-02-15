/*
 * Copyright 2014-2024 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.utils.io

/** Alias for `java.io.Serializable` on JVM. Empty interface otherwise. */
@InternalAPI
public expect interface JvmSerializable

@InternalAPI
public interface JvmSerializer<T> : JvmSerializable {
    public fun jvmSerialize(value: T): ByteArray
    public fun jvmDeserialize(value: ByteArray): T
}

@Suppress("FunctionName")
@InternalAPI
public expect fun <T : Any> JvmSerializerReplacement(serializer: JvmSerializer<T>, value: T): Any

internal object DummyJvmSimpleSerializerReplacement
