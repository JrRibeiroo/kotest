package io.kotest.engine.extensions

import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.Spec
import io.kotest.engine.spec.AbstractSpec
import io.kotest.mpp.hasAnnotation
import kotlin.reflect.KClass

/**
 * Filters out any [AbstractSpec] annotated with @[Ignored].
 */
object IgnoredSpecDiscoveryExtension : DiscoveryExtension {
   override fun afterScan(classes: List<KClass<out Spec>>): List<KClass<out Spec>> {
      return classes.filterNot { it.hasAnnotation<Ignored>() }
   }
}