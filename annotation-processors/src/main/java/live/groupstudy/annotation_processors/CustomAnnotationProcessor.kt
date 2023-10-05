package live.groupstudy.annotation_processors

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

class CustomAnnotationProcessor(private val codeGenerator: CodeGenerator,
                                private val logger: KSPLogger,
                                private val options: Map<String, String>): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
       return emptyList()
    }
}