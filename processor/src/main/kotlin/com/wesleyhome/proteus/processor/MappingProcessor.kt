package com.wesleyhome.proteus.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

/**
 * Example KSP processor that demonstrates basic functionality.
 * This processor doesn't do any actual processing yet, but serves as a starting point.
 */
class MappingProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("ExampleProcessor is running")
        
        // This is where you would implement your symbol processing logic
        // For example, finding annotated classes and generating code
        
        // Return an empty list to indicate that all symbols have been processed
        return emptyList()
    }
}
