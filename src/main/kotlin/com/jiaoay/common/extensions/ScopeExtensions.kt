package com.jiaoay.common.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob


val ioScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

val mainScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

val defaultScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

val unconfinedScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())